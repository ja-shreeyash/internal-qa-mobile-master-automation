package screens.login;
// import base.Actions;
// import base.ElementWait;
// import driver.DriverManager;
// import io.qameta.allure.Step;
// import lombok.extern.slf4j.Slf4j;
// import utils.ShellCmdUtils;



import base.ElementWait;

// @Slf4j
public class AndroidLoginScreen extends AndroidLoginScreenElements {

  public boolean checkIfPageHeaderIsDisplayed() {
    return LOGIN_PAGE_HEADER.isDisplayed();
  }

  public boolean checkIfEmailFieldTextIsDisplayed() {
    return EMAIL_FIELD_TEXT.isDisplayed();
  }

  public void EnterValidEmailId() {
    

    ElementWait.waitUntilElementPresent(EMAIL_ID_USERINPUT);
    EMAIL_ID_USERINPUT.sendKeys("thonguyen+au1@jobadder.com");
  }
  

  public void EnterValidPassword() {
    ElementWait.waitUntilElementPresent(PASSWORD_USERINPUT);
    PASSWORD_USERINPUT.sendKeys("$$JobAdder2023$$$");
  }

  public void EnterInValidPassword() {
    PASSWORD_USERINPUT.sendKeys("$$JobAdder2022$$$");
  }

  public boolean checkIfViewPasswordIsDisplayed(){
    ElementWait.waitUntilElementPresent(VIEW_PASSWORD);
    return VIEW_PASSWORD.isDisplayed();
  }

  public void clickViewPassword(){
    ElementWait.waitUntilElementPresent(VIEW_PASSWORD);
    VIEW_PASSWORD.click();
  }

  public boolean checkIfPasswordFieldTextIsDisplayed() {
    return PASSWORD_FIELD_TEXT.isDisplayed();
  }

   public boolean checkIfEmailFieldIsDisplayed() {
    return EMAIL_ID_USERINPUT.isDisplayed();
  }

  public boolean checkIfPasswordFieldIsDisplayed() {
    return PASSWORD_USERINPUT.isDisplayed();
  }
  public boolean checkIfSignInButtonIsDisplayed() {
    return SIGN_IN_BUTTON.isDisplayed();
  }
 public void SignIn(){
  ElementWait.waitUntilElementClickable(SIGN_IN_BUTTON);
    SIGN_IN_BUTTON.click();
  }
public boolean GetLoginFailedMsg() {
    return LS_ERROR_MSG.isDisplayed();
}

}

// Resusable code we can use it later
//   @Step(" user enter the email address")
//   public void enterEmailAddress(String userName) {
//     log.info("Entering email address {}", userName);
//     ElementWait.waitUntilElementPresent(EMAIL_FIELD_TEXT);
//     Actions.clearAndInput(EMAIL_ID_USERINPUT, userName);
//   }

//   // @Step("Entering email address")
//   // public void enterEmailAddress(String userName) {
//   //   log.info("Entering email address {}", userName);
//   //   ElementWait.waitUntilElementPresent(EMAIL_FIELD_ELE);
//   //   Actions.clearAndInput(EMAIL_FIELD_ELE, userName);
//   // }

//   @Step("Entering password")
//   public void enterPassword(String password) {
//     log.info("Entering password");
//     ElementWait.waitUntilElementPresent(PASSWORD_FIELD_TEXT);
//     Actions.clearAndInput(PASSWORD_USERINPUT, password);
//   }

//   @Step("Clicking on login button")
//   public void clickLoginButton() {
//     log.info("Clicking on Login button");
//     ElementWait.waitUntilElementClickable(SIGN_IN_TEXT);
//     SIGN_IN_BUTTON.click();
//   }

//   // @Step("Clicking on login choice button")
//   // public void clickLoginChoiceButton() {
//   //   log.info("Clicking on Login choice button");
//   //   ElementWait.waitUntilElementClickable(LOGIN_CHOICE_BUTTON_ID_ELE);
//   //   LOGIN_CHOICE_BUTTON_ID_ELE.click();
//   // }

//   // @Step("Clicking on Sign In button")
//   // public void clickSignInButton() {
//   //   log.info("Clicking on Sign In button");
//   //   ElementWait.waitUntilElementClickable(SIGN_IN_ID);
//   //   SIGN_IN_ID.click();
//   // }

//   // @Step("Checking if toast error message is displayed or not")
//   // public boolean getToastMessage(String message) {
//   //   try {
//   //     log.info("Checking if toast error message is displayed or not");
//   //     Thread.sleep(1000);
//   //     String xmlFormat = DriverManager.getDriver().getPageSource();
//   //     if (xmlFormat.contains(message)) {
//   //       return true;
//   //     }
//   //   } catch (InterruptedException e) {
//   //     ShellCmdUtils.throwException(e);
//   //   }
//   //   return false;
//   // }

//   // public String getEmailFieldPlaceholderText() {
//   //   ElementWait.waitUntilElementPresent(EMAIL_FIELD_ELE);
//   //   return Actions.getTextFromElement(EMAIL_FIELD_ELE);
//   // }

//   // public String getPasswordFieldPlaceholderText() {
//   //   ElementWait.waitUntilElementPresent(PASSWORD_FIELD_ELE);
//   //   return Actions.getTextFromElement(PASSWORD_FIELD_ELE);
//   // }
// }

