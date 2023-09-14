package driver;

import appium.AppiumSetup;
import appium.ServiceManager;
import constants.ConfigMap;
import constants.GlobalVars;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
// import io.appium.java_client.ios.IOSDriver;
// import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.remote.options.BaseOptions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.FileHandler;
import utils.PropertyUtils;
import utils.ShellCmdUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Objects;

/**
 * Setup the web driver and removes it at the end of execution. <br/>
 * Class is final to avoid extend. <br/>
 * <br/>
 * Jun 8, 2022
 *
 * @author Van Pham
 * @version 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverConfig {

  private static DesiredCapabilities caps;

  /**
   * Setup the web driver for browser <br/>.
   * Jun 8, 2022
   *
  //  * @param desiredCaps Desired capabilities for the Appium driver
   */

   public static void quitDriver() {
    if (Objects.nonNull(DriverManager.getDriver())) {
      DriverManager.getDriver().quit();
      DriverManager.unload();
    }
  }
  public static void initDriver(DesiredCapabilities desiredCaps) {
    if (Objects.isNull(DriverManager.getDriver())) {
        try {
            caps = desiredCaps;
            WebDriver driver = getDriverByPlatform(Objects.requireNonNull(getRemoteAddress()));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            DriverManager.setDriver(driver);
        } catch (Exception e) {
            ShellCmdUtils.throwException(e);
        }
    }
}

  private static WebDriver getDriverByPlatform(URI remoteAddress) throws IOException {
    if (Objects.equals(caps.getCapability(MobileCapabilityType.PLATFORM_NAME).toString(), MobilePlatform.ANDROID)) {
        return new AndroidDriver(remoteAddress.toURL(), getAndroidOptions());
    }
    //  return new IOSDriver(remoteAddress.toURL(), getiOSOptions());
    return new AndroidDriver(remoteAddress.toURL(), getAndroidOptions());
    
}

  //  private static BaseOptions<?> getiOSOptions() throws IOException {
  //    String appFilePath = FileHandler.getLastModifiedFilePath(GlobalVars.getAppPath(), ".app");
  //    return new XCUITestOptions()
  //        .setApp(appFilePath)
  //        .eventTimings()
  //        .setDeviceName(String.valueOf(caps.getCapability("deviceName")));
  //  }

  private static BaseOptions<?> getAndroidOptions() throws IOException {
    String apkFilePath = FileHandler.getLastModifiedFilePath(GlobalVars.getAppPath(), ".apk");
    return new UiAutomator2Options()
        .setApp(apkFilePath)
        .eventTimings()
        .setUdid(String.valueOf(caps.getCapability("udid")));
  }

  private static URI getRemoteAddress() {
    String runMode = PropertyUtils.get(ConfigMap.RUNMODE);
    try {
        if (runMode.equalsIgnoreCase(GlobalVars.getLocal()))
            return ServiceManager.getService().getUrl().toURI();
        if (runMode.equalsIgnoreCase(GlobalVars.getGrid())) {
            String appiumURL = ServiceManager.getService().getUrl().toString();
            return new URI(
                    String.format("http://%s/wd/hub", ShellCmdUtils.startStandaloneServer(appiumURL)));
        }
        if (runMode.equalsIgnoreCase(GlobalVars.getExistingAppium()))
            return new URI(Objects.requireNonNull(AppiumSetup.getAppiumStatus()));
        return new URI("http://127.0.0.1:4723/wd/hub");
    } catch (URISyntaxException e) {
        throw new RuntimeException("Error while creating URI", e);
    }
}

public static void initDefaultDriver(DesiredCapabilities desiredCaps) {
  try {
      String serverUrl = "http://127.0.0.1:4723/wd/hub";
      AppiumDriver driver = new AppiumDriver(new URI(serverUrl).toURL(), desiredCaps);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

      DriverManager.setDriver(driver);
  } catch (URISyntaxException | MalformedURLException e) {
      ShellCmdUtils.throwException(e);
  }
}


}
