package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormTests {
    private final String BASE_URL = "https://demoqa.com/automation-practice-form";

    @Test
    void successfulFillFormTest(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Other",
                mobile = faker.number().digits(10),
                dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28)),
                monthOfBirth = "March",
                yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2010)),
                subject1 = "Math",
                subject2 = "Commerce",
                hobby1 = "Sports",
                hobby2 = "Reading",
                hobby3 = "Music",
                picture = "1.png",
                currentAddress = faker.address().fullAddress(),
                state = "Uttar Pradesh",
                city = "Merrut";

        step("Open students registration form", () -> {
            open(BASE_URL);
            $(".pactice-form-wrapper").shouldHave(text("Student Registration form"));
        });
    }
}
