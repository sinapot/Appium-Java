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

public class Basetest {

    public static AppiumDriver driver;
    AppiumDriverLocalService service;



    public void android_setUp() throws MalformedURLException {
        //run appium service
        String portNumber = "6666";
        startAppium(portNumber);

        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Pixel_4");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/Android-NativeDemoApp-0.4.0.apk");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability("appActivity",".MainActivity");
        caps.setCapability("appPackage","com.wdiodemoapp");

        URL remoteUrl = new URL("http://127.0.0.1:"+ portNumber);
        driver = new AndroidDriver(remoteUrl, caps);
    }
    @BeforeClass
    public void ios_setUp() throws MalformedURLException {
        //run appium service
        String portNumber = "6666";
        startAppium(portNumber);

        XCUITestOptions caps = new XCUITestOptions();
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:platformVersion", "14.4");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone 12 Pro");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/iOS-Simulator-NativeDemoApp-0.4.0.app.zip");

        URL remoteUrl = new URL("http://127.0.0.1:"+ portNumber);
        driver = new IOSDriver(remoteUrl, caps);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        stopAppium();
    }

    public void startAppium(String portNumber){
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(Integer.parseInt(portNumber))
                .withTimeout(Duration.ofSeconds(300));

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Appium running at port: "+portNumber);
    }

    public void stopAppium(){
        service.stop();
    }
}
