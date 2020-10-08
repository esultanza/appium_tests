package tests;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;
import static helpers.BrowserstackHelper.getBSPublicLink;
import static helpers.DriverHelper.configureSelenide;
import static helpers.DriverHelper.getSessionId;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        configureSelenide();
    }

    @AfterEach
    public void afterEach(){
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browserstack build link", getBSPublicLink(sessionId));

        closeWebDriver();

        attachVideo(sessionId); // in browserstack video url generates after driver close
    }
}
