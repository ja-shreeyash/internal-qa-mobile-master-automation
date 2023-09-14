package utils.OS;

public interface OSUtils {
  String OSName = System.getProperty("os.name");

  OSUtils OSObj = MacUtils.isMatchingOS() ? new MacUtils() : new WindowsUtils();

  void setPBCmd(ProcessBuilder processBuilder, String command);

  String getAdbPath();

  String getNodePath();

  String getAppiumPath();

  String getGrepCmd();

}



