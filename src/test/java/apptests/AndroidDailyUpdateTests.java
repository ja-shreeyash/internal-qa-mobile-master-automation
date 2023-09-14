package apptests;

import basetest.BaseTestAndroid;
import common.ReusableComponents;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import screens.dailyupdate.DailyUpdateScreen;
import screens.login.AndroidLoginScreen;
import screens.pinscreen.SetPinScreen;
import org.testng.annotations.BeforeClass;


// USE FOLLOWING IMPORTS LATER
//import listeners.TestListener;
// import org.testng.annotations.Ignore;
// import org.testng.annotations.Listeners;
//import org.testng.annotations.Listeners;
// import screens.search.SearchScreen;
// import utils.PropertyUtils;
// import utils.RandomUtils;
// import static constants.FieldsText.*;
// import org.testng.Assert;

@Owner("Shreeyash Nichkawade")
public class AndroidDailyUpdateTests extends BaseTestAndroid{
    DailyUpdateScreen dailyupdate;
    AndroidLoginScreen Androidloginscreen;
    SetPinScreen setpinscreen;
    ReusableComponents reusable;
    AndroidPinScreenTests Androidpinscreentests;
    AndroidLoginTests Androidlogintests;
    


@BeforeClass
public void initialize() {

    dailyupdate = new DailyUpdateScreen();
    }

@Title("Daily Update Screen")
@Description("Verify the Daily Update Screen when Checkbox is clicked")
@Test(groups = {"SMOKE"})
public void DailyUpdate_Without_Checkbox() {

      Androidlogintests.loginIsSuccessfulWithCorrectCredentials();
      Androidpinscreentests.PinScreenUserInput();
      Androidpinscreentests.PinScreenConfirmPIN();
      dailyupdate.checkIfUserGreetingIsDisplayed();
      dailyupdate.checkIfInterviewCountIsDisplayed();
      dailyupdate.checkIfJobsCountIsDisplayed();
      dailyupdate.checkIfPlacementsCountIsDisplayed();
      dailyupdate.GotItButtonClick();
      
      //   dailyupdate.checkIfGotItTextIsDisplayed();
      //   Assert.assertEquals(dailyupdate.checkIfMonthlyPlacementsTextIsDisplayed(), DU_PLACEMENTS);
      //   Assert.assertEquals(dailyupdate.checkIfJobsTextIsDisplayed(), DU_OPENJOBS);
      //   Assert.assertEquals(dailyupdate.checkIfInterviewTextIsDisplayed(), DU_INTERVIEW);
      //   dailyupdate.checkIfCurrentDateIsDisplayed();
  
    }

@Title("Daily Update Screen")
@Description("Verify the Daily Update Screen when Checkbox is clicked")
@Test(groups = {"SMOKE"})
public void DailyUpdate_Checkbox() {
      Androidlogintests.loginIsSuccessfulWithCorrectCredentials();
      Androidpinscreentests.PinScreenUserInput();
      Androidpinscreentests.PinScreenConfirmPIN();
      dailyupdate.checkIfUserGreetingIsDisplayed();
      dailyupdate.checkIfInterviewCountIsDisplayed();
      dailyupdate.checkIfJobsCountIsDisplayed();
      dailyupdate.checkIfPlacementsCountIsDisplayed();
      dailyupdate.DailyUpdateCheckbox();
      dailyupdate.GotItButtonClick();

  
    }

    
}
