package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.*;

public class StudentRegistrationFormTests {
    StudentRegistrationFormPage formPage;

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1024x768";
        addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        //capabilities.setCapability("browserName", "chrome");
        //capabilities.setCapability("browserVersion", "89.0");
        Configuration.browserCapabilities = capabilities;
        //Configuration.remote = System.getProperty("remote_driver");
        //Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }

    @AfterEach
    void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console error logs", getConsoleLogs());
        //if (System.getProperty("video_storage") != null)
        attachVideo();
        closeWebDriver();
    }

    @Test
    @DisplayName("Positive test")
    public void okTest() {
       formPage = new StudentRegistrationFormPage();
       formPage.fillThePage("");
          }

    @Test
    @DisplayName("Negative test")
    public void brokenTest() {
        formPage = new StudentRegistrationFormPage();
        formPage.fillThePage("ERROR");
    }
}
