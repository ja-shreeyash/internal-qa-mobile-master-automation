package screens.login;

import base.Actions;
import base.ElementWait;
import driver.DriverManager;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import utils.ShellCmdUtils;

@Slf4j
public class LoginScreen extends LoginScreenElements {

  public boolean checkIfEmailFieldIsDisplayed() {
    return EMAIL_FIELD_ELE.isDisplayed();
  }

  public boolean checkIfPasswordFieldIsDisplayed() {
    return PASSWORD_FIELD_ELE.isDisplayed();
  }

  public boolean checkIfLoginButtonIsDisplayed() {
    return LOGIN_BUTTON_ELE.isDisplayed();
  }

  public boolean checkIfLoginButtonTagNameIsDisplayed() {
    return LOGIN_BUTTON_TAGNAME_ELE.isDisplayed();
  }

  @Step("Entering email address")
  public void enterEmailAddress(String userName) {
    log.info("Entering email address {}", userName);
    ElementWait.waitUntilElementPresent(EMAIL_FIELD_ELE);
    Actions.clearAndInput(EMAIL_FIELD_ELE, userName);
  }

  @Step("Entering password")
  public void enterPassword(String password) {
    log.info("Entering password");
    ElementWait.waitUntilElementPresent(PASSWORD_FIELD_ELE);
    Actions.clearAndInput(PASSWORD_FIELD_ELE, password);
  }

  @Step("Clicking on login button")
  public void clickLoginButton() {
    log.info("Clicking on Login button");
    ElementWait.waitUntilElementClickable(LOGIN_BUTTON_ELE);
    LOGIN_BUTTON_ELE.click();
  }

  @Step("Clicking on login choice button")
  public void clickLoginChoiceButton() {
    log.info("Clicking on Login choice button");
    ElementWait.waitUntilElementClickable(LOGIN_CHOICE_BUTTON_ID_ELE);
    LOGIN_CHOICE_BUTTON_ID_ELE.click();
  }

  @Step("Clicking on Sign In button")
  public void clickSignInButton() {
    log.info("Clicking on Sign In button");
    ElementWait.waitUntilElementClickable(SIGN_IN_ID);
    SIGN_IN_ID.click();
  }

  @Step("Checking if toast error message is displayed or not")
  public boolean getToastMessage(String message) {
    try {
      log.info("Checking if toast error message is displayed or not");
      Thread.sleep(1000);
      String xmlFormat = DriverManager.getDriver().getPageSource();
      if (xmlFormat.contains(message)) {
        return true;
      }
    } catch (InterruptedException e) {
      ShellCmdUtils.throwException(e);
    }
    return false;
  }

  public String getEmailFieldPlaceholderText() {
    ElementWait.waitUntilElementPresent(EMAIL_FIELD_ELE);
    return Actions.getTextFromElement(EMAIL_FIELD_ELE);
  }

  public String getPasswordFieldPlaceholderText() {
    ElementWait.waitUntilElementPresent(PASSWORD_FIELD_ELE);
    return Actions.getTextFromElement(PASSWORD_FIELD_ELE);
  }
}
