package Android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class ClickButton {

    AppiumDriver driver;

    @BeforeMethod
    public void  setUp() throws MalformedURLException {

        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Pixel_4");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/ApiDemos.apk");

        URL remoteUrl = new URL("http://localhost:4723/");

        driver = new AndroidDriver(remoteUrl, caps);
    }

    @Test
    public void clickButton(){

        driver.findElement(AppiumBy.accessibilityId("App"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}