package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static tests.TestBase.*;

public class StudentRegistrationFormTests {
    StudentRegistrationFormPage formPage;
    //TestData testData;

   @Test
   @DisplayName("Positive test")
   public void testOk() {
       TestBase.setup();
       formPage = new StudentRegistrationFormPage();
       formPage.successfulFillFormPage();
    }

    @Test
    @DisplayName("Negative test")
    //@Disabled
    public void testBroken() {
        TestBase.setup();
        formPage = new StudentRegistrationFormPage();
        formPage.negativeFillFormPage();
    }
}
