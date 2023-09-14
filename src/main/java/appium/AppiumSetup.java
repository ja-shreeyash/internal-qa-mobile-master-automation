package appium;

import constants.ConfigMap;
import constants.GlobalVars;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import utils.PropertyUtils;
import utils.ShellCmdUtils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import static utils.OS.OSUtils.OSObj;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppiumSetup {

  public static void startDefaultAppiumServer() {

    boolean flag = checkIfServerIsRunning(4723);
    if (!flag) {
      AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
      service.start();
      ServiceManager.setService(service);
    }
  }

  public static void startAppiumServer() {
    try {
      FileUtils.forceMkdir(new File(GlobalVars.getLogsDir()));
      String runMode = PropertyUtils.get(ConfigMap.RUNMODE);
      if (runMode.equalsIgnoreCase(GlobalVars.getLocal())
          || runMode.equalsIgnoreCase(GlobalVars.getGrid())) {
        AppiumDriverLocalService service = configAppiumDriverLocalService();
        service.start();
        ServiceManager.setService(service);
      }
    } catch (Exception e) {
      ShellCmdUtils.throwException(e);
      System.exit(1);
    }
  }

  private static AppiumDriverLocalService configAppiumDriverLocalService() {
    AppiumServiceBuilder builder = new AppiumServiceBuilder();
    builder
        .usingAnyFreePort()
        .withIPAddress(PropertyUtils.get(ConfigMap.IP))
        // .withAppiumJS(new File(PropertyUtils.get(ConfigMap.APPIUMJS)))
        .withAppiumJS(new File(OSObj.getAppiumPath()))
        .usingDriverExecutable(new File(OSObj.getNodePath()))
        .withLogFile(
            new File(
                GlobalVars.getLogsDir().concat(getDeviceConfig()
                    .concat(Thread.currentThread().getName())
                    .concat(".txt"))))
        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
        .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
        .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
        .withTimeout(Duration.ofSeconds(60));

    //        Map<String, String> env = new HashMap<>();
    //        env.put("JAVA_HOME", "");
    //        env.put("ANDROID_HOME", "");
    //        builder.withEnvironment(env);

    return AppiumDriverLocalService.buildService(builder);
  }

  private static String getDeviceConfig() {
    Object deviceUDID = CapabilityFileManager.getCap("name", CapabilityManager.getDeviceUDID());
    if (deviceUDID == null)
      return "";
    return String.valueOf(deviceUDID);
  }

  public static synchronized String getAvailableDeviceUDID() {
    HashMap<String, Boolean> connectedDevices = GlobalVars.getConnectedDevices();
    for (String udid : connectedDevices.keySet()) {
      if (!connectedDevices.get(udid)) {
        connectedDevices.replace(udid, true);
        return udid;
      }
    }
    return null;
  }

  public static synchronized void resetDeviceStatusFlag(String udid) {
    GlobalVars.getConnectedDevices().replace(udid, false);
  }

  public static boolean checkIfServerIsRunning(int port) {

    boolean isServerRunning = false;
    ServerSocket serverSocket;
    try {
      serverSocket = new ServerSocket(port);

      serverSocket.close();
    } catch (IOException e) {
      // If control comes here, then it means that the port is in use
      isServerRunning = true;
    }
    return isServerRunning;
  }

  public static void stopAppiumServer() {
    log.info(GlobalVars.getLogSeparator());
    log.info("[ Appium Server ] - Stopping Appium Server");
    log.info(GlobalVars.getLogSeparator());
    ServiceManager.getService().stop();
    System.out.println("Server is stopped successfully");
  }

  public static void getAppiumStatus(String host, String port) {
    try {
        URI uri = new URI("http", null, host, Integer.parseInt(port), "/wd/hub/status", null, null);
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int code = connection.getResponseCode();
        if (code == HttpURLConnection.HTTP_OK)
            System.out.println("Response code of Appium server is " + code + " OK");
    } catch (IOException | URISyntaxException e) {
        System.out.println("Response code of Appium server is ERROR");
    }
}

public static String getAppiumStatus() {
    try {
        String remoteURL = PropertyUtils.get(ConfigMap.REMOTEURL);
        URI uri = new URI(remoteURL.concat("/status"));
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int code = connection.getResponseCode();
        if (code == HttpURLConnection.HTTP_OK)
            System.out.println("Response code of Appium server is " + code + " OK");
        return remoteURL;
    } catch (IOException | URISyntaxException e) {
        System.out.println("Response code of Appium server is ERROR");
    }
    return null;
}

}
