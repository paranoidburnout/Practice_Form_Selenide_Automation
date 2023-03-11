package tests;

import org.junit.jupiter.api.Test;
import utils.RandomFaker;
import utils.UserData;

public class PracticeFormTest extends TestBase {
    @Test
    void fillAndCheckPracticeForm() {
        UserData userData = RandomFaker.getRandomUser();
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
    }
}