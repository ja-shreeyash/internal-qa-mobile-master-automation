package utils;

import constants.ConfigMap;
import constants.GlobalVars;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Reading property from properties file. <br/>
 * Class is final to avoid extend. <br/>
 * <br/>
 * Jun 8, 2022
 *
 * @version 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertyUtils {

  private static final Properties property = new Properties();
  private static final Map<String, String> CONFIGMAP = new HashMap<>();

  static {
    try {
      FileInputStream fis = new FileInputStream(GlobalVars.getConfigProp());
      property.load(fis);
      for (Map.Entry<Object, Object> entry : property.entrySet()) {
        CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
      }
    } catch (IOException e) {
      ShellCmdUtils.throwException(e);
    }
  }

  public static String get(ConfigMap key) {
    if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
      try {
        throw new Exception(
            "Property name '"
                + Objects.requireNonNull(key).toString().toLowerCase()
                + "' not found. Please check the Config.properties");
      } catch (Exception e) {
        ShellCmdUtils.throwException(e);
      }
    }
    return CONFIGMAP.get(key.name().trim().toLowerCase());
  }

  public static String get(String key) {
    return CONFIGMAP.get(key.trim().toLowerCase());
  }
}
