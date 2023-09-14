# Jobadder mobile Appium framework [![Google Java Checkstyle](https://github.com/JobAdder/internal-qa-mobile/actions/workflows/checkstyle.yml/badge.svg)](https://github.com/JobAdder/internal-qa-mobile/actions/workflows/checkstyle.yml)


Guideline for [Mobile native app automation framework with Appium for Jobadder](https://jobadder.atlassian.net/wiki/spaces/MOB/pages/88310022/Mobile+Automation+inprogress)

#### Base setup for new starter (can be skipped if you already install npm, Maven, Java, Android, Appium):

1. Download [Node.js](https://nodejs.org/en/download/) and install node.js, npm.
    * Set environment variables:
        * ```npm install``` (via cmd - to install dependencies from package.json)
        * ```npm install -g appium``` (via cmd - to install appium main)
        * Path = ```C:\Users\[user.name]\AppData\Roaming\npm```
        * Path = ```C:\Program Files\nodejs```
2. Download [Android Studio](https://developer.Android.com/studio?gclid=Cj0KCQjw2MWVBhCQARIsAIjbwoNHsbH9OeWaeBP6iKh9Rd9zlpKK-dNDFlgY9BGIYfFgigqsO8Xz5wsaAiE_EALw_wcB&gclsrc=aw.ds)
for executing adb command in android.
    * Set environment variables:
        * Android_HOME = ```C:\Users\[user.name]\AppData\Local\Android\Sdk```
        * Path =
            * ```C:\Users\[user.name]\AppData\Local\Android\Sdk\emulator```
            * ```C:\Users\[user.name]\AppData\Local\Android\Sdk\platform-tools```
            * ```C:\Users\[user.name]\AppData\Local\Android\Sdk\tools\bin```
3. Install [SDK tools](https://www.geeksforgeeks.org/fix-sdk-tools-directory-is-missing-error-in-android-studio/#:~:text=Quick%20fix%3A%20Go%20to%20the,generated%20in%20the%20SDK%20directory.)
if it is missing on Android Studio.
    * Go to SDK Manager –> System Settings –> Android SDK –> Open tab SDK Tools –> Deselect Hide Obsolete Packages
      option on the right bottom –> Install Android SDK Tools (Obsolete).
    * Set environment variables:
        * Path = ```C:\Users\[user.name]\AppData\Local\Android\Sdk\tools\bin```
4. Download [Appium desktop](https://www.electronjs.org/apps/appium) for automation server.
5. Download [Appium Inspector](https://github.com/appium/appium-inspector/releases) to capture elements from emulator.
6. Download [Maven](https://maven.apache.org/download.cgi) (for example: apache-maven-3.8.6-bin.zip).
    * Set environment variables:
        * M2_HOME = ```C:\Program Files\apache-maven-3.8.6```
        * Path = ```C:\Program Files\apache-maven-3.8.6\bin```
7. Install extensions for VSCode:
    * [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).
    * [Lombok plugin](https://marketplace.visualstudio.com/items?itemName=GabrielBB.vscode-lombok).
8. Download and install [JDK+JRE](https://www.techspot.com/downloads/5198-java-jre.html):
    * JDK(Java Development Kit) contains numerous development tools like compilers, debuggers, etc.
    * JRE(Java Runtime Environment) is the implementation of JVM(Java Virtual Machine) and it is specially designed to
      execute Java programs.
    * [Set environment variables](https://www.stechies.com/downloading-java-jdk-configuring-Android-studio/):
        * JAVA_HOME = ```C:\Program Files\Java\jdk1.8.0_333```
        * Path = ```C:\Program Files\Java\jdk1.8.0_333\bin```
9. Check the environment variable are configured properly (may require restart for the new environment variables to
   effect):
    * ```java -version```
    * ```echo %Android_HOME%```
    * ```echo %JAVA_HOME%```
    * ```allure --version```
    * ```npm --version```
    * ```adb --version```
    * ```mvn --version```
    * ```avdmanager```
    * ```emulator```
10. Update path for local env under ```config/config.properties``` if not matching
11. Install kill port npm by opening cmd and type:
    * ```npx kill-port 4444```
    * ```yes```

### Automation Setup guidelines:

- Make sure that Maven, Java (v1.8), appium server are installed in the system.
- Check out GitHub repo into any IDE (preferred Intellij or VSCode).
- Check that lombok plugin is installed.
- This repo contains default Android .apk and iOS .ipa/.app files, please put it manually in the app folder, the script 
  will automatically get the latest file.
- In order to understand better the project, you can find an example of the POM Values for an Android Test and for 
  an iOS Test. ```src/test/resources/suites/```
- The apk file path at ```src/main/java/base/BaseTest.java > setup() method > String appApkFilePath``` (by default it
  will use the file under app folder).
- Similarly provide own emulator name at ```src/main/java/base/BaseTest.java > setup() method > String emulatorName```
- Basic commands to run tests - open terminal and go to project directory and run command: ```mvn clean install``` or
  use the IDE to select specific test.
- After test build, run following command in terminal for allure report generation: ```allure serve allure-results```
- Above command will generate allure report and launch these reports in system's default browser.
- Able to run on Mac and Windows.

#### Key features of framework used:

- Page Object Model.
- Java: a convenient programming language.
- Maven: For build management purpose, a common structure can be maintained very easily.
- Appium: Open source, most convenient native mobile app automation tool.
- Allure Reports: As it is the cleanest automation reports and provides lots of useful annotations as well. For better
  documentation, it has been chosen over other reporting tools.
- Lombok plugin: It provides very simple logging framework as compared to other logging methods.
- It automatically starts appium server and kills its instance after tests are executed.

### Why Page Object Model?

- According to Page Object Model, we should keep our tests and element locators separately, this will keep code clean
  and easy to understand and maintain.
- The Page Object approach makes test automation framework programmer friendly, more durable and comprehensive.
- Independent of Automation Tests: keeping separate repository for page objects helps us to use this repository for
  different purposes.
- Test cases become short and optimized as we are able to reuse page object methods in the POM classes.
- Any change in UI can easily be implemented, updated and maintained into the Page Objects and Classes.
- Easily scalable approach.

#### Disadvantages of POM framework?

- If there is an application with hundreds or thousands of web pages then the time and the effort in the development of
  automation framework will be high.
- The cost increases when maintenance overhead increases which are due to the maintenance of large class as they break
  the OOP design principle.
- The development of POM framework for multiple pages is equal to developers work thus testers should be highly
  knowledgeable in programming best practices.
- Page object model is not a generic model and its specific to the applications.

#### Few best Coding practices are followed while writing automation script:

- KISS (Keep it simple, stupid).
- YAGNI (You aren't gonna need it).
- DRY (Don't repeat yourself): by providing reusable functions.
- Static methods.
- OOPS concepts.

#### Google Checkstyle (customized): [![Google Java Checkstyle](https://github.com/JobAdder/internal-qa-mobile/actions/workflows/checkstyle.yml/badge.svg)](https://github.com/JobAdder/internal-qa-mobile/actions/workflows/checkstyle.yml)
- Checkstyle config: ```.github/custom_checkstyle.xml```
- Locally:
  - Execute command from terminal
  ```mvn checkstyle:check```
  - Or use plugin for Google Checkstyle via IDE (e.g. Checkstyle-IDEA, ...)

- GitHub Action: 
  - The Google checkstyle will be validated automatically via PR (using checkstyle.yml file)
  - With: ReviewDog,  


#### Some tips on how to make sure your code is maintainable by other team members?

- Using POM framework with proper and meaningful package names for easier to find and use them.
- Use comments wherever needed.
- Descriptive variable, method, class names.
- Use design patterns.

### Automation Test Scenarios:

Below are some sample test scenarios which has been automated using Appium for Android app:

| Feature Name  | Description                                                                                  |
|---------------|----------------------------------------------------------------------------------------------|
| Login Screen  | Verify login is not successful with invalid credentials and toast error message is displayed |
| Search Screen | Verify search page basic validations after successful login                                  |
| ...           | TBC                                                                                          |

#### Additional reporting commands and configuration:

```
allure generate ./allure-results --clean

allure generate allure-results --clean -o allure-report

allure open ./allure-report

allure serve allure-results
```

#### Grid - TBU - inprogress

java -jar selenium-server-4.1.1.jar standalone --config config.toml

java -jar selenium-server-4.3.0.jar hub --config config.toml
