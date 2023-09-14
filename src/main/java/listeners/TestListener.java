package listeners;

// import appium.CapabilityFileManager;
import constants.ConfigMap;
import constants.GlobalVars;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
// import org.testng.xml.XmlSuite;
import utils.FileHandler;
import utils.PropertyUtils;
import utils.ShellCmdUtils;

/**
 * Listener is defined as interface that modifies the default TestNG’s behavior, allows customizing
 * TestNG reports or logs. Listeners “listen” to the event defined in the selenium script and behave
 * accordingly.
 *
 * @author VanPham
 */
public class TestListener implements ITestListener, ISuiteListener {

  private static String getTestMethodName(ITestResult iTestResult) {
    return iTestResult.getMethod().getConstructorOrMethod().getName();
  }

  // Text attachments for Allure
  @Attachment(value = "{0}", type = "text/plain")
  public static String saveTextLog(String message) {
    return message;
  }

  // HTML attachments for Allure
  @Attachment(value = "{0}", type = "text/html")
  public static String attachHtml(String html) {
    return html;
  }

  // Text attachments for Allure
  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshotPNG(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Override
  public void onStart(ITestContext iTestContext) {
    System.out.println("==== onStart method ==== " + iTestContext.getName());
    iTestContext.setAttribute("WebDriver", DriverManager.getDriver());
    if (PropertyUtils.get(ConfigMap.RUNMODE).equalsIgnoreCase(GlobalVars.getGrid())) {
      ShellCmdUtils.killStandaloneServer();
    }
  }

  public void onStart(ISuite suite) {
    //  Before suit
    //  XmlSuite a = suite.getXmlSuite();
    //  int z = a.getThreadCount();

    FileHandler.deleteOldReports();
    FileHandler.deleteDir(GlobalVars.getScreenshotDir());
    // CapabilityFileManager.generateCapFile();
  }

  public void onFinish(ISuite suite) {}

  @Override
  public void onFinish(ITestContext iTestContext) {
    System.out.println("==== onFinish method ==== " + iTestContext.getName());
    if (PropertyUtils.get(ConfigMap.RUNMODE).equalsIgnoreCase(GlobalVars.getGrid())) {
      ShellCmdUtils.killStandaloneServer();
    }
  }

  @Override
  public void onTestStart(ITestResult iTestResult) {
    System.out.println("==== Started test method " + getTestMethodName(iTestResult));
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {
    System.out.println("==== Succeed test method " + getTestMethodName(iTestResult));
  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    System.out.println("==== Failed test method " + getTestMethodName(iTestResult));
    // Object testClass = iTestResult.getInstance();

    WebDriver driver = DriverManager.getDriver();
    // Allure ScreenShotRobot and SaveTestLog
    if (driver instanceof AppiumDriver) {
      System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
      saveScreenshotPNG(driver);
    }
    // Save a log on allure.
    saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {
    System.out.println("==== Skipped test method " + getTestMethodName(iTestResult));
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    System.out.println(
        "Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
  }
}
