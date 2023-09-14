package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import constants.ConfigMap;
import constants.GlobalVars;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Reading property from JSON file. <br/>
 * Class is final to avoid extend. <br/>
 * <br/>
 * Jun 8, 2022
 *
 * @version 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("unchecked")
public final class JsonUtils {

  private static Map<String, String> CONFIGMAP;

  static {
    try {
      CONFIGMAP = new ObjectMapper().readValue(new File(GlobalVars.getConfigJson()), HashMap.class);
    } catch (IOException e) {
      ShellCmdUtils.throwException(e);
    }
  }

  public static String get(ConfigMap key) throws Exception {
    if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
      throw new Exception(
          "Property name '" + key + "' not found. Please check FrameworkConfig.json");
    }
    return CONFIGMAP.get(key.name().toLowerCase());
  }
}
