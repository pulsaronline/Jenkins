package tests;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker();

    public static String randomYear() {
        return String.valueOf(faker.number().numberBetween(1900, 2010));
    }

    public static String randomDay() {
        int day = 0;
        day = faker.number().numberBetween(1, 28);
        return String.valueOf(day);
    }
    public static String randomMonth() {

        int generateMonth = faker.number().numberBetween(1, 12);
        String month = null;
        switch (generateMonth) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }
        return month;
    }
}
