package iOS.Base;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class iosbasetest {

    public static AppiumDriver driver;

    public void ios_setUp() throws MalformedURLException {
        XCUITestOptions caps = new XCUITestOptions();

        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:platformVersion", "14.4");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone 12 Pro");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/MVCTodo.app");

        URL remoteUrl = new URL("http://localhost:4723/");

        driver = new IOSDriver(remoteUrl, caps);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
