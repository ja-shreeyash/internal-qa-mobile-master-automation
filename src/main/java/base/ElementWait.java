package base;

import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ElementWait {

    private static final Integer fluentWaitInterval = 60;

    public static Wait<WebDriver> getFluentWait() {
        return new FluentWait<>(DriverManager.getDriver())
            .withTimeout(Duration.ofSeconds(fluentWaitInterval))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);
    }

    public static boolean waitUntilElementPresent(By by) {
        try {
            getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static boolean waitUntilElementPresent(WebElement ele) {
        try {
            getFluentWait().until(ExpectedConditions.visibilityOf(ele));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static boolean waitUntilElementClickable(By by) {
        try {
            getFluentWait().until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static boolean waitUntilElementClickable(WebElement ele) {
        try {
            getFluentWait().until(ExpectedConditions.elementToBeClickable(ele));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
