package appium;

import constants.GlobalVars;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.FileHandler;
import utils.ShellCmdUtils;

import java.io.File;
import java.io.IOException;

import static utils.OS.OSUtils.OSObj;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CapabilityManager {

  private static final ThreadLocal<String> deviceUDID = new ThreadLocal<>();
  private static final ThreadLocal<File> capabilityFile = new ThreadLocal<>();

  public static String getDeviceUDID() {
    return deviceUDID.get();
  }

  public static void setDeviceUDID(String udid) {
    deviceUDID.set(udid);
  }

  public static File getCapFile() {
    return capabilityFile.get();
  }

  public static void setCapFile(File file) {
    capabilityFile.set(file);
  }

  public static void unloadDeviceUDID() {
    deviceUDID.remove();
  }

  public static void unloadCapFile() {
    capabilityFile.remove();
  }

  public static DesiredCapabilities getDefaultAndroidCaps() throws IOException {
    String apkFilePath = FileHandler.getLastModifiedFilePath(GlobalVars.getAppPath(), "appdebug.apk");

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S21 FE 5G");
    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
    caps.setCapability(MobileCapabilityType.NO_RESET, true);
    caps.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
    caps.setCapability(MobileCapabilityType.APP, apkFilePath);
    return caps;
  }

  public static DesiredCapabilities getDefaultiOSCaps() throws IOException {
      String apkFilePath = FileHandler.getLastModifiedFilePath(GlobalVars.getAppPath(), ".app");

     DesiredCapabilities caps = new DesiredCapabilities();
     caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
     caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.2");
     caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro");
     caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
     caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
     caps.setCapability(MobileCapabilityType.FULL_RESET, true);
     caps.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
     caps.setCapability(MobileCapabilityType.APP, apkFilePath);
     caps.setCapability("bundleId", "com.jobadder.mobile.dev");
     caps.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG, true);
     caps.setCapability(IOSMobileCapabilityType.SHOW_IOS_LOG, false);
     caps.setCapability(IOSMobileCapabilityType.USE_NEW_WDA, true);
     caps.setCapability(IOSMobileCapabilityType.RESET_ON_SESSION_START_ONLY, true);
     caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
     return caps;
  } 

  public static String getAppPackage(String deviceName) {
    String appPackage =
        ShellCmdUtils.executeCmdWithOutput(
            "adb -s " + deviceName + " shell dumpsys window | " + OSObj.getGrepCmd() + " \"mCurrentFocus\"");
    appPackage = "com.".concat(appPackage.trim().split("/")[0].split("com.")[1]);
    return appPackage;
  }

  public static String getAppPackage() {
    String appPackage =
        ShellCmdUtils.executeCmdWithOutput("adb shell dumpsys window | " + OSObj.getGrepCmd() + " \"mCurrentFocus\"");
    appPackage = "com.".concat(appPackage.trim().split("/")[0].split("com.")[1]);
    return appPackage;
  }
}
