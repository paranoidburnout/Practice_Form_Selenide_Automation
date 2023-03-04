package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    private final String SUBMIT_TITLE = "Thanks for submitting the form";

    private SelenideElement submittingForm = $(".modal-dialog"),
            headerTitle = $("#example-modal-sizes-title-lg"),
            table = $(".table-responsive"),
            closeButton = $("#closeLargeModal");

    public void verifyModalAppears() {
        submittingForm.should(appear);
        headerTitle.shouldHave(text(SUBMIT_TITLE));
    }

    public void verifyResult(String key, String value) {
        table.$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void close() {
        closeButton.click();
    }
}
