
package helpers;

import com.codeborne.selenide.Configuration;
import drivers.CustomMobileDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class DriverHelper {

    public static void configureSelenide() {
        Configuration.browser = CustomMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

}