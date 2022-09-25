import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Basetest {

    public static AppiumDriver driver;

    @BeforeClass
    public void android_setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();

        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Pixel_4");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/Android-NativeDemoApp-0.4.0.apk");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability("appActivity",".MainActivity");
        caps.setCapability("appPackage","com.wdiodemoapp");

        URL remoteUrl = new URL("http://localhost:4723/");

        driver = new AndroidDriver(remoteUrl, caps);
    }

    public void ios_setUp() throws MalformedURLException {
        XCUITestOptions caps = new XCUITestOptions();

        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:platformVersion", "14.4");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone 12 Pro");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/iOS-Simulator-NativeDemoApp-0.4.0.app.zip");

        URL remoteUrl = new URL("http://localhost:4723/");

        driver = new IOSDriver(remoteUrl, caps);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
