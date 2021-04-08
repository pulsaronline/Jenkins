package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static public void setup() {
        Configuration.browserSize = "1024x768";
    }
}