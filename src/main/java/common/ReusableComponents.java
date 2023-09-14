package common;

import base.Actions;
import base.ElementWait;
import lombok.extern.slf4j.Slf4j;
import ru.yandex.qatools.allure.annotations.Step;

import static common.ReusableLocators.PAGE_HEADER_XPATH;
import static common.ReusableLocators.PAGE_TITLE_CLASS_NAME;

@Slf4j
public class ReusableComponents extends ReusableElements {

  @Step("Getting screen title")
  public String getScreenTitle() {
    log.info("Getting screen title");
    ElementWait.waitUntilElementPresent(PAGE_TITLE_CLASS_NAME);
    return Actions.getTextFromElement(PAGE_TITLE_CLASS_NAME);
  }
  @Step("Screen Title")
  public String GetScreenTitle(){
     ElementWait.waitUntilElementPresent(PAGE_HEADER_XPATH);
    return Actions.getTextFromElement(PAGE_HEADER_XPATH);
  }
}
