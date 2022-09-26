import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class Basetest {

    public static AppiumDriver driver;
    AppiumDriverLocalService service;
    public void android_setUp() throws MalformedURLException {
        //run appium service
        startAppium();

        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Pixel_4");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/Android-NativeDemoApp-0.4.0.apk");
        caps.setCapability("appActivity",".MainActivity");
        caps.setCapability("appPackage","com.wdiodemoapp");
        URL remoteUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(remoteUrl, caps);
    }
    @BeforeClass
    @Parameters({"deviceName","platformVersion","platformName","automationName"})
    public void ios_setUp(String deviceName, String platformVersion, String platformName, String automationName) throws MalformedURLException {
        startAppium();

        if (platformName.equals("iOS"))
        {
            XCUITestOptions caps = new XCUITestOptions();
            caps.setCapability("appium:platformVersion", platformVersion);
            caps.setCapability("appium:deviceName", deviceName);
            caps.setCapability("appium:automationName", automationName);
            caps.setCapability("platformName", platformName);
            caps.setCapability("app", System.getProperty("user.dir") + "/apps/iOS-Simulator-NativeDemoApp-0.4.0.app.zip");
            URL remoteUrl = new URL("http://127.0.0.1:4723");
            driver = new IOSDriver(remoteUrl, caps);
        }
        else {
            UiAutomator2Options caps = new UiAutomator2Options();
            caps.setCapability("appium:automationName", automationName);
            caps.setCapability("appium:platformVersion", platformVersion);
            caps.setCapability("platformName", platformName);
            caps.setCapability("appium:deviceName", deviceName);
            caps.setCapability("app",System.getProperty("user.dir")+"/apps/Android-NativeDemoApp-0.4.0.apk");
            caps.setCapability("appActivity",".MainActivity");
            caps.setCapability("appPackage","com.wdiodemoapp");
            URL remoteUrl = new URL("http://127.0.0.1:4723");
            driver = new AndroidDriver(remoteUrl, caps);
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        stopAppium();
    }
    public void startAppium(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }
    public void stopAppium(){
        service.stop();
    }
}
