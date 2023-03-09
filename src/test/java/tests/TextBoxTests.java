package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.ENTER;

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
        executeJavaScript("$('a#aw0').hide();");
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").sendKeys(ENTER);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(By.xpath("//div[@class='modal-body']//td[contains(text(),'Address')]/../td[2]")).shouldHave(text("Street"));
        $(By.xpath("//div[@class='modal-body']//td[contains(text(),'Student Name')]/../td[2]")).shouldHave(text("dsvsz dfvsdas"));
    }
}

