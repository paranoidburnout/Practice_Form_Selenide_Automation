import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillAndCheckPracticeForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".main-header").shouldHave(text("Practice Form")).shouldBe(visible);
        $x("//*[text()='Student Registration Form']").shouldBe(visible);
        $("#userName-label").shouldHave(text("Name")).shouldBe(visible);
        $("#firstName").setValue("Lissa");
        $("#lastName").setValue("Vasenko");
        $("#userEmail-label").shouldHave(text("Email")).shouldBe(visible);
        $("#userEmail").setValue("pdbt@gmai.com");
        $(byText("Gender")).shouldBe(visible);
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("5555599999");
        $("#dateOfBirth-label").shouldHave(text("Date of Birth")).shouldBe(visible);
        $("#dateOfBirthInput").shouldBe(visible).click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(By.cssSelector("div.react-datepicker__day[aria-label='Choose Sunday, September 5th, 1999']")).click();
        $("#subjects-label").shouldHave(text("Subjects")).shouldBe(visible);
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("label[for='hobbies-checkbox-1']").shouldHave(text("Sport")).click();
        $("label[for='hobbies-checkbox-2']").shouldHave(text("Reading")).click();
        $("label[for='hobbies-checkbox-3']").shouldHave(text("Music")).click();
        File fileToUpload = new File("src/test/resources/data/wipdaf.PNG");
        $("#uploadPicture").uploadFile(fileToUpload);
        $("#currentAddress-label").shouldHave(text("Current Address"));
        $("#currentAddress").setValue("NB3.15");
        $("#stateCity-label").shouldHave(text("State and City"));
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Lissa Vasenko"));
        $(".modal-body").shouldHave(text("pdbt@gmai.com"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("5555599999"));
        $(".modal-body").shouldHave(text("05 September,1999"));
        $(".modal-body").shouldHave(text("Computer Science"));
        $(".modal-body").shouldHave(text("Sports, Reading, Music"));
        $(".modal-body").shouldHave(text("wipdaf.PNG"));
        $(".modal-body").shouldHave(text("NB3.15"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}