import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("dsvsz");
        $("#lastName").setValue("dfvsdas");
        $("#userEmail").sendKeys("name@example.com");
        $("#gender-radio-3").sendKeys(" ");
        $("#userNumber").sendKeys("1934577890");
        $("#hobbies-checkbox-1").sendKeys(" ");
        $("#hobbies-checkbox-2").sendKeys(" ");
        $("#hobbies-checkbox-3").sendKeys(" ");
        $("#currentAddress").sendKeys("Street");
        $("#state").click();
        $("#react-select-3-option-1").click();;
        $("#city").click();
        $("#react-select-4-option-0").click();;
        $("#submit").sendKeys(Keys.ENTER);

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}
