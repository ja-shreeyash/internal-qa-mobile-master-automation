package screens.search;

// import base.ElementWait;
 import driver.DriverManager;
// import org.openqa.selenium.WebElement;
// import org.testng.Assert;

// import java.util.List;

// import static base.Actions.*;
import static screens.search.SearchScreenElements.*;

public class SearchScreen {

  public boolean checkIfSearchButtonIsDisplayed() {
    return DriverManager.getDriver().findElement(SS_SEARCH_BUTTON).isDisplayed();
  }

  public void SearchButtonClick() {
    DriverManager.getDriver().findElement(SS_SEARCH_BUTTON).click();
  }

  public void AllRecordsButtonClick() {
    DriverManager.getDriver().findElement(SS_ALLRECORDS_BUTTON).click();
  }

  public void CandidatesButtonClick() {
    DriverManager.getDriver().findElement(SS_CANDIDATES_BUTTON).click();
  }
  
  public void ContactsButtonClick() {
    DriverManager.getDriver().findElement(SS_CONTACTS_BUTTON).click();
  }

  public void CompaniesButtonClick() {
    DriverManager.getDriver().findElement(SS_COMPANIES_BUTTON).click();
  }

  public void JobsButtonClick() {
    DriverManager.getDriver().findElement(SS_JOBS_BUTTON).click();
  }

   public boolean checkIfAllRecordsButtonIsDisplayed() {
    return DriverManager.getDriver().findElement(SS_ALLRECORDS_BUTTON).isDisplayed();
  }

  public boolean checkIfCandidatesButtonIsDisplayed() {
    return DriverManager.getDriver().findElement(SS_CANDIDATES_BUTTON).isDisplayed();
  }

  public boolean checkIfContactsButtonIsDisplayed() {
    return DriverManager.getDriver().findElement(SS_CONTACTS_BUTTON).isDisplayed();
  }

   public boolean checkIfCompaniesButtonIsDisplayed() {
    return DriverManager.getDriver().findElement(SS_COMPANIES_BUTTON).isDisplayed();
  }

   public boolean checkIfJobsButtonIsDisplayed() {
    return DriverManager.getDriver().findElement(SS_JOBS_BUTTON).isDisplayed();
  }

  
}

// CODE FOR REFERENCE
// public void performSearch(String searchParam) {
//     ElementWait.waitUntilElementPresent(SEARCH_TEXT_FIELD_ID);
//     clearAndInput(SEARCH_TEXT_FIELD_ID, searchParam);
//     clickElementBy(SEARCH_BUTTON_ID);
//   }

//   public void clickResetSearchButton() {
//     ElementWait.waitUntilElementPresent(CLEAR_SEARCH_BUTTON_ID);
//     clickElementBy(CLEAR_SEARCH_BUTTON_ID);
//   }

//   public int getNumberOfSearchResults() {
//     return getNumberOfResultsForElement(SEARCH_ITEM_TEXT_ID);
//   }

//   public void verifyIfSearchResultsContainsSpecificSearchInput(String input) {
//     List<WebElement> results = DriverManager.getDriver().findElements(SEARCH_ITEM_TEXT_ID);
//     for (int i = 0; i < results.size(); i++) {
//       Assert.assertTrue(
//           results.get(i).getText().toLowerCase().contains(input),
//           "Search result validation failed at instance+" + i + "");
//     }
//   }

//   public String getSearchFieldPlaceholderText() {
//     ElementWait.waitUntilElementPresent(SEARCH_TEXT_FIELD_ID);
//     return getTextFromElement(SEARCH_TEXT_FIELD_ID);
//   }