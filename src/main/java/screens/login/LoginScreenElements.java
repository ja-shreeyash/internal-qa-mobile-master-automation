package screens.login;

import common.CommonElements;
// import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
// import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// class LoginScreenLocators {

//   //    protected static final By EMAIL_FIELD_ID         = new
//   // By.ById("com.jobadder.jobadderapp:id/edtEmail");
//   //    protected static final By PASSWORD_FIELD_ID      = new
//   // By.ById("com.jobadder.jobadderapp:id/edtPassword");
//   //    protected static final By LOGIN_BUTTON_ID        = new
//   // By.ById("com.jobadder.jobadderapp:id/loadingButton");
//   //    protected static final By LOGIN_CHOICE_BUTTON_ID = new
//   // By.ById("com.jobadder.jobadderapp:id/tvEmailLink");
//   //    protected static final By LOGIN_BUTTON_TAGNAME   = By.tagName("button");

//   //    protected static final By EMAIL_FIELD_ID         =
//   // MobileBy.id("com.jobadder.jobadderapp:id/edtEmail");
//   //    protected static final By PASSWORD_FIELD_ID      =
//   // MobileBy.id("com.jobadder.jobadderapp:id/edtPassword");
//   //    protected static final By LOGIN_BUTTON_ID        =
//   // MobileBy.id("com.jobadder.jobadderapp:id/loadingButton");
//   //    protected static final By LOGIN_CHOICE_BUTTON_ID =
//   // MobileBy.id("com.jobadder.jobadderapp:id/tvEmailLink");
//   //    protected static final By LOGIN_BUTTON_TAGNAME   = MobileBy.tagName("button");

//   protected static final By EMAIL_FIELD_ID = AppiumBy.accessibilityId("userNameEntry");
//   protected static final By PASSWORD_FIELD_ID = AppiumBy.accessibilityId("passwordEntry");
//   protected static final By LOGIN_BUTTON_ID = AppiumBy.accessibilityId("loginButton");
//   protected static final By LOGIN_CHOICE_BUTTON_ID = AppiumBy.accessibilityId("loginChoiceButton");
//   protected static final By LOGIN_BUTTON_TAGNAME = By.tagName("button");
// }

@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public class LoginScreenElements extends CommonElements {

  // @AndroidFindBy(accessibility = "userNameEntry")
  @FindBy(css = "[content-desc='UserNameEntry']")
  @iOSXCUITFindBy(id = "userNameEntry") // Sample element capture separately for android and IOS
  protected WebElement EMAIL_FIELD_ELE;

  // @AndroidFindBy(accessibility = "passwordEntry")
  @FindBy(css = "[content-desc='PasswordEntry']")
  protected WebElement PASSWORD_FIELD_ELE;

  // @AndroidFindBy(accessibility = "loginButton")
  @FindBy(css = "[content-desc='LoginButton']")
  protected WebElement LOGIN_BUTTON_ELE;

  // @AndroidFindBy(accessibility = "loginChoiceButton")
  @FindBy(css = "[content-desc='LoginChoiceButton']")
  protected WebElement LOGIN_CHOICE_BUTTON_ID_ELE;

  @iOSXCUITFindBy(accessibility = "Sign in")
  protected WebElement SIGN_IN_ID;

  @AndroidFindBy(accessibility = "UserNameEntry")
  protected WebElement LOGIN_BUTTON_TAGNAME_ELE;
}
