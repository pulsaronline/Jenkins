package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Selenide.open;
import static tests.TestBase.*;

public class StudentRegistrationFormTests extends TestBase{
    StudentRegistrationFormPage formPage;
    //TestData testData;

   @Test
   public void testsQueue() {
       TestBase.setup();

       formPage = new StudentRegistrationFormPage();

       formPage.successfulFillFormPage();
       formPage.negativeFillFormPage();
    }
}
