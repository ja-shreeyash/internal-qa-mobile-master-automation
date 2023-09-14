package appium;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.ConfigMap;
import constants.GlobalVars;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;
import se.vidstige.jadb.Stream;
import utils.FileHandler;
import utils.PropertyUtils;
import utils.ShellCmdUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;

import static utils.OS.OSUtils.OSObj;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CapabilityFileManager {

  public static void generateCapFile() {
    try {
      String adbPath = OSObj.getAdbPath();
      if (new File(adbPath).isFile()) {
        log.info(String.format("Executing file %s ...", adbPath));
      } else {
        log.severe(String.format(
            "The adb does not exist at %s. Please check your ANDROID_HOME environment variable "
                + "or folder Android\\Sdk\\platform-tools again.", adbPath));
      }
      String msg = "Failed to create capability file(s).";
      ShellCmdUtils.executeCmdAndWait(adbPath.concat(" start-server"), msg);
      createCapFile();
      ShellCmdUtils.executeCmdAndWait(adbPath.concat(" kill-server"), msg);
    } catch (Exception e) {
      ShellCmdUtils.throwException(e);
    }
  }

  public static void createCapFile() throws Exception {
    FileHandler.deleteDir(GlobalVars.getCapabilityDir());
    FileHandler.deleteDir(GlobalVars.getLogsDir());

    List<JadbDevice> devices = getJadbDevices();

    for (JadbDevice device : devices) {
      InputStream inputStream = device.executeShell("getprop ro.build.version.release");

      String serial = device.getSerial().trim();
      String platformVersion = Stream.readAll(inputStream, StandardCharsets.UTF_8).trim();
      String appPackage = PropertyUtils.get(ConfigMap.APPPACKAGE);
              //String appActivity = PropertyUtils.get(ConfigMap.APPACTIVITY);

      GlobalVars.getConnectedDevices().put(serial, false);
      FileHandler.createDir(GlobalVars.getCapabilityDir());

      String content = FileUtils.readFileToString(new File(GlobalVars.getCapabilityTemplate()), (String) null);
      content = content.replace("\"name\": \"\",", "\"name\": \"" + serial + "\",")
          .replace("\"udid\": \"\",", "\"udid\": \"" + serial + "\",")
          .replace("\"platformVersion\": \"\",", "\"platformVersion\": \"" + platformVersion + "\",")
          .replace("\"appPackage\": \"\",", "\"appPackage\": \"" + appPackage + "\",");
      //                    .replace("\"appActivity\": \"\"", "\"appActivity\": \"" + appActivity +
      // "\"");

      String pathname = GlobalVars.getCapabilityDir() + serial + ".json";
      FileUtils.writeStringToFile(new File(pathname), content, StandardCharsets.UTF_8);
    }
  }

  private static List<JadbDevice> getJadbDevices() throws IOException, JadbException {
    JadbConnection jadb = new JadbConnection();
    List<JadbDevice> devices = jadb.getDevices();

    if (devices.isEmpty()) {
      log.severe("Found 0 devices connected");
      if (PropertyUtils.get(ConfigMap.AUTOSTARTEMULATOR).equals("yes")) {
        log.severe("Run shell script to start emulator automatically");
        String emulatorName = ShellCmdUtils.executeCmdWithOutput("emulator -list-avds").split("\n")[0];
        String pathToAVDFolder = System.getProperty("user.home").concat("\\.android\\avd\\");

        if (emulatorName.isEmpty()) {
          log.severe("No emulator found, create new emulator");
          emulatorName = PropertyUtils.get(ConfigMap.EMULATORNAME);
          String testEmulatorFolder = pathToAVDFolder.concat(emulatorName);
          if (new File(testEmulatorFolder).exists()) {
            log.info("Clean test emulator folder before creating new");
            FileUtils.forceDelete(new File(testEmulatorFolder));
          }
          ShellCmdUtils.createEmulator(emulatorName);
        }

        if (emulatorName.equals(PropertyUtils.get(ConfigMap.EMULATORNAME))) {
          log.info("Create config and init file for testEmulator");
          String pathToAVDEmulatorFolder = pathToAVDFolder.concat(emulatorName);
          String emulatorFolder = System.getProperty("user.dir").concat("\\src\\test\\resources\\emulator");
          String configFile = "\\config.ini";
          String iniFile = String.format("\\%s.ini", emulatorName);

          FileUtils.copyFile(new File(emulatorFolder + configFile), new File(pathToAVDEmulatorFolder + configFile));
          FileUtils.copyFile(new File(emulatorFolder + iniFile), new File(pathToAVDFolder + iniFile));
        }

        log.info("Auto start emulator " + emulatorName);
        ShellCmdUtils.startEmulator(emulatorName);
        devices = jadb.getDevices();
      } else {
        log.severe("Check debugging option, start emulator or update autostartemulator=yes "
            + "in Config file to start emulator automatically");
        System.exit(1);
      }
    }
    return devices;
  }

  public static Map<String, Object> readCaps() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = getCap("capabilities", CapabilityManager.getDeviceUDID());
        return mapper.readValue(String.valueOf(obj), new TypeReference<Map<String, Object>>() {});
    }

  public static File getCapFile(String udid) {
    return new File(GlobalVars.getCapabilityDir() + udid + ".json");
  }

  public static Object getCap(String key, String udid) {
    if (CapabilityManager.getDeviceUDID() == null) {
      log.info("All devices are busy. Available device(s) 0.");
      Thread.currentThread().interrupt();
    }

    JSONParser jsonParser = new JSONParser();
    try {
      JSONArray jsonArray = (JSONArray) jsonParser.parse(
          new FileReader(GlobalVars.getResPath() + "capabilities/" + udid + ".json"));
      for (Object obj : jsonArray) {
        return ((JSONObject) obj).get(key);
      }
    } catch (Exception e) {
      ShellCmdUtils.throwException(e);
    }

    return null;
  }
}
