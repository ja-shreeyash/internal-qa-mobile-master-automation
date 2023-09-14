package screens.dailyupdate;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


// import org.openqa.selenium.support.FindBy;
// import common.CommonElements;
// import io.appium.java_client.AppiumBy;
// import io.appium.java_client.pagefactory.iOSXCUITFindBy;
// import org.openqa.selenium.By;

public class DailyUpdateScreenElements {
    
  //Good morning/afternoon/evening & username text
  @AndroidFindBy(id = "DailyUpdateScreenGreetingTextTag")
  protected WebElement  DU_GREETING_USER;

  //Check the date on page
  @AndroidFindBy(id = "")
  protected WebElement  DU_DATE_CHECK;

  //Daily update text
  @AndroidFindBy(id = "")
  protected WebElement  DU_DAILY_UPDATE_TEXT;

  //Interviews count- current day
  @AndroidFindBy(id = "DailyUpdateScreenInterviewsTag")
  protected WebElement  DU_INTERVIEW_COUNT;

  //Interviews text
  @AndroidFindBy(id = "")
  protected WebElement  DU_INTERVIEW_TEXT;

  //Jobs count- current day
  @AndroidFindBy(id = "DailyUpdateScreenOpenJobsTag")
  protected WebElement  DU_JOBS_COUNT;

  //Jobs text
  @AndroidFindBy(id = "")
  protected WebElement  DU_JOBS_TEXT;

  //Placement count- current day
  @AndroidFindBy(id = "DailyUpdateScreenPlacementsTag")
  protected WebElement  DU_PLACEMENT_MONTHLY_COUNT;

  // Placement made this month text
   @AndroidFindBy(id = "")
  protected WebElement  DU_PLACEMENT_MONTHLY_TEXT;

  //Checkbox to select- "Not to show this daily update page again"
  @AndroidFindBy(id = "DailyUpdateScreenDontShowTag")
  protected WebElement  DU_CHECKBOX;

  // Don't show Daily update page again text
  @AndroidFindBy(id = "")
  protected WebElement  DU_DONTSHOW_TEXT;

  //Got it text
  @AndroidFindBy(id = "")
  protected WebElement  DU_GOT_IT_TEXT;

  //Got it Button
  @AndroidFindBy(id = "DailyUpdateScreenGotItTag")
  protected WebElement  DU_GOT_IT_BUTTON;

  //Got it text
  @AndroidFindBy(id = "")
  protected WebElement  DU_GOT_IT_POP_UP_MSG;

   //Got it pop up button
  @AndroidFindBy(id = "")
  protected WebElement  DU_GOT_IT_POP_UP_BUTTON;






}
