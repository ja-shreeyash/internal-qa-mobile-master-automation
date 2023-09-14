package screens.login;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// import org.openqa.selenium.By;
// import common.CommonElements;
// import io.appium.java_client.AppiumBy;
// import org.openqa.selenium.support.FindBy;

// code by Shreeyash on Android
// @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
// Add common elements after "extends CommonElements"
 public class AndroidLoginScreenElements  {

  protected static final By EMAIL_FIELD_ID = AppiumBy.accessibilityId("userNameEntry");
  protected static final By PASSWORD_FIELD_ID = AppiumBy.accessibilityId("passwordEntry");
  protected static final By LOGIN_BUTTON_ID = AppiumBy.accessibilityId("loginButton");

  //Login Screen Header "JobAdder"
  @AndroidFindBy(accessibility = "pin-logo")
  protected WebElement  LOGIN_PAGE_HEADER;

  //Email Address text
  @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"text-field-label\"])[1]")
  protected WebElement EMAIL_FIELD_TEXT;

   // Password field text
  @AndroidFindBy(xpath ="(//android.widget.TextView[@content-desc=\"text-field-label\"])[2]")
  protected WebElement PASSWORD_FIELD_TEXT;

  // Email Address user input
  @AndroidFindBy(accessibility = "login email field")
  protected WebElement EMAIL_ID_USERINPUT;

  // // Email Address user input
  // @FindBy(id = "LoginScreenEmailTag")
  // protected WebElement EMAIL_ID_INPUT;


  // Password user input
  @AndroidFindBy(accessibility = "login password field")
  protected WebElement PASSWORD_USERINPUT;

  // View password 
  @AndroidFindBy(accessibility = "Clear")
  protected WebElement VIEW_PASSWORD;
  
  // Sign in button click
  @AndroidFindBy(accessibility  = "login action button")
  protected WebElement SIGN_IN_BUTTON;

  // Get Error text message
  @AndroidFindBy(className ="android.widget.TextView")
  protected WebElement LS_ERROR_MSG;


}



//   // @AndroidFindBy(accessibility = "userNameEntry")
//   @FindBy(css = "[content-desc='UserNameEntry']")
//   //@iOSXCUITFindBy(id = "userNameEntry") // Sample element capture separately for android and IOS
//   protected WebElement EMAIL_FIELD_ELE;

//   // @AndroidFindBy(accessibility = "passwordEntry")
//   @FindBy(css = "[content-desc='PasswordEntry']")
//   protected WebElement PASSWORD_FIELD_ELE;

//   // @AndroidFindBy(accessibility = "loginButton")
//   @FindBy(css = "[content-desc='LoginButton']")
//   protected WebElement LOGIN_BUTTON_ELE;

//   // @AndroidFindBy(accessibility = "loginChoiceButton")
//   @FindBy(css = "[content-desc='LoginChoiceButton']")
//   protected WebElement LOGIN_CHOICE_BUTTON_ID_ELE;

//   // @iOSXCUITFindBy(accessibility = "Sign in")
//   // protected WebElement SIGN_IN_ID;

//   @AndroidFindBy(accessibility = "UserNameEntry")
//   protected WebElement LOGIN_BUTTON_TAGNAME_ELE;

 // Default Email Address
  // @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]/android.view.View[2]/android.widget.TextView")
  // protected WebElement EMAIL_DEFAULT_TEXT;

  // Default password
  // @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]/android.view.View[2]/android.widget.TextView")
  // protected WebElement PASSWORD_DEFAULT_TEXT;

// sign in text
  // @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.TextView")
  // protected WebElement SIGN_IN_TEXT;
