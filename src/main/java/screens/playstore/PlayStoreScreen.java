package screens.playstore;

import base.ElementWait;
import driver.DriverManager;
import io.appium.java_client.InteractsWithApps;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayStoreScreen extends PlayStoreScreenElements {
  @Step("Uninstalling app")
  public void uninstallApp(String appPackage) {
    log.info("Uninstalling app " + appPackage);
    InteractsWithApps driver = (InteractsWithApps) DriverManager.getDriver();
    driver.removeApp(appPackage);
  }

  public void cleanUIAutomator() {
    InteractsWithApps driver = (InteractsWithApps) DriverManager.getDriver();
    driver.removeApp("io.appium.uiautomator2.server");
    driver.removeApp("io.appium.uiautomator2.server.test");
  }

  @Step("Installing app from Play Store")
  public boolean installAppFromPlayStore(String appName) {
    log.info("Launching Play Store");
    InteractsWithApps driver = (InteractsWithApps) DriverManager.getDriver();
    // String appPackagePlayStore = "com.android.vending";
    String appPackagePlayStore = "com.jobadder.mobile";
    driver.terminateApp(appPackagePlayStore);
    driver.activateApp(appPackagePlayStore);

    log.info("Searching app " + appName + " from Play Store");
    ElementWait.waitUntilElementClickable(SEARCH_FIELD_ELE);
    SEARCH_FIELD_ELE.click();
    EDIT_TEXT_FIELD_ELE.sendKeys(appName);

    log.info("Selecting app " + appName + " from Play Store");
    ElementWait.waitUntilElementClickable(JOBADDER_SEARCH_SELECTION_ELE);
    JOBADDER_SEARCH_SELECTION_ELE.click();
    ElementWait.waitUntilElementClickable(JOBADDER_RECRUITMENT_SOFTWARE_SELECTION_ELE);
    JOBADDER_RECRUITMENT_SOFTWARE_SELECTION_ELE.click();

    log.info("Installing app " + appName + " from Play Store");
    ElementWait.waitUntilElementClickable(INSTALL_BUTTON_ELE);
    INSTALL_BUTTON_ELE.click();

    log.info("Waiting for installing app...");
    // 10 mins
    for (int i = 0; i < 10; i++) {
      ElementWait.waitUntilElementClickable(UNINSTALL_APP_BUTTON_ELE);
      if (UNINSTALL_APP_BUTTON_ELE.getAttribute("enabled").equals("true")) {
        OPEN_APP_BUTTON_ELE.click();
        log.info("Install app successfully.");
        break;
      } else {
        if (i == 9) {
          log.info("Install app failed.");
          return false;
        }
      }
    }
    return true;
  }
}
