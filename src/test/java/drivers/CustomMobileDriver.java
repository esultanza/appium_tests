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
        capabilities.setCapability("project", "Google Pixel");
        capabilities.setCapability("build", "Android");
        capabilities.setCapability("name", "Selenide tests");
        capabilities.setCapability("autoGrantPermissions", "true");
        // Not for FREE plan
//        capabilities.setCapability("browserstack.debug", "true");
//        capabilities.setCapability("browserstack.networkLogs", "true");
//        capabilities.setCapability("browserstack.gpsLocation", "51.51656, -0.1477");
//        capabilities.setCapability("browserstack.geoLocation", "GB");

        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");
        capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

}