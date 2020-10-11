package tests;

import com.codeborne.selenide.CollectionCondition;
import config.ConfigHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.*;
import static io.qameta.allure.Allure.step;

@Feature("Selenide-appium Android tests")
@Story("Search tests")
@Tag("android")
class SearchTests extends TestBase {
    @Test
    @DisplayName("Andromeda Nebula search in Wikipedia android app")
    void WikipediaWithSteps() {
        step("Open application", () -> open());

        step("Type search", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Hyperspace");
        });

        step("Verify content found", () ->
                $$(className("android.widget.TextView")).shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
//    @Disabled("Example without steps")
    @DisplayName("Tesla search in Wikipedia android app without steps")
    void WikipediaWithoutSteps() {
        open();

        $(AccessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Tesla");

        $$(className("android.widget.TextView")).shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
//    @Disabled("Java + Appium")
    @DisplayName("Clean Java + Appium search in Wikipedia android app")
    void BSappSamsungGalaxyTabTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "Samsung Galaxy S10e");
        caps.setCapability("os_version", "9.0");
        caps.setCapability("project", "Samsung Tab");
        caps.setCapability("build", "Android");
        caps.setCapability("name", "Java + Appium");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + ConfigHelper.getUsername() + ":" + ConfigHelper.getPassword() + "@hub-cloud.browserstack.com/wd/hub"), caps);
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("last news");
        Thread.sleep(5000);
        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assert (allProductsName.size() > 0);
        driver.quit();
    }
}