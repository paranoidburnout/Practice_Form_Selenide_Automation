package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class RandomFaker {

    public static UserData getRandomUser() {
        Faker faker = new Faker(new Locale("en"));

        String userName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = faker.options().option("Male", "Female", "Other"),
                userPhone = faker.phoneNumber().subscriberNumber(10),
                userSubjects = faker.options().option("Computer Science", "Hindi", "Arts", "Biology", "English"),
                hobbies = faker.options().option("Sport", "Reading", "Music"),
                address = faker.address().fullAddress();

        String file = "src/test/resources/data/wipdaf.PNG";

        Date fakerDate = faker.date().birthday();

        SimpleDateFormat sdfDay = new SimpleDateFormat("d", Locale.ENGLISH);
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat sdfYear = new SimpleDateFormat("y", Locale.ENGLISH);

        String month = sdfMonth.format(fakerDate);
        String year = sdfYear.format(fakerDate);
        String day = sdfDay.format(fakerDate);

        var mapStateWithCity = Map.of(
                "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
                "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
                "Haryana", new String[]{"Karnal", "Panipat"},
                "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
        );

        String state = (String) faker.options().option(mapStateWithCity.keySet().toArray());
        String city = faker.options().option(mapStateWithCity.get(state));


        return new UserData()
                .thisFirstName(userName)
                .thisLastName(lastName)
                .thisEmail(userEmail)
                .thisGender(userGender)
                .thisPhone(userPhone)
                .thisDay(day)
                .thisMonth(month)
                .thisYear(year)
                .thisSubjects(userSubjects)
                .thisHobbies(hobbies)
                .thisPicture(file)
                .thisAddress(address)
                .thisState(state)
                .thisCity(city);
    }
}