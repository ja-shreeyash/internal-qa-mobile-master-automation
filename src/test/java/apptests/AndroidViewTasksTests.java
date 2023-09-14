package apptests;

import basetest.BaseTestAndroid;
import common.ReusableComponents;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import screens.dailyupdate.DailyUpdateScreen;
import screens.pinscreen.SetPinScreen;
import screens.viewtask.ViewTaskScreen;
import org.testng.annotations.BeforeClass;


// USE FOLLOWING IMPORTS LATER
//import listeners.TestListener;
// import org.testng.annotations.Ignore;
// import org.testng.annotations.Listeners;
//import org.testng.annotations.Listeners;
// import screens.search.SearchScreen;
// import utils.PropertyUtils;
// import utils.RandomUtils;
// import org.testng.Assert;
// import static constants.FieldsText.*;

@Owner("Shreeyash Nichkawade")
public class AndroidViewTasksTests extends BaseTestAndroid {

    DailyUpdateScreen dailyupdate;
    AndroidLoginTests Androidlogintests;
    SetPinScreen setpinscreen;
    ReusableComponents reusable;
    AndroidPinScreenTests Androidpinscreentests;
    ViewTaskScreen viewtask;
    AndroidDailyUpdateTests Androiddailyupdatetests;


@BeforeClass
public void initialize() {

    viewtask = new ViewTaskScreen();

    }

@Title("View Task Screen")
@Description("Verify the working of view task screen")
@Test(groups = {"SMOKE"})
public void ViewTasksOverview() {
    Androidlogintests.loginIsSuccessfulWithCorrectCredentials();
    Androidpinscreentests.PinScreenUserInput();
    Androidpinscreentests.PinScreenConfirmPIN();
    Androiddailyupdatetests.DailyUpdate_Without_Checkbox();
    viewtask.checkIfCalendarIconIsDisplayed();
    viewtask.checkIfCurrentDateIsDisplayed();
    viewtask.CheckIfTasksButtonIsDisplayed();
    viewtask.CheckIfInterviewsButtonIsDisplayed();
    viewtask.checkIfFilterButtonIsDisplayed();
    viewtask.clickFilterButton();
    viewtask.checkIfCancelButtonIsDisplayed();
    viewtask.checkIfApplyButtonIsDisplayed();
    viewtask.checkIfViewOverdueTasksButtonIsDisplayed();
    viewtask.checkIfViewCompletedTasksButtonIsDisplayed();
    viewtask.checkIfUpcomingButtonIsDisplayed();
    viewtask.checkIfPriorityButtonIsDisplayed();
    viewtask.clickGreyOutArea();
    viewtask.checkIfBottomSheetTasksButtonIsDisplayed();
    viewtask.checkIfBottomSheetSearchButtonIsDisplayed();
    viewtask.checkIfBottomSheetBigBobButtonIsDisplayed();
    viewtask.checkIfBottomSheetJobsButtonIsDisplayed();
    viewtask.checkIfBottomSheetFoldersButtonIsDisplayed();

}


@Title("View Task Screen")
@Description("Verify the working of view task screen")
@Test(groups = {"SMOKE"})
public void ViewTasksFilter() {
    Androidlogintests.loginIsSuccessfulWithCorrectCredentials();
    Androidpinscreentests.PinScreenUserInput();
    Androidpinscreentests.PinScreenConfirmPIN();
    Androiddailyupdatetests.DailyUpdate_Checkbox();
    viewtask.clickInterviewsButton();
    viewtask.checkIfGotoNextDayButtonIsDisplayed();
    viewtask.clickGotoNextDayButton();
    viewtask.clickTasksButton();
    viewtask.clickFilterButton();
    viewtask.click_VT_CancelButton();
    viewtask.clickFilterButton();
    viewtask.clickCompletedTasksButton();
    viewtask.clickViewOverdueTasksButton();
    viewtask.clickPriorityButton();
    viewtask.click_VT_ApplyButton();
    viewtask.GetFilterButtonText();
    viewtask.clickBottomSheetSearchButton();
    viewtask.clickBottomSheetBigBobButton();
    viewtask.clickGreyOutArea();
    viewtask.clickBottomSheetJobsButton();
    viewtask.clickBottomSheetFoldersButton();
    viewtask.clickBottomSheetTasksButton();
 
}
    
}


// Assert.assertEquals(viewtask.GetCurrentDayText(), DU_INTERVIEW);
    // viewtask.GetUpcomingTasksCountText();
    // viewtask.GetFilterButtonText();
    // viewtask.clickFilterButton();
    // viewtask.checkIfCancelButtonIsDisplayed();
    // Assert.assertTrue(viewtask.checkIfFilterTasksTextIsDisplayed(), VT_FILTER_TASKS);
    // viewtask.checkIfApplyButtonIsDisplayed();
    // Assert.assertTrue(viewtask.checkIfFilterTextIsDisplayed(), VT_FILTER);
    // Assert.assertTrue(viewtask.checkIfViewOverdueTasksTextIsDisplayed(), VT_OVERDUE_TASKS);
    // Assert.assertTrue(viewtask.checkIfViewOverdueTasksTextIsDisplayed(), VT_COMPLETED_TASKS);
    // Assert.assertTrue(viewtask.checkIfSortByTextIsDisplayed(), VT_SORT);
    // Assert.assertTrue(viewtask.checkIfupcomingTextIsDisplayed(), VT_UPCOMING);
    // Assert.assertTrue(viewtask.checkIfPriorityTextIsDisplayed(), VT_PRIORITY);