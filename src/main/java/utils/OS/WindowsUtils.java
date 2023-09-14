package utils.OS;

import constants.ConfigMap;
import constants.GlobalVars;
import utils.PropertyUtils;

public final class WindowsUtils implements OSUtils {

  static boolean isMatchingOS() {
    return OSName.startsWith("Windows");
  }

  public String getAdbPath() {
    return System.getenv("ANDROID_HOME") + "\\platform-tools\\adb.exe";
  }

  public String getNodePath() {
    return System.getenv("ProgramFiles") + PropertyUtils.get(ConfigMap.NODEJSEXE);
  }

  public String getAppiumPath() {
    return GlobalVars.getUserHome() + PropertyUtils.get(ConfigMap.APPIUMJSEXE);
  }

  public void setPBCmd(ProcessBuilder processBuilder, String command) {
    processBuilder.command("cmd.exe", "/c", command);
  }

  public String getGrepCmd() {
    return "find";
  }
}



