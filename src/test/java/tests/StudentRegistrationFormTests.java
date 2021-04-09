package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Selenide.open;
import static tests.TestBase.*;

public class StudentRegistrationFormTests extends TestBase{
    StudentRegistrationFormPage formPage;
    //TestData testData;

   @Test
   public void testsOk() {
       TestBase.setup();
       formPage = new StudentRegistrationFormPage();

       formPage.successfulFillFormPage();
    }
    @Test
    public void testsBroken() {
        TestBase.setup();
        formPage = new StudentRegistrationFormPage();

        formPage.negativeFillFormPage();
    }
}
