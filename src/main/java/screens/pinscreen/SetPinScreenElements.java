package screens.pinscreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


// import org.openqa.selenium.support.FindBy;
// import common.CommonElements;
// import io.appium.java_client.AppiumBy;
// import org.openqa.selenium.By;

public class SetPinScreenElements {

    //JobAdder Header
  @AndroidFindBy(accessibility = "pin-logo")
  protected WebElement  LOGIN_PAGE_HEADER;

   //Set the pin text
  @AndroidFindBy(accessibility = "pin-hint")
  protected WebElement  SP_SET_PIN_TEXT;

  //Confirm your pin text
  @AndroidFindBy(accessibility = "pin-hint")
  protected WebElement SP_CONFIRM_PIN_TEXT;

  //Enter your pin text
  @AndroidFindBy(accessibility = "pin-hint")
  protected WebElement SP_ENTER_PIN_TEXT;

   //Pin digit counter
  @AndroidFindBy(accessibility = "pin-digit-counter")
  protected WebElement  SP_PIN_DIGIT_COUNTER;

  //pin-digit-1
  @AndroidFindBy(accessibility = "pin-digit-1")
  protected WebElement  SP_PIN_DIGIT_1;

  //pin-digit-2
  @AndroidFindBy(accessibility = "pin-digit-2")
  protected WebElement  SP_PIN_DIGIT_2;

  //pin-digit-3
  @AndroidFindBy(accessibility = "pin-digit-3")
  protected WebElement  SP_PIN_DIGIT_3;

  //pin-digit-4
  @AndroidFindBy(accessibility = "pin-digit-4")
  protected WebElement  SP_PIN_DIGIT_4;

  //pin-digit-5
  @AndroidFindBy(accessibility = "pin-digit-5")
  protected WebElement  SP_PIN_DIGIT_5;

  //pin-digit-6
  @AndroidFindBy(accessibility = "pin-digit-6")
  protected WebElement  SP_PIN_DIGIT_6;

  //pin-digit-7
  @AndroidFindBy(accessibility = "pin-digit-7")
  protected WebElement  SP_PIN_DIGIT_7;

  //pin-digit-8
  @AndroidFindBy(accessibility = "pin-digit-8")
  protected WebElement  SP_PIN_DIGIT_8;

  //pin-digit-9
  @AndroidFindBy(accessibility = "pin-digit-9")
  protected WebElement  SP_PIN_DIGIT_9;

  //pin-digit-0
  @AndroidFindBy(accessibility = "pin-digit-0")
  protected WebElement  SP_PIN_DIGIT_0;

  //Delete pin digits
  @AndroidFindBy(accessibility = "Biometrics")
  protected WebElement  SP_PIN_DIGIT_DELETE;

  //Back to sign in screen button
  @AndroidFindBy(id = "PinCodeScreenActionButtonTag")
  protected WebElement  SP_BACK_TO_SIGNIN;

  //Back to sign in screen button
  @AndroidFindBy(id = "PinCodeScreenActionButtonTag")
  protected WebElement  SP_FORGOT_PIN;

  // wrong pin error message
  @AndroidFindBy(id ="PinCodeScreenActionButtonTag")
  protected WebElement SP_ERROR_MSG;

    
}
