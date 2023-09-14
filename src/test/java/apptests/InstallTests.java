package apptests;

import basetest.BaseTestAndroid;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import listeners.TestListener;
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import screens.playstore.PlayStoreScreen;
import utils.RandomUtils;

@Listeners({TestListener.class})
@Owner("Vy Nguyen")
public class InstallTests extends BaseTestAndroid {
  PlayStoreScreen playStoreScreen;
  RandomUtils randomUtils;

  public static void main(String[] args) {
    
  }
  @BeforeClass
  public void initialize() {
    playStoreScreen = new PlayStoreScreen();
    randomUtils = new RandomUtils();
  }

  @Title("Install app from Play Store on mobile")
  @Description("Verify install app successfully from Play Store on mobile")
  @Test(groups = {"INSTALL"})
  public void installAppFromPlayStoreMobile() {
    // String oldApp = "com.jobadder.android";
    // String newApp = "com.jobadder.jobadderapp";
    String newApp = "com.jobadder.mobile";
    // playStoreScreen.uninstallApp(oldApp);
    playStoreScreen.uninstallApp(newApp);

    Assert.assertTrue(
        playStoreScreen.installAppFromPlayStore("JobAdder"), "Timed out waiting for download app");
  }

  @Ignore
  @Title("Install app from APK file on PC")
  @Description("Verify install app successfully from APK file on PC")
  @Test(groups = {"INSTALL"})
  public void installAppFromPlayStorePC() {
    
    // installAppFromAPKFile("JA.apk");
  }

  @AfterClass
  public void cleanUp() {
    if (playStoreScreen != null) playStoreScreen.cleanUIAutomator();
  }
}
