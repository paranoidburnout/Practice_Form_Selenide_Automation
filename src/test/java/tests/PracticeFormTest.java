package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase {
    @Test
    void fillAndCheckPracticeForm() {
        registrationPage.openPage()
                .setFirstName("Lissa")
                .setLastName("Vasenko")
                .setEmail("pdbt@gmai.com")
                .setGender("Female")
                .setPhone("5555599999")
                .setBirthDate("05", "September", "1999")
                .setSubjects("Computer Science")
                .selectCheckbox("Music")
                .uploadPicture("src/test/resources/data/wipdaf.PNG")
                .setAddress("NB3.15")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", "Lissa Vasenko")
                .verifyResult("Student Email", "pdbt@gmai.com")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "5555599999")
                .verifyResult("Date of Birth", "05 September,1999")
                .verifyResult("Subjects", "Computer Science")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "wipdaf.PNG")
                .verifyResult("Address", "NB3.15")
                .verifyResult("State and City", "NCR Delhi")
                .close();
    }
}