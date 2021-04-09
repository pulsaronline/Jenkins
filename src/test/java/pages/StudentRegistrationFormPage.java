package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class StudentRegistrationFormPage {
    private final String BASE_URL = "https://demoqa.com/automation-practice-form";
    private final String checkTheFormHeader = "Student Registration Form";
    private final String resultPageHeader = "Thanks for submitting the form";

    public void successfulFillFormPage(){

        String firstName = randomFirstName();
        String lastName = randomLastName();
        String gender = randomGender();
        String email = randomEmail();
        String phoneNumber = randomPhoneNumber();
        String monthOfBirth = randomMonth();
        String yearOfBirth = randomYear();
        String dayOfBirth = randomDay();
        String subject = randomSubject();
        String hobbie = randomHobbie();
        String filename = "1.png";
        String address = randomAddress();
        String state = randomState();
        String city = randomCity(state);

        step("Open students registration form", () -> {
            open(BASE_URL);
            $(".practice-form-wrapper").shouldHave(text(checkTheFormHeader));
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
                        $(".react-datepicker__month-select").selectOption(monthOfBirth);
                        $(".react-datepicker__year-select").selectOption(yearOfBirth);
                        $(".react-datepicker__month").$(byText(dayOfBirth)).click();
                    });
                    step("Set subjects", () -> {
                        $("#subjectsContainer").click();
                        $("#subjectsInput").setValue(subject).pressEnter();
                    });
                    step("Set hobbies", () -> $(byText(hobbie)).click());
                    //step("Set hobbies", () -> $(byText(hobby)).selectRadio(hobby));

            step("Upload file", () -> $("#uploadPicture").uploadFromClasspath(filename));
                    step("Set address", () -> {
                        $("#currentAddress").setValue(address).pressTab();
                        $("#state").click();
                        $(byText(state)).scrollTo().click();
                        $("#city").click();
                        $(byText(city)).scrollTo().click();
                    });
                    step("Submit the form", () -> $("#submit").pressEnter());
                });
        step("Validate data", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text(resultPageHeader));
            $(".table-responsive").shouldHave(
                    text(firstName),
                    text(lastName),
                    text(email),
                    text(gender),
                    text(phoneNumber),
                    text(dayOfBirth),
                    text(monthOfBirth),
                    text(yearOfBirth),
                    text(subject),
                    text(hobbie),
                    text(filename),
                    text(address),
                    text(state),
                    text(city));
        });
    }

    public void negativeFillFormPage(){

        String firstName = randomFirstName();
        String lastName = randomLastName();
        String gender = randomGender();
        String email = randomEmail();
        String phoneNumber = randomPhoneNumber();
        String monthOfBirth = randomMonth();
        String yearOfBirth = randomYear();
        String dayOfBirth = randomDay();
        String subject = randomSubject();
        String hobbie = randomHobbie();
        String filename = "1.png";
        String address = randomAddress();
        String state = randomState();
        String city = randomCity(state);

        step("Open students registration form", () -> {
            open(BASE_URL);
            $(".practice-form-wrapper").shouldHave(text(checkTheFormHeader));
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
                $(".react-datepicker__month-select").selectOption(monthOfBirth);
                $(".react-datepicker__year-select").selectOption(yearOfBirth);
                $(".react-datepicker__month").$(byText(dayOfBirth)).click();
            });
            step("Set subjects", () -> {
                $("#subjectsContainer").click();
                $("#subjectsInput").setValue(subject).pressEnter();
            });
            step("Set hobbies", () -> $(byText(hobbie)).click());
            step("Upload file", () ->
                    $("#uploadPicture").uploadFromClasspath(filename));
            step("Set address", () -> {
                $("#currentAddress").setValue(address).pressTab();
                $("#state").click();
                $(byText(state)).scrollTo().click();
                $("#city").click();
                $(byText(city)).scrollTo().click();
            });
            step("Submit the form", () -> $("#submit").pressEnter());
        });
        step("Validate data", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text(resultPageHeader));
            $(".table-responsive").shouldHave(
                    text(firstName),
                    text(lastName),
                    text(email),
                    text(gender),
                    text(phoneNumber),
                    text(dayOfBirth),
                    text(monthOfBirth),
                    text(yearOfBirth),
                    text(subject),
                    text(hobbie),
                    text(filename),
                    text(address),
                    text(state),
                    text(city + " Error insertion")); //добавляем ошибку
        });
    }
}
