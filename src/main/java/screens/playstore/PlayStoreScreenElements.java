package screens.playstore;

import common.CommonElements;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public class PlayStoreScreenElements extends CommonElements {

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search for apps & games']")
  protected WebElement SEARCH_FIELD_ELE;

  @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search for apps & games']")
  protected WebElement EDIT_TEXT_FIELD_ELE;

  @AndroidFindBy(
      xpath =
          "//android.widget.TextView[@text='Install'] | //android.widget.Button[@text='Install']")
  protected WebElement INSTALL_BUTTON_ELE;

  @AndroidFindBy(
      xpath = "//android.widget.TextView[@text='Open'] | //android.widget.Button[@text='Open']")
  protected WebElement OPEN_APP_BUTTON_ELE;

  @AndroidFindBy(
      xpath =
          "//android.widget.TextView[@text='Uninstall'] | //android.widget.Button[@text='Uninstall']")
  protected WebElement UNINSTALL_APP_BUTTON_ELE;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='jobadder']")
  protected WebElement JOBADDER_SEARCH_SELECTION_ELE;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='JobAdder Recruitment Software']")
  protected WebElement JOBADDER_RECRUITMENT_SOFTWARE_SELECTION_ELE;
}
