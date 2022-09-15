package Android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class ScrollJSExec {

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
    //Scrolling using Javascript Executor until element is clickable
    @Test
    public void scrollDown(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //scrolling down until  Text Switcher is visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("strategy", "accessibility id");
        scrollObject.put("selector", "TextSwitcher");

        js.executeScript("mobile: scroll", scrollObject);

        driver.findElement(AppiumBy.accessibilityId("TextSwitcher")).click();
        Boolean status = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"0\"]")).isDisplayed();
        Assert.assertTrue(status);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}