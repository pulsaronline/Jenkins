package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

public class StudentRegistrationFormTests {
    StudentRegistrationFormPage formPage;
    //TestData testData;

   @Test
   @DisplayName("Positive test")
   public void testOk() {
       //TestBase.beforeAll();
       formPage = new StudentRegistrationFormPage();
       formPage.successfulFillFormPage();
    }

    @Test
    @DisplayName("Negative test")
    //@Disabled
    public void testBroken() {
        //TestBase.beforeAll();
        formPage = new StudentRegistrationFormPage();
        formPage.negativeFillFormPage();
    }
}
