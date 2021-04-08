package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormTests {
    private final String BASE_URL = "https://demoqa.com/automation-practice-form";
    String pageHeader = "Thanks for submitting the form";

    @Test
    void successfulFillFormTest(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Other",
                phoneNumber = faker.number().digits(10),
                dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28)),
                monthOfBirth = "March",
                yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2010)),
                subject1 = "Math",
                subject2 = "Commerce",
                hobby1 = "Sports",
                hobby2 = "Reading",
                hobby3 = "Music",
                filename = "1.png",
                address = faker.address().fullAddress(),
                state = "Uttar Pradesh",
                city = "Merrut";

        step("Open students registration form", () -> {
            open(BASE_URL);
            $(".pactice-form-wrapper").shouldHave(text("Student Registration form"));
        });
        step("Fill students registration form", () -> {
                    step("Fill common data", () -> {
                    $("#firstName").setValue(firstName);
                    $("#lastName").setValue(lastName);
                    $("#userEmail").setValue(email);
                    $(byText(gender)).click();
                    $("#userNumber").setValue(phoneNumber);
                    });
                    step("Set date", () -> {
                        $("#dateOfBirthInput").click();
                        $(".react-datepicker__month-select").selectOptionByValue(monthOfBirth);
                        $(".react-datepicker__year-select").selectOptionByValue(yearOfBirth);
                        $(".react-datepicker__month").$(byText(dayOfBirth)).click();
                    });
                    step("Set subjects", () -> {
                        $("#subjectsContainer").click();
                        $("#subjectsInput").setValue(subject1).pressEnter();
                        $("#subjectsInput").setValue(subject2).pressEnter();
                    });
                    step("Set hobbies", () -> {
                        $(byText(hobby1)).click();
                        $(byText(hobby2)).click();
                        $(byText(hobby3)).click();
                    });
                    step("Upload file", () ->
                        $("#uploadPicture").uploadFromClasspath("img/" + filename));
                    step("Set address", () -> {
                        $("#currentAddress").setValue(address).pressTab();
                        $("#state").scrollTo().click();
                        $(byText(state)).click();
                        $("#city").click();
                        $(byText(city)).click();
                    });
                    step("Submit the form", () -> $("#submit").pressEnter());
                });
        step("Validate data", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text(pageHeader));
            $(".table-responsive").shouldHave(
                    text(firstName),
                    text(lastName),
                    text(email),
                    text(gender),
                    text(phoneNumber),
                    text(dayOfBirth),
                    text(monthOfBirth),
                    text(yearOfBirth),
                    text(subject1),
                    text(subject2),
                    text(hobby1),
                    text(hobby2),
                    text(hobby3),
                    text(filename),
                    text(address),
                    text(state),
                    text(city));
        });
    }
}
