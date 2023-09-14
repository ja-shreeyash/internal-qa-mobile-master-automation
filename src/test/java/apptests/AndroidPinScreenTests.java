package apptests;

import basetest.BaseTestAndroid;
import common.ReusableComponents;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import screens.pinscreen.SetPinScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import static constants.FieldsText.*;

// USE FOLLOWING IMPORTS LATER
//import listeners.TestListener;
// import org.testng.annotations.Ignore;
// import org.testng.annotations.Listeners;
//import org.testng.annotations.Listeners;
// import screens.search.SearchScreen;
// import utils.PropertyUtils;
// import utils.RandomUtils;

    //@Listeners({TestListener.class})
@Owner("Shreeyash Nichkawade")
public class AndroidPinScreenTests extends BaseTestAndroid {
      SetPinScreen setpinscreen;
      AndroidLoginTests Androidlogintests;

  // PREVIOUS CODE USE LATER
  // SearchScreen searchScreen;
  // RandomUtils randomUtils;
  ReusableComponents reusable;

  @BeforeClass
  public void initialize() {
    setpinscreen = new SetPinScreen();

    // PREVIOUS CODE USE LATER
    // searchScreen = new SearchScreen();
    reusable = new ReusableComponents();
    // randomUtils = new RandomUtils();
  }

 
  @Title("Pin Screen Validations")
  @Description("Verify All fields and texts are present on set pin screen")
  @Test(groups = {"SMOKE"})
  public void PinScreenValidations() {
    Androidlogintests.loginIsSuccessfulWithCorrectCredentials();
    Assert.assertEquals(reusable.GetScreenTitle(), LOGIN_PAGE_Header);
    Assert.assertEquals(setpinscreen.checkIfSetPinTextIsDisplayed(), SP_SET_PIN);
    setpinscreen.checkIfPinDigitCounterIsDisplayed();
    setpinscreen.checkIfPinDigit_0_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_1_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_2_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_3_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_4_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_5_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_6_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_7_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_8_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_9_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigitDeleteButtonIsDisplayed();
    setpinscreen.checkIfBackToSigninButtonIsDisplayed();

  }
  @Title("Pin Screen User Input")
  @Description("Verify User is able to set the pin or not")
  @Test(groups = {"SMOKE"})
  public void PinScreenUserInput() {

    Androidlogintests.loginIsSuccessfulWithCorrectCredentials();
    Assert.assertEquals(reusable.GetScreenTitle(), LOGIN_PAGE_Header);
    Assert.assertEquals(setpinscreen.checkIfSetPinTextIsDisplayed(), SP_SET_PIN);
    setpinscreen.checkIfPinDigitCounterIsDisplayed();
    setpinscreen.checkIfPinDigit_0_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_1_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_2_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_3_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_4_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_5_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_6_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_7_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_8_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_9_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigitDeleteButtonIsDisplayed();
    setpinscreen.checkIfBackToSigninButtonIsDisplayed();
    setpinscreen.PinDigit_0_ButtonClick();
    setpinscreen.PinDigit_1_ButtonClick();
    setpinscreen.PinDigit_2_ButtonClick();
    setpinscreen.PinDigit_3_ButtonClick();

  }
  @Title("Confirm user PIN")
  @Description("Verify User is able to confirm the pin or not")
  @Test(groups = {"SMOKE"})
  public void PinScreenConfirmPIN() {
    Assert.assertEquals(reusable.GetScreenTitle(), LOGIN_PAGE_Header);
    Assert.assertEquals(setpinscreen.checkIfConfirmPinTextIsDisplayed(), SP_CONFIRM_PIN);
    setpinscreen.checkIfPinDigitCounterIsDisplayed();
    setpinscreen.checkIfPinDigit_0_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_1_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_2_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_3_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_4_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_5_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_6_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_7_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_8_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_9_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigitDeleteButtonIsDisplayed();
    setpinscreen.checkIfBackToSigninButtonIsDisplayed();
    setpinscreen.PinDigit_0_ButtonClick();
    setpinscreen.PinDigit_1_ButtonClick();
    setpinscreen.PinDigit_2_ButtonClick();
    setpinscreen.PinDigit_3_ButtonClick();

  }
   @Title("Back to Login Screen")
  @Description("Verify User is able to go back to sign in screen from pin screen")
  @Test(groups = {"SMOKE"})
  public void BackToSignIn() {
   Androidlogintests.loginIsSuccessfulWithCorrectCredentials();
    Assert.assertEquals(reusable.GetScreenTitle(), LOGIN_PAGE_Header);
    Assert.assertEquals(setpinscreen.checkIfSetPinTextIsDisplayed(), SP_SET_PIN);
    setpinscreen.checkIfPinDigitCounterIsDisplayed();
    setpinscreen.checkIfPinDigit_0_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_1_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_2_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_3_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_4_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_5_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_6_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_7_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_8_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigit_9_ButtonIsDisplayed();
    setpinscreen.checkIfPinDigitDeleteButtonIsDisplayed();
    setpinscreen.checkIfBackToSigninButtonIsDisplayed();
    setpinscreen.BackToSignIN_ButtonClick();

  }

  





    
}
