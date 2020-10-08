package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static helpers.BrowserstackHelper.getBrowserstackUrl;

public class CustomMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("project", "autotests.cloud");
        capabilities.setCapability("build", "My First Build");
        capabilities.setCapability("name", "Bstack-[Java] Sample Test");
        capabilities.setCapability("autoGrantPermissions", "true");
        // Not for FREE plan
//        capabilities.setCapability("browserstack.debug", "true");
//        capabilities.setCapability("browserstack.networkLogs", "true");
//        capabilities.setCapability("browserstack.gpsLocation", "51.51656, -0.1477");
//        capabilities.setCapability("browserstack.geoLocation", "GB");

        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");
        capabilities.setCapability("app", ConfigHelper.getApp());

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

}