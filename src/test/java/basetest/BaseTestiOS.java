package basetest;

import appium.AppiumSetup;
import appium.CapabilityManager;
// import driver.DriverConfig;
import driver.DriverManager;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

@Slf4j
public class BaseTestiOS {


  @BeforeTest(alwaysRun = true)
  public void initDriver() throws IOException {
    log.info("Starting App");
    //temporally adding to bypass IOS config reader which is not yet implemented.
    CapabilityManager.setDeviceUDID("emulator-5554");
    AppiumSetup.startAppiumServer();
    // DriverConfig.initDriver(CapabilityManager.getDefaultiOSCaps());
  }

  @AfterTest(alwaysRun = true)
  public void tearDown() {
    log.info("Closing App");
    DriverManager.getDriver().quit();
    AppiumSetup.stopAppiumServer();
  }
}
