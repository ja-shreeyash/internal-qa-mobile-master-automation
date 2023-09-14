package apptests;

import common.ReusableComponents;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;

import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basetest.BaseTestAndroid;
import ru.yandex.qatools.allure.annotations.Title;
import screens.login.AndroidLoginScreen;
import static constants.FieldsText.*;

// import org.testng.annotations.Ignore;
// import org.testng.annotations.Listeners;
// import listeners.TestListener;
// import utils.RandomUtils;
//  import screens.search.SearchScreen;
// import utils.PropertyUtils;

// @Listeners({TestListener.class})
@Owner("Shreeyash Nichkawade")
public class AndroidLoginTests extends BaseTestAndroid {
  AndroidLoginScreen Androidloginscreen;

  // PREVIOUS CODE USE LATER
  // SearchScreen searchScreen;
  // RandomUtils randomUtils;
  ReusableComponents reusable;

  public static void main(String[] args) {
    
}


  @BeforeClass
  public void initialize() {
    Androidloginscreen = new AndroidLoginScreen();
    reusable = new ReusableComponents();
   
  }

  @Ignore
  @Title("Login page basic validations")
  @Description("Verify login page basic validations after app is launched")
  @Test(groups = {"SMOKE"})
  public void loginPageBasicValidations() {
    // Assert.assertEquals(reusable.GetScreenTitle(), LOGIN_PAGE_Header);
    Assert.assertEquals(Androidloginscreen.checkIfEmailFieldTextIsDisplayed(), "Email Address");
    Assert.assertEquals(Androidloginscreen.checkIfPasswordFieldTextIsDisplayed(), "Password");
    Androidloginscreen.checkIfViewPasswordIsDisplayed();
    Androidloginscreen.clickViewPassword();
    Androidloginscreen.checkIfSignInButtonIsDisplayed();
   }

  @Title("Login with correct credentials")
  @Description("Verify login is successful with valid credentials")
  @Test(groups = {"SMOKE"})
  public void loginIsSuccessfulWithCorrectCredentials() {
  
    // Assert.assertEquals(reusable.GetScreenTitle(), LOGIN_PAGE_Header);
    // Assert.assertEquals(Androidloginscreen.checkIfEmailFieldTextIsDisplayed(), "Email Address");
    Androidloginscreen.EnterValidEmailId();
    // Assert.assertEquals(Androidloginscreen.checkIfPasswordFieldTextIsDisplayed(), "Password");
    Androidloginscreen.EnterValidPassword();
    Androidloginscreen.checkIfViewPasswordIsDisplayed();
    Androidloginscreen.clickViewPassword();
    Androidloginscreen.SignIn();
  }

  @Ignore
  @Title("Login with incorrect credentials")
  @Description("Verify login is not successful with invalid credentials and toast error message is displayed")
   @Test(groups = {"SMOKE"})
  public void verifyToastErrorMessageWithIncorrectCredentials() {
    // Assert.assertEquals(reusable.GetScreenTitle(), LOGIN_PAGE_Header);
    Assert.assertEquals(Androidloginscreen.checkIfEmailFieldTextIsDisplayed(), "Email Address");
    Androidloginscreen.EnterValidEmailId();
    Assert.assertEquals(Androidloginscreen.checkIfPasswordFieldTextIsDisplayed(), "Password");
    Androidloginscreen.EnterInValidPassword();
    Androidloginscreen.SignIn();
    Assert.assertEquals(Androidloginscreen.GetLoginFailedMsg(), TOAST_ERROR_MESSAGE);

   }

  }

  

 
  
  

