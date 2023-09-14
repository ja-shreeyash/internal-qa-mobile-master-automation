package driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

/**
 * This class is responsible in setting and getting the web driver instance. <br/>
 * This is done for Thread safety. <br/>
 * Class is final to avoid extend. <br/>
 * <br/>
 * Jun 8, 2022
 *
 * @author Van Pham
 * @version 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverManager {

  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  /**
   * Get AppiumDriver < MobileElement > instance <br/>.
   * Jun 8, 2022
   *
   * @return WebDriver
   */
  public static WebDriver getDriver() {
    return driver.get();
  }

  /**
   * Setup the AppiumDriver < MobileElement > <br/>.
   * Jun 8, 2022
   *
   * @param driverRef instance variable for ThreadLocal of type AppiumDriver< MobileElement >.
   */
  public static void setDriver(WebDriver driverRef) {
    driver.set(driverRef);
  }

  /**
   * Removes the AppiumDriver < MobileElement > instance after execution. <br/>
   * Jun 8, 2022
   */
  static void unload() {
    driver.remove();
  }
}
