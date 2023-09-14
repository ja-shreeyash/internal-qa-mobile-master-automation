package common;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ShellCmdUtils;

/**
 * Common Elements class: Contains list of elements to be shared between multiple screens Will need
 * to specify the screen's identification to make sure the element act correctly. E.g. popup /
 * drawer that display over any screen. Default constructor will initElements using PageFactory
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public class CommonElements {
  // Sample common elements
  @AndroidFindBy(accessibility = "userNameEntry")
  @iOSXCUITFindBy(id = "userNameEntry") // Sample element capture separately for android and IOS
  protected WebElement EMAIL_FIELD_ELE;

  protected CommonElements() {
    try {
      PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    } catch (Exception e) {
      ShellCmdUtils.throwException(e);
    }
  }
}
