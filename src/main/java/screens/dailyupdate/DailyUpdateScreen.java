package screens.dailyupdate;

import base.ElementWait;

// import base.Actions;
// import driver.DriverManager;
// import io.qameta.allure.Step;
// import lombok.extern.slf4j.Slf4j;
// import utils.ShellCmdUtils;

public class DailyUpdateScreen extends DailyUpdateScreenElements {

  public boolean checkIfUserGreetingIsDisplayed() {
    return DU_GREETING_USER.isDisplayed();
  }

  public boolean checkIfCurrentDateIsDisplayed() {
    return DU_DATE_CHECK.isDisplayed();
  }

  public boolean checkIfInterviewCountIsDisplayed() {
    return DU_INTERVIEW_COUNT.isDisplayed();
  }

   public boolean checkIfInterviewTextIsDisplayed() {
    return DU_INTERVIEW_TEXT.isDisplayed();
  }

   public boolean checkIfJobsCountIsDisplayed() {
    return DU_JOBS_COUNT.isDisplayed();
  }

   public boolean checkIfJobsTextIsDisplayed() {
    return DU_JOBS_TEXT.isDisplayed();
  }

   public boolean checkIfPlacementsCountIsDisplayed() {
    return DU_PLACEMENT_MONTHLY_COUNT.isDisplayed();
  }

  public boolean checkIfMonthlyPlacementsTextIsDisplayed() {
    return DU_PLACEMENT_MONTHLY_TEXT.isDisplayed();
  }
  
  public void DailyUpdateCheckbox() {
    ElementWait.waitUntilElementPresent(DU_CHECKBOX);
    // Actions.clickElementBy(DU_CHECKBOX);
    DU_CHECKBOX.click();
  }

   public boolean checkIfDUCheckboxTextIsDisplayed() {
    return DU_DONTSHOW_TEXT.isDisplayed();
  }

  public boolean checkIfGotItTextIsDisplayed() {
    return DU_GOT_IT_TEXT.isDisplayed();
  }


  public void GotItButtonClick() {
    ElementWait.waitUntilElementPresent(DU_GOT_IT_BUTTON);
    DU_GOT_IT_BUTTON.click();
  }

  public boolean checkIfGotItPopupTextIsDisplayed() {
    return DU_GOT_IT_POP_UP_MSG.isDisplayed();
  }


  public void GotItPopupButtonClick() {
    ElementWait.waitUntilElementPresent(DU_GOT_IT_POP_UP_BUTTON);
    DU_GOT_IT_POP_UP_BUTTON.click();
  }


}

