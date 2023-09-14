package apptests;

import basetest.BaseTestiOS;
import common.ReusableComponents;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import screens.login.LoginScreen;
import screens.search.SearchScreen;
import utils.PropertyUtils;
import utils.RandomUtils;

import static constants.FieldsText.*;

@Listeners({TestListener.class})
@Owner("Van Pham")
public class LoginTests extends BaseTestiOS {
  LoginScreen loginScreen;
  SearchScreen searchScreen;
  RandomUtils randomUtils;
  ReusableComponents reusable;

  @BeforeClass
  public void initialize() {
    loginScreen = new LoginScreen();
    searchScreen = new SearchScreen();
    reusable = new ReusableComponents();
    randomUtils = new RandomUtils();
  }

  @Ignore
  @Title("Login page basic validations")
  @Description("Verify login page basic validations after app is launched")
  @Test(groups = {"SMOKE"})
  public void loginPageBasicValidations() {
    Assert.assertEquals(reusable.getScreenTitle(), SCREEN_TITLE);
    Assert.assertTrue(loginScreen.checkIfEmailFieldIsDisplayed(), "Email field is not present");
    Assert.assertEquals(loginScreen.getEmailFieldPlaceholderText(), PLACEHOLDER_TEXT_EMAIL_FIELD);
    Assert.assertTrue(
        loginScreen.checkIfPasswordFieldIsDisplayed(), "Password field is not present");
    Assert.assertEquals(
        loginScreen.getPasswordFieldPlaceholderText(), PLACEHOLDER_TEXT_PASSWORD_FIELD);
    Assert.assertTrue(
        loginScreen.checkIfLoginButtonTagNameIsDisplayed(), "Login button is not present");
  }

  @Ignore
  @Title("Login with correct credentials")
  @Description("Verify login is successful with valid credentials")
  @Test(groups = {"SMOKE"})
  public void loginIsSuccessfulWithCorrectCredentials() {
    loginScreen.enterEmailAddress(PropertyUtils.get("username"));
    loginScreen.enterPassword(PropertyUtils.get("password"));
    loginScreen.clickLoginButton();
    Assert.assertEquals(reusable.getScreenTitle(), SCREEN_TITLE);
    // Assert.assertTrue(searchScreen.checkIfSearchTextFieldIsDisplayed(), "Search field is missing");
    Assert.assertTrue(searchScreen.checkIfSearchButtonIsDisplayed(), "Search button is missing");
    // Assert.assertTrue(
        // searchScreen.checkIfClearSearchButtonIsDisplayed(), "Clear Search button is missing");
  }

  @Title("Login with incorrect credentials")
  @Description(
      "Verify login is not successful with invalid credentials and toast error message is displayed")
  @Test(groups = {"SMOKE"})
  public void verifyToastErrorMessageWithIncorrectCredentials() {
    loginScreen.enterEmailAddress(randomUtils.getRandomAlphanumericString(7));
    loginScreen.clickLoginChoiceButton();
    loginScreen.enterPassword(randomUtils.getRandomAlphanumericString(8));
    loginScreen.clickLoginButton();
    Assert.assertTrue(
        loginScreen.getToastMessage(TOAST_ERROR_MESSAGE), "Toast error message is not displayed");
  }

  @Title("testing iOS")
  @Description("testing iOS Sign in button")
  @Test(groups = {"SMOKE"})
  public void verifyClickingSignInButton() {
    loginScreen.clickSignInButton();
  }
}
