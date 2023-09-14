package utils.OS;


import constants.ConfigMap;
import constants.GlobalVars;
import utils.PropertyUtils;

public final class MacUtils implements OSUtils {

  static boolean isMatchingOS() {
    return OSName.startsWith("Mac");
  }

  public String getAdbPath() {
    return System.getenv("ANDROID_HOME") + "/platform-tools/adb";
  }

  public String getNodePath() {
    return GlobalVars.getUserHome() + PropertyUtils.get(ConfigMap.NODEJS);
  }

  public String getAppiumPath() {
    return GlobalVars.getUserHome() + PropertyUtils.get(ConfigMap.APPIUMJS);
  }

  public void setPBCmd(ProcessBuilder processBuilder, String command) {
    processBuilder.command("/bin/bash", "-c", command);
  }

  public String getGrepCmd() {
    return "grep";
  }

}



