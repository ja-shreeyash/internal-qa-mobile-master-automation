package base;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Actions {

  public static void clickElementBy(By by) {
    tryFindElement(by).click();
  }

  public static void clearAndInput(By by, String text) {
    tryFindElement(by).clear();
    tryFindElement(by).sendKeys(text);
  }

  public static void clearAndInput(WebElement ele, String text) {
    ele.clear();
    ele.sendKeys(text);
  }

  public static WebElement tryFindElement(By by) {
    return (WebElement)
        ElementWait.getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
  }

  public static WebElement tryFindElement(WebElement ele) {
    return (WebElement) ElementWait.getFluentWait().until(ExpectedConditions.visibilityOf(ele));
  }

  public static String getTextFromElement(By by) {
    return tryFindElement(by).getText().trim();
  }

  public static String getTextFromElement(WebElement ele) {
    return ele.getText().trim();
  }

  public static int getNumberOfResultsForElement(By by) {
    return DriverManager.getDriver().findElements(by).size();
  }
}
