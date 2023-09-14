package basetest;

import appium.AppiumSetup;
import appium.CapabilityFileManager;
import appium.CapabilityManager;
import appium.ServiceManager;
import constants.ConfigMap;
import constants.GlobalVars;
import driver.DriverConfig;
import driver.DriverManager;
import io.appium.java_client.InteractsWithApps;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.PropertyUtils;
import utils.ShellCmdUtils;


import java.io.IOException;

/*
 * Before and After methods
 */
@Slf4j
public class BaseTestAndroid {

  private String appPackage = PropertyUtils.get(ConfigMap.APPPACKAGE);
  // private String appPackage = "com.jobadder.mobile";

  @BeforeTest(alwaysRun = true)
  protected void initDriver(ITestContext context) throws IOException {
    CapabilityFileManager.generateCapFile();
    log.info("Starting ...");
    String deviceUDID = AppiumSetup.getAvailableDeviceUDID();
    CapabilityManager.setDeviceUDID(deviceUDID);
    AppiumSetup.startAppiumServer();
    DriverConfig.initDriver(new DesiredCapabilities(CapabilityFileManager.readCaps()));
    appPackage = CapabilityManager.getAppPackage(deviceUDID);
  }

  @AfterMethod
  protected void resetApp() {
    InteractsWithApps driver = (InteractsWithApps) DriverManager.getDriver();
    log.info("Reset application " + appPackage);
    driver.terminateApp(appPackage);
    driver.activateApp(appPackage);
  }

  @AfterTest(alwaysRun = true)
  public void tearDown() {
    if (PropertyUtils.get(ConfigMap.AUTOKILLEMULATOR).equalsIgnoreCase(GlobalVars.getYes())) {
      log.info("Auto kill all emulator session");
      ShellCmdUtils.killEmulator();
    }

    log.info("Closing ...");
    GlobalVars.getConnectedDevices().put(CapabilityManager.getDeviceUDID(), false);
    DriverConfig.quitDriver();

    ServiceManager.stopService();
    ServiceManager.unloadService();

    if (PropertyUtils.get(ConfigMap.AUTODELETETESTEMULATOR).equalsIgnoreCase(GlobalVars.getYes())) {
      log.info("Auto delete testEmulator");
      ShellCmdUtils.deleteTestEmulator();
    }
  }
}
