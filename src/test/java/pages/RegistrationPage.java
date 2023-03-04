package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private final String PRACTICE_FORM_URI = "/automation-practice-form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            practiceRegistrationForm = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userEmail = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            userState = $("#state"),
            userCity = $("#city"),
            submitButton = $("#submit"),
            hobbiesCheckbox = $("label[for='hobbies-checkbox-3']");


    public RegistrationPage openPage() {
        open(PRACTICE_FORM_URI);
        practiceRegistrationForm.shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        userGender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage selectCheckbox(String value) {
        hobbiesCheckbox.shouldHave(text(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        File fileToUpload = new File(value);
        uploadPicture.uploadFile(fileToUpload);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage selectState(String value) {
        userState.click();
        userState.$(byText(value)).click();

        return this;
    }

    public RegistrationPage selectCity(String value) {
        userCity.click();
        userCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage close() {
        registrationResultsModal.close();

        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }
}