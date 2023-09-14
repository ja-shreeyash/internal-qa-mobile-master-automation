package common;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class ReusableLocators {

  protected static final By PAGE_TITLE_CLASS_NAME = By.className("android.widget.TextView");
  protected static final By PAGE_HEADER_XPATH = By.xpath("//android.widget.ImageView[@content-desc=\"pin-logo\"]");
}

/**
 * Reusable Elements class: Contains list of elements that able to be reused in different screens
 * (e.g: toast, header...) Works independently and no need to specify which screen is currently in
 * use
 */
public class ReusableElements extends CommonElements {

  @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
  @AndroidFindBy(accessibility = "userNameEntry")
  @iOSXCUITFindBy(id = "userNameEntry") // Sample element capture separately for android and IOS
  protected WebElement PAGE_TITLE_ELE;
}
