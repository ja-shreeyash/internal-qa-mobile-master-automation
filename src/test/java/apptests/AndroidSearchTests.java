package apptests;

// import basetest.BaseTestAndroid;
// import common.ReusableComponents;
// import io.qameta.allure.Description;
// import io.qameta.allure.Owner;
// import listeners.TestListener;
// import org.testng.Assert;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Ignore;
// import org.testng.annotations.Listeners;
// import org.testng.annotations.Test;
// import ru.yandex.qatools.allure.annotations.Title;
// import screens.login.LoginScreen;
// import screens.search.SearchScreen;
// import utils.PropertyUtils;
// import utils.RandomUtils;

// import static constants.FieldsText.PLACEHOLDER_TEXT_SEARCH_FIELD;
// import static constants.FieldsText.SCREEN_TITLE;

// @Listeners({TestListener.class})
// @Owner("Van Pham")
// public class AndroidSearchTests extends BaseTestAndroid {

//   AndroidLoginTests Androidlogintests;
//   AndroidPinScreenTests Androidpinscreentests;
//   AndroidDailyUpdateTests Androiddailyupdatetests;
//   AndroidViewTasksTests Androidviewtaskstests;
//   SearchScreen Searchscreen;
//   RandomUtils randomUtils;
//   ReusableComponents reusable;

//   @BeforeClass
//   public void initialize() {
//     Androidlogintests = new AndroidLoginTests();
//     Androidpinscreentests = new AndroidPinScreenTests();
//     Androiddailyupdatetests = new AndroidDailyUpdateTests();
//     Androidviewtaskstests = new AndroidViewTasksTests();
//     Searchscreen = new SearchScreen();
//     reusable = new ReusableComponents();
//     randomUtils = new RandomUtils();
//   }

//   @BeforeClass
//   public void login() {
//     Androidlogintests.loginIsSuccessfulWithCorrectCredentials();
//     Androidpinscreentests.PinScreenUserInput();
//     Androidpinscreentests.PinScreenConfirmPIN();
//     Androiddailyupdatetests.DailyUpdate_Without_Checkbox();
    
//   }

//   @Ignore
//   @Title("Search page basic validations")
//   @Description("Verify search page basic validations after successful login ")
//   @Test(groups = {"SMOKE"})
//   public void searchPageBasicValidations() {
//     Assert.assertTrue(Searchscreen.checkIfSearchButtonIsDisplayed(), "Search button is missing");
//     Searchscreen.SearchButtonClick();
//     Searchscreen.CandidatesButtonClick();
//     Searchscreen.AllRecordsButtonClick();
//     Searchscreen.ContactsButtonClick();

//     Assert.assertTrue(
//         searchScreen.checkIfClearSearchButtonIsDisplayed(), "Clear Search button is missing");
//   }

//   @Ignore
//   @Title("Search with numeric input of length two")
//   @Description("Verify search functionality with numeric input of length two")
//   @Test(groups = {"SMOKE"})
//   public void searchWithNumericInputOfLengthTwo() {
//     int searchParam = 43;
//     int expectedSearchResults = 3;
//     searchScreen.performSearch(Integer.toString(searchParam));
//     Assert.assertEquals(searchScreen.getNumberOfSearchResults(), expectedSearchResults);
//     searchScreen.verifyIfSearchResultsContainsSpecificSearchInput(Integer.toString(searchParam));
//   }

//   @Ignore
//   @Title("Search with numeric input of length three")
//   @Description("Verify search functionality with numeric input of length three")
//   @Test(groups = {"SMOKE"})
//   public void searchWithNumericInputOfLengthThree() {

//     int searchParam = 560;
//     int expectedSearchResults = 1;
//     searchScreen.performSearch(Integer.toString(searchParam));
//     Assert.assertEquals(searchScreen.getNumberOfSearchResults(), expectedSearchResults);
//     searchScreen.verifyIfSearchResultsContainsSpecificSearchInput(Integer.toString(searchParam));
//   }

//   @Ignore
//   @Title("Search with string input of length two")
//   @Description("Verify search functionality with string input of length two")
//   @Test(groups = {"SMOKE"})
//   public void searchWithStringInputOfLengthTwo() {

//     String searchParam = "ar";
//     int expectedSearchResults = 6;
//     searchScreen.performSearch(searchParam);
//     Assert.assertEquals(searchScreen.getNumberOfSearchResults(), expectedSearchResults);
//     searchScreen.verifyIfSearchResultsContainsSpecificSearchInput(searchParam);
//   }

//   @Ignore
//   @Title("Search with string input of length three")
//   @Description("Verify search functionality with string input of length three")
//   @Test(groups = {"SMOKE"})
//   public void searchWithStringInputOfLengthThree() {
//     String searchParam = "arm";
//     int expectedSearchResults = 3;
//     searchScreen.performSearch(searchParam);
//     Assert.assertEquals(searchScreen.getNumberOfSearchResults(), expectedSearchResults);
//     searchScreen.verifyIfSearchResultsContainsSpecificSearchInput(searchParam);
//   }

//   @Ignore
//   @Title("Reset search functionality")
//   @Description("Verify reset search functionality is working fine")
//   @Test(groups = {"SMOKE"})
//   public void resetSearch() {
//     String searchParam = "arm";
//     int expectedSearchResults = 3;
//     searchScreen.performSearch(searchParam);
//     Assert.assertEquals(searchScreen.getNumberOfSearchResults(), expectedSearchResults);
//     searchScreen.clickResetSearchButton();
//     Assert.assertTrue(searchScreen.getNumberOfSearchResults() > expectedSearchResults);
//     Assert.assertEquals(
//         searchScreen.getSearchFieldPlaceholderText(), PLACEHOLDER_TEXT_SEARCH_FIELD);
//   }

//   @Title("Login with incorrect credentials")
//   @Description(
//       "Verify login is not successful with invalid credentials and toast error message is displayed")
//   @Test(groups = {"SMOKE"})
//   public void verifyToastErrorMessageWithIncorrectCredentials() {
//     loginScreen.enterEmailAddress(randomUtils.getRandomAlphanumericString(7));
//     loginScreen.clickLoginChoiceButton();
//     loginScreen.enterPassword(randomUtils.getRandomAlphanumericString(8));
//     loginScreen.clickLoginButton();
//     //        Assert.assertTrue(loginScreen.getToastMessage(TOAST_ERROR_MESSAGE), "Toast error
//     // message is not displayed");
//   }

//   @Title("Login with incorrect credentials")
//   @Description(
//       "Verify login is not successful with invalid credentials and toast error message is displayed")
//   @Test(groups = {"SMOKE"})
//   public void verifyToastErrorMessageWithIncorrectCredentials1() {
//     loginScreen.enterEmailAddress(randomUtils.getRandomAlphanumericString(7));
//     loginScreen.clickLoginChoiceButton();
//     loginScreen.enterPassword(randomUtils.getRandomAlphanumericString(8));
//     loginScreen.clickLoginButton();
//     //        Assert.assertTrue(loginScreen.getToastMessage(TOAST_ERROR_MESSAGE), "Toast error
//     // message is not displayed");


