package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import helpers.LoggerHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.Map;
import static helpers.LoggerHelper.logAndPassMyParameter;

public class TestBase {
    private static String executionMode;

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = logAndPassMyParameter("baseUrl", "https://demoqa.com");
        Configuration.browserSize = logAndPassMyParameter("browserSize", "1920x1080");
        executionMode = logAndPassMyParameter("executionMode", "local");

        if (!System.getProperty("os.name").startsWith("Windows")) {
            executionMode = "remote";
        }
        Configuration.browser = logAndPassMyParameter("browser", "chrome");

        if (executionMode.equals("remote")) {
            Configuration.browserVersion = logAndPassMyParameter("browserVersion", "100");

            Configuration.remote = logAndPassMyParameter("selenoidAddress", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            LoggerHelper.log(capabilities.toString());

        }

    }

    @AfterEach
    void addAttachments() {
        Attach.attachAsText("My custom logs", LoggerHelper.getCustomLogs());
        Attach.screenshotAs("Last screen");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (executionMode.equals("remote")) {
            Attach.addVideo();
        }
    }

}