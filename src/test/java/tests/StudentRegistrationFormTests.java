package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;
import tests.*;
public class StudentRegistrationFormTests {
    StudentRegistrationFormPage formPage;

    @Test
    @DisplayName("Positive test")
//  @Disabled
    public void okTest() {
       TestBase.beforeAll();
       formPage = new StudentRegistrationFormPage();
       formPage.fillThePage("");
       TestBase.afterEach();
   }

    @Test
    @DisplayName("Negative test")
//  @Disabled
    public void brokenTest() {
        TestBase.beforeAll();
        formPage = new StudentRegistrationFormPage();
        formPage.fillThePage("ERROR");
        TestBase.afterEach();
    }
}
