package screens.pinscreen;

// import base.Actions;
// import base.ElementWait;
// import driver.DriverManager;
// import io.qameta.allure.Step;
// import lombok.extern.slf4j.Slf4j;
// import utils.ShellCmdUtils;

public class SetPinScreen extends SetPinScreenElements{

    public boolean checkIfPageHeaderIsDisplayed() {
        return LOGIN_PAGE_HEADER.isDisplayed();
      }

    public boolean checkIfSetPinTextIsDisplayed() {
       return SP_SET_PIN_TEXT.isDisplayed();
    }

   public boolean checkIfConfirmPinTextIsDisplayed() {
       return SP_CONFIRM_PIN_TEXT.isDisplayed();
    }

    public boolean checkIfEnterPinTextIsDisplayed() {
       return SP_ENTER_PIN_TEXT.isDisplayed();
    }

    public boolean checkIfPinDigitCounterIsDisplayed() {
       return SP_PIN_DIGIT_COUNTER.isDisplayed();
    }

    public boolean checkIfPinDigit_1_ButtonIsDisplayed() {
       return SP_PIN_DIGIT_1.isDisplayed();
    }

    public boolean checkIfPinDigit_2_ButtonIsDisplayed() {
       return SP_PIN_DIGIT_2.isDisplayed();
    }

    public boolean checkIfPinDigit_3_ButtonIsDisplayed() {
       return SP_PIN_DIGIT_3.isDisplayed();
    }

    public boolean checkIfPinDigit_4_ButtonIsDisplayed() {
       return SP_PIN_DIGIT_4.isDisplayed();
    }

    public boolean checkIfPinDigit_5_ButtonIsDisplayed() {
       return SP_PIN_DIGIT_5.isDisplayed();
    }

    public boolean checkIfPinDigit_6_ButtonIsDisplayed() {
       return SP_PIN_DIGIT_6.isDisplayed();
    }

    public boolean checkIfPinDigit_7_ButtonIsDisplayed() {
       return SP_PIN_DIGIT_7.isDisplayed();
    }

    public boolean checkIfPinDigit_8_ButtonIsDisplayed() {
       return SP_PIN_DIGIT_8.isDisplayed();
    }

    public boolean checkIfPinDigit_9_ButtonIsDisplayed() {
       return SP_PIN_DIGIT_9.isDisplayed();
    }

    public boolean checkIfPinDigit_0_ButtonIsDisplayed() {
       return SP_PIN_DIGIT_0.isDisplayed();
    }

    public boolean checkIfPinDigitDeleteButtonIsDisplayed() {
       return  SP_PIN_DIGIT_DELETE.isDisplayed();
    }

    public void checkIfBackToSigninButtonIsDisplayed() {
        SP_BACK_TO_SIGNIN.isDisplayed();
    }

    public void checkIfForgotPinButtonIsDisplayed() {
       SP_FORGOT_PIN.isDisplayed();
    }

    public void  PinDigit_1_ButtonClick() {
       SP_PIN_DIGIT_1.click();
    }

    public void  PinDigit_2_ButtonClick() {
       SP_PIN_DIGIT_2.click();
    }

    public void  PinDigit_3_ButtonClick() {
       SP_PIN_DIGIT_3.click();
    }

    public void  PinDigit_4_ButtonClick() {
       SP_PIN_DIGIT_4.click();
    }

    public void  PinDigit_5_ButtonClick() {
       SP_PIN_DIGIT_5.click();
    }

    public void  PinDigit_6_ButtonClick() {
       SP_PIN_DIGIT_6.click();
    }

    public void  PinDigit_7_ButtonClick() {
       SP_PIN_DIGIT_7.click();
    }

    public void  PinDigit_8_ButtonClick() {
       SP_PIN_DIGIT_8.click();
    }

    public void  PinDigit_9_ButtonClick() {
       SP_PIN_DIGIT_9.click();
    }

    public void  PinDigit_0_ButtonClick() {
       SP_PIN_DIGIT_0.click();
    }

    public void  BackToSignIN_ButtonClick() {
       SP_BACK_TO_SIGNIN.click();
    }

    public void  ForgotPin_ButtonClick() {
       SP_FORGOT_PIN.click();
    }


}
