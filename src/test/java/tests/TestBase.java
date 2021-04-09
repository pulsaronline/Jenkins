package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.*;

public class TestBase {
    @BeforeAll
    static public void setup() {
        Configuration.browserSize = "1024x768";
        addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        //capabilities.setCapability("browserName", "chrome");
        //capabilities.setCapability("browserVersion", "89.0");
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = System.getProperty("remote_driver");
    }

    @AfterEach
    void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console error logs", getConsoleLogs());
        if (System.getProperty("video_storage") != null)
        attachVideo();
        closeWebDriver();
    }
}