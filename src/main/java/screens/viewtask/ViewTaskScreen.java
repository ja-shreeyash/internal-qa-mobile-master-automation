package screens.viewtask;

// import base.Actions;
// import driver.DriverManager;
// import io.qameta.allure.Step;
// import lombok.extern.slf4j.Slf4j;
// import utils.ShellCmdUtils;
// import base.ElementWait;

public class ViewTaskScreen extends ViewTaskScreenElements{

    public boolean checkIfCalendarIconIsDisplayed() {
        return VT_CALENDAR_ICON_BUTTON.isDisplayed();
      }

    public void clickCalendarIcon() {
        VT_CALENDAR_ICON_BUTTON.click();
      }
      
    public String GetCurrentDayText() {
        return VT_CURRENTDATE_TEXT_BUTTON.getText();
    }

    public boolean checkIfCurrentDateIsDisplayed() {
        return VT_CURRENTDATE_TEXT_BUTTON.isDisplayed();
      }

    public void clickonCurrentDate() {
        VT_CURRENTDATE_TEXT_BUTTON.click();
    }

    public boolean CheckIfTasksButtonIsDisplayed() {
        return VT_TASKS_BUTTON.isDisplayed();
    }

    public void clickTasksButton() {
        VT_TASKS_BUTTON.click();
    }

    public boolean CheckIfInterviewsButtonIsDisplayed() {
        return VT_INTERVIEWS_BUTTON.isDisplayed();
    }

    public void clickInterviewsButton() {
        VT_INTERVIEWS_BUTTON.click();
    }

    public boolean checkIfFilterButtonIsDisplayed(){
        return VT_FILTER_BUTTON.isDisplayed();
    }

    public void GetFilterButtonText() {
        VT_FILTER_BUTTON.getText();
    }

    public void clickFilterButton() {
        VT_FILTER_BUTTON.click();
    }

    public boolean checkIfCancelButtonIsDisplayed() {
       return VT_CANCEL_BUTTON.isDisplayed();
    }


    public void click_VT_CancelButton() {
       VT_CANCEL_BUTTON.click();
    }

    public boolean checkIfApplyButtonIsDisplayed() {
       return VT_APPLY_BUTTON.isDisplayed();

    }

     public void click_VT_ApplyButton() {
       VT_APPLY_BUTTON.click();
    }

    // Need to check the other way how to check if the button is disabled
    public boolean checkIfApplyButtonIsDisabled() {
       return VT_APPLY_BUTTON.isEnabled();
    }

    public boolean checkIfFilterTextIsDisplayed() {
        return VT_FILTER_TEXT.isDisplayed();
    }

     public boolean checkIfViewOverdueTasksTextIsDisplayed() {
        return VT_VIEW_OVERDUE_TASK_TEXT.isDisplayed();
    }

     public boolean checkIfViewOverdueTasksButtonIsDisplayed() {
        return VT_VIEW_OVERDUE_TASK_BUTTON.isDisplayed();
    }

    public void clickViewOverdueTasksButton() {
        VT_VIEW_OVERDUE_TASK_BUTTON.click();
    }

     public boolean checkIfViewCompletedTasksTextIsDisplayed() {
        return VT_VIEW_COMPLETED_TASK_TEXT.isDisplayed();
    }

    public boolean checkIfViewCompletedTasksButtonIsDisplayed() {
        return VT_VIEW_COMPLETED_TASK_BUTTON.isDisplayed();
    }

    public void clickCompletedTasksButton() {
        VT_VIEW_COMPLETED_TASK_BUTTON.click();
    }

    public boolean checkIfSortByTextIsDisplayed() {
        return VT_SORTBY_TEXT.isDisplayed();
    }

    public boolean checkIfupcomingTextIsDisplayed() {
        return VT_UPCOMING_TEXT.isDisplayed();
    }

    public boolean checkIfUpcomingButtonIsDisplayed() {
        return VT_RADIO_UPCOMING_BUTTON.isDisplayed();
    }

    public void clickUpcomingButton() {
        VT_RADIO_UPCOMING_BUTTON.click();
    }

    public boolean checkIfPriorityTextIsDisplayed() {
        return VT_PRIORITY_TEXT.isDisplayed();
    }

    public boolean checkIfPriorityButtonIsDisplayed() {
        return VT_RADIO_PRIORITY_BUTTON.isDisplayed();
    }

    public void clickPriorityButton() {
        VT_RADIO_PRIORITY_BUTTON.click();
    }

    public boolean checkIfGotoNextDayButtonIsDisplayed() {
        return VT_GOTO_NEXTDAY_BUTTON.isDisplayed();
    }

    public void clickGotoNextDayButton() {
        VT_GOTO_NEXTDAY_BUTTON.click();
    }

    public void clickGreyOutArea() {
        VT_CLOSE_FILTER_TASKS.click();
    }

    public boolean checkIfBottomSheetTasksButtonIsDisplayed() {
        return VT_TASKS_BOTTOMSHEET_BUTTON.isDisplayed();
    }

    public void clickBottomSheetTasksButton() {
        VT_TASKS_BOTTOMSHEET_BUTTON.click();
    }

     public boolean checkIfBottomSheetSearchButtonIsDisplayed() {
        return VT_SEARCH_BOTTOMSHEET_BUTTON.isDisplayed();
    }

    public void clickBottomSheetSearchButton() {
        VT_SEARCH_BOTTOMSHEET_BUTTON.click();
    }

     public boolean checkIfBottomSheetBigBobButtonIsDisplayed() {
        return VT_BIGBOB_BOTTOMSHEET_BUTTON.isDisplayed();
    }

    public void clickBottomSheetBigBobButton() {
        VT_BIGBOB_BOTTOMSHEET_BUTTON.click();
    }

     public boolean checkIfBottomSheetJobsButtonIsDisplayed() {
        return VT_JOBS_BOTTOMSHEET_BUTTON.isDisplayed();
    }

    public void clickBottomSheetJobsButton() {
        VT_JOBS_BOTTOMSHEET_BUTTON.click();
    }

     public boolean checkIfBottomSheetFoldersButtonIsDisplayed() {
        return VT_TASKS_BOTTOMSHEET_BUTTON.isDisplayed();
    }

    public void clickBottomSheetFoldersButton() {
        VT_FOLDERS_BOTTOMSHEET_BUTTON.click();
    }

    
}