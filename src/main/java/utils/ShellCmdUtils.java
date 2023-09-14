package utils;

import constants.ConfigMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

import static utils.OS.OSUtils.OSObj;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShellCmdUtils {

  static final ProcessBuilder processBuilder = new ProcessBuilder();

  public static void executeCmdAndWait(String command, String message) {
    Process process = executeCmd(command);
    waitForProcess(process, String.format("Failed to execute [ %s ].", command) + message);
  }

  public static String executeCmdWithOutput(String command) {
    Process process = executeCmd(command);

    StringBuilder output = getCmdOutput(Objects.requireNonNull(process));
    waitForProcess(process, String.format("Failed to execute [ %s ] and retrieve output", command));

    return output.toString();
  }

  private static StringBuilder getCmdOutput(Process process) {
    StringBuilder output = new StringBuilder();
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;

    try {
      while ((line = reader.readLine()) != null) output.append(line).append("\n");
    } catch (Exception e) {
      throwException(e);
    }
    return output;
  }

  private static void waitForProcess(Process process, String message) {
    try {
      if (process.waitFor() != 0) {
        log.severe(message);
        System.exit(1);
      }
    } catch (Exception e) {
      throwException(e);
    }
  }

  private static Process executeCmd(String command) {
    try {
      OSObj.setPBCmd(processBuilder, command);
      return processBuilder.start();
    } catch (Exception e) {
      throwException(e);
      return null;
    }
  }

  @SuppressWarnings("checkstyle:LocalVariableName")
  public static void createEmulator(String emulatorName) {
    String pathToAVDFolder = System.getProperty("user.home").concat("\\.android\\avd\\");
    String pathToAVDEmulatorFolder = pathToAVDFolder.concat(emulatorName);
    String AVDPackage = PropertyUtils.get(ConfigMap.ADVPACKAGE);
    String createEmulatorCmd =
        String.format(
            "echo no | avdmanager create avd -n %s -k \"%s\" -p \"%s\" --force",
            emulatorName, AVDPackage, pathToAVDEmulatorFolder);

    executeCmd(createEmulatorCmd);
  }

  public static void startEmulator(String emulatorName) {
    String startEmulatorCmd = "emulator -avd ".concat(emulatorName);
    executeCmd(startEmulatorCmd);
    executeCmdAndWait("adb wait-for-device", "");
  }

  public static void killEmulator() {
    String killEmulatorCmd = "adb -e emu kill";
    executeCmd(killEmulatorCmd);
  }

  public static void deleteTestEmulator() {
    String deleteEmulatorCmd =
        "avdmanager delete avd -n ".concat(PropertyUtils.get(ConfigMap.EMULATORNAME));
    executeCmd(deleteEmulatorCmd);
  }

  public static String startStandaloneServer(String appiumURL) {
    String startStandaloneCmd =
        "cd grid && java -jar selenium-server-4.1.1.jar standalone --config config.toml --service-url \""
            + appiumURL
            + "\"";
    String url = "";
    BufferedReader reader =
        new BufferedReader(
            new InputStreamReader(
                Objects.requireNonNull(executeCmd(startStandaloneCmd)).getInputStream()));
    String line;

    try {
      while ((line = reader.readLine()) != null) {
        if (line.contains("Standalone")) {
          url = line.split("http://")[1];
          break;
        }
      }
    } catch (Exception e) {
      throwException(e);
    }

    ShellCmdUtils.executeCmd("curl http://".concat(url));
    return url;
  }

  public static void killStandaloneServer() {
    String killStandaloneServerCmd = "npx kill-port 4444";
    ShellCmdUtils.executeCmd(killStandaloneServerCmd);
  }

  public static void throwException(Exception e) {
    System.out.println("Cause is: " + e.getCause());
    System.out.println("Message is: " + e.getMessage());
    e.printStackTrace();
  }
}
