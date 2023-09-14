package screens.viewtask;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


// import org.openqa.selenium.By;
// import common.CommonElements;
// import io.appium.java_client.AppiumBy;
// import org.openqa.selenium.support.FindBy;

public class ViewTaskScreenElements {

  //View Calender button
  @AndroidFindBy(id = "TasksInterviewsScreenCalendarButtonTag")
  protected WebElement  VT_CALENDAR_ICON_BUTTON;

  //View calender from "CURRENT DATE" Button
  @AndroidFindBy(id = "TasksInterviewsScreenCalendarButtonTag")
  protected WebElement  VT_CURRENTDATE_TEXT_BUTTON;

  //View Tasks
  @AndroidFindBy(id = "TabTag0")
  protected WebElement  VT_TASKS_BUTTON;

  //View Interviews
  @AndroidFindBy(id = "TabTag1")
  protected WebElement  VT_INTERVIEWS_BUTTON;

  //View Upcoming tasks and its count
  @AndroidFindBy(id = "")
  protected WebElement  VT_UPCOMING_TASK_TEXT;

  //Filter Button
  @AndroidFindBy(id = "TasksInterviewsScreenTasksFilterTag")
  protected WebElement  VT_FILTER_BUTTON;

  //Filter Tasks Header
  @AndroidFindBy(id = "")
  protected WebElement  VT_FILTERTASK_TEXT;

  //view filter cancel button
  @AndroidFindBy(id = "BottomSheetHeaderCancelTag" )
  protected WebElement  VT_CANCEL_BUTTON;

  //View filter apply button
  @AndroidFindBy(id = "BottomSheetHeaderApplyTag")
  protected WebElement  VT_APPLY_BUTTON;

  //View filter "FILTER" Text
  @AndroidFindBy(id = "")
  protected WebElement  VT_FILTER_TEXT;

  //View filter "View Overdue Tasks"
  @AndroidFindBy(id = "")
  protected WebElement  VT_VIEW_OVERDUE_TASK_TEXT;

  //View filter "View Overdue Tasks" button
  @AndroidFindBy(id = "FilterTasksScreenOverdueTasksTag")
  protected WebElement  VT_VIEW_OVERDUE_TASK_BUTTON;

  //View filter "View Completed Tasks"
  @AndroidFindBy(id = "")
  protected WebElement  VT_VIEW_COMPLETED_TASK_TEXT;

  //View filter "View Completed Tasks" button
  @AndroidFindBy(id = "FilterTasksScreenCompletedTasksTag")
  protected WebElement  VT_VIEW_COMPLETED_TASK_BUTTON;

  //View filter "SORT BY" Text
  @AndroidFindBy(id = "")
  protected WebElement  VT_SORTBY_TEXT;

  //View filter "Upcoming" Text
  @AndroidFindBy(id = "")
  protected WebElement  VT_UPCOMING_TEXT;

  //View filter Click on Radio Button
  @AndroidFindBy(id = "FilterTasksScreenSortTag0")
  protected WebElement  VT_RADIO_UPCOMING_BUTTON;

  //View filter "Priority" Text
  @AndroidFindBy(id = "")
  protected WebElement  VT_PRIORITY_TEXT;

  //View filter Click on Radio Button
  @AndroidFindBy(id = "FilterTasksScreenSortTag1")
  protected WebElement  VT_RADIO_PRIORITY_BUTTON;

  //View "Go to Next Day" Button
  @AndroidFindBy(className  = "android.widget.Button")
  protected WebElement  VT_GOTO_NEXTDAY_BUTTON;

  //View Tasks Button
  @AndroidFindBy(id = "FeatureBottomNavigationBarTasksTag")
  protected WebElement VT_TASKS_BOTTOMSHEET_BUTTON;

  //View Search button
  @AndroidFindBy(id = "FeatureBottomNavigationBarSearchTag")
  protected WebElement  VT_SEARCH_BOTTOMSHEET_BUTTON;

  //View BIG BOB Button
  @AndroidFindBy(id = "MainFABTag")
  protected WebElement  VT_BIGBOB_BOTTOMSHEET_BUTTON;

  //View Jobs Button
  @AndroidFindBy(id = "FeatureBottomNavigationBarJobsTag")
  protected WebElement  VT_JOBS_BOTTOMSHEET_BUTTON;

  //View Folders Button
  @AndroidFindBy(id = "FeatureBottomNavigationBarFoldersTag")
  protected WebElement  VT_FOLDERS_BOTTOMSHEET_BUTTON;

  //close the Filter task by clicking Grey Area
  @AndroidFindBy(accessibility = "Close sheet")
  protected WebElement  VT_CLOSE_FILTER_TASKS;
    
}
