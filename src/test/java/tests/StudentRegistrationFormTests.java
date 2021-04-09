package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTests {
    StudentRegistrationFormPage formPage;
    TestData testData;

   @Test
   public void testsQueue() {
       TestBase.setup();
       testData = new TestData();
       formPage = new StudentRegistrationFormPage();

       formPage.successfulFillFormPage();
       formPage.negativeFillFormPage();
    }
}
