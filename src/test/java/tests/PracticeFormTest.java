package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.RandomFaker;
import utils.UserData;

import static io.qameta.allure.Allure.step;

@Feature("Возможность создания и заполнения формы регистрации")
@Owner("vasenkoea")
@Severity(SeverityLevel.BLOCKER)
@Tag("Registration")
public class PracticeFormTest extends TestBase {

    @CsvSource(value = {"Male", "Female", "Other"})
    @ParameterizedTest
    @DisplayName("Корректное отображение поля {1} выбранных при регистрации в модульном окне подтверждения")
    @Tags({
            @Tag("REGRESS"),
            @Tag("UI")
    })
    void fillAndCheckParameterizedGenderInPracticeForm(String gender) {
        UserData userData = RandomFaker.getRandomUser();
        step("Заполнение обязательных полей", () -> {
            registrationPage.openPage()
                    .setFirstName(userData.getFirstName())
                    .setLastName(userData.getLastName())
                    .setGender(gender)
                    .setPhone(userData.getPhone())
                    .submit();
        });
        step("Проверка обязательно заполненных полей", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", userData.getFirstName() + " " + userData.getLastName())
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", userData.getPhone())
                    .close();
        });
    }

    @CsvFileSource(resources = "/data/firstNameAndSecondNameData.csv")
    @ParameterizedTest(name = "Корректное отображение имени {0}, фамилии {1} введенных при регистрации в окне подтверждения")
    @Tags({
            @Tag("REGRESS"),
            @Tag("UI")
    })
    void fillAndCheckParametrNameAndLastNameInPracticeForm(String name, String lastName) {
        UserData userData = RandomFaker.getRandomUser();
        step("Заполнение обязательных полей", () -> {
            registrationPage.openPage()
                    .setFirstName(name)
                    .setLastName(lastName)
                    .setGender(userData.getGender())
                    .setPhone(userData.getPhone())
                    .submit();
        });
        step("Проверка обязательно заполненных полей", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", name + " " + lastName)
                    .verifyResult("Gender", userData.getGender())
                    .verifyResult("Mobile", userData.getPhone())
                    .close();
        });
    }

    @ValueSource(strings = {"Lissa", "Maggie", "Emma", "Dekrissa"})
    @ParameterizedTest(name = "Корректное отображение имени со значением {0} введенного при регистрации в модальном окне подтверждения")
    @Tag("UI")
    void fillAndCheckParametrNameInPracticeForm(String data) {
        UserData userData = RandomFaker.getRandomUser();
        registrationPage.openPage()
                .setFirstName(data)
                .setLastName(userData.getLastName())
                .setGender(userData.getGender())
                .setPhone(userData.getPhone())
                .submit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", data + " " + userData.getLastName())
                .verifyResult("Gender", userData.getGender())
                .verifyResult("Mobile", userData.getPhone())
                .close();
    }

    @Flaky
    @ValueSource(strings = {"Lissa", "Maggie", "Emma", "Dekrissa"})
    @ParameterizedTest(name = "Корректное отображение имени со значением {0} введенного при регистрации в модальном окне подтверждения")
    @Tag("UI")
    void fillAndCheckPracticeForm(String data) {
        UserData userData = RandomFaker.getRandomUser();
        step("Заполнение всех полей формы регистрации", () -> {
            registrationPage.openPage()
                    .setFirstName(data)
                    .setLastName(userData.getLastName())
                    .setEmail(userData.getEmail())
                    .setGender(userData.getGender())
                    .setPhone(userData.getPhone())
                    .setBirthDate(userData.getDay(), userData.getMonth(), userData.getYear())
                    .setSubjects(userData.getSubjects())
                    .selectCheckbox(userData.getHobbies())
                    .uploadPicture(userData.getPicture())
                    .setAddress(userData.getAddress())
                    .selectState(userData.getState())
                    .selectCity(userData.getCity())
                    .submit();
        });
        step("Проверка результатов во всплывающем окне регистрации", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", data + " " + userData.getLastName())
                    .verifyResult("Student Email", userData.getEmail())
                    .verifyResult("Gender", userData.getGender())
                    .verifyResult("Mobile", userData.getPhone())
                    .verifyResult("Date of Birth", userData.getDay() + " " + userData.getMonth() + "," + userData.getYear())
                    .verifyResult("Subjects", userData.getSubjects())
                    .verifyResult("Hobbies", userData.getHobbies())
                    .verifyResult("Picture", userData.getPicture().substring(24))
                    .verifyResult("Address", userData.getAddress())
                    .verifyResult("State and City", userData.getState() + " " + userData.getCity())
                    .close();
        });
    }

    @Test
    @DisplayName("Check Practice Form with PO and Faker")
    void fillAndCheckPracticeForm() {
        UserData userData = RandomFaker.getRandomUser();
        step("Заполнение формы реистрации", () -> {
            registrationPage.openPage()
                    .setFirstName(userData.getFirstName())
                    .setLastName(userData.getLastName())
                    .setEmail(userData.getEmail())
                    .setGender(userData.getGender())
                    .setPhone(userData.getPhone())
                    .setBirthDate(userData.getDay(), userData.getMonth(), userData.getYear())
                    .setSubjects(userData.getSubjects())
                    .selectCheckbox(userData.getHobbies())
                    .uploadPicture(userData.getPicture())
                    .setAddress(userData.getAddress())
                    .selectState(userData.getState())
                    .selectCity(userData.getCity())
                    .submit();
        });

        step("Проверка результатов заполнения", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", userData.getFirstName() + " " + userData.getLastName())
                    .verifyResult("Student Email", userData.getEmail())
                    .verifyResult("Gender", userData.getGender())
                    .verifyResult("Mobile", userData.getPhone())
                    .verifyResult("Date of Birth", userData.getDay() + " " + userData.getMonth() + "," + userData.getYear())
                    .verifyResult("Subjects", userData.getSubjects())
                    .verifyResult("Hobbies", userData.getHobbies())
                    .verifyResult("Picture", userData.getPicture().substring(24))
                    .verifyResult("Address", userData.getAddress())
                    .verifyResult("State and City", userData.getState() + " " + userData.getCity())
                    .close();
        });
    }
}