package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentHelper.*;

public class StudentRegistrationFormTests {
    StudentRegistrationFormPage formPage;
    TestBase testBase = new TestBase();

    @BeforeEach
    public void beforeEach() {
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
        public void afterEach() {
            attachScreenshot("Last screenshot");
            attachPageSource();
            attachAsText("Browser console error logs", getConsoleLogs());
            //if (System.getProperty("video_storage") != null)
            attachVideo();
            closeWebDriver();
        }

   @Test
   @DisplayName("Positive test")
   public void testOk() {
       beforeEach();
       formPage = new StudentRegistrationFormPage();
       formPage.successfulFillFormPage();
       afterEach();
   }

    @Test
    @DisplayName("Negative test")
    //@Disabled
    public void testBroken() {
        beforeEach();
        formPage = new StudentRegistrationFormPage();
        formPage.negativeFillFormPage();
        afterEach();
    }
}
