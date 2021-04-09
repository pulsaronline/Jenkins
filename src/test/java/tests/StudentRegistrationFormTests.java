package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static tests.TestBase.*;

public class StudentRegistrationFormTests extends TestBase{
    StudentRegistrationFormPage formPage;
    //TestData testData;

   @Test
   public void testOk() {
       TestBase.setup();
       formPage = new StudentRegistrationFormPage();
       step("Positive test", () -> {
       formPage.successfulFillFormPage();
       });
    }
    @Test
    public void testBroken() {
        TestBase.setup();
        formPage = new StudentRegistrationFormPage();
        step("Negative test", () -> {
        formPage.negativeFillFormPage();
        });
    }
}
