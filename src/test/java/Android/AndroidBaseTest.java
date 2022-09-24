package Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidBaseTest {

    public static AppiumDriver driver;

    public void Android_setUp() throws MalformedURLException {
        //DesiredCapabilities caps = new DesiredCapabilities();
        UiAutomator2Options caps = new UiAutomator2Options();

        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Pixel_4");
        //caps.setCapability("app",System.getProperty("user.dir")+"/apps/Android-NativeDemoApp-0.4.0.apk");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability("appActivity",".MainActivity");
        caps.setCapability("appPackage","com.wdiodemoapp");

        URL remoteUrl = new URL("http://localhost:4723/");

        driver = new AndroidDriver(remoteUrl, caps);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
