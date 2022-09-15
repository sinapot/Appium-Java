package Android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ScrollUIAut {

    AppiumDriver driver;


    @BeforeMethod
    public void  setUp() throws MalformedURLException {
        //DesiredCapabilities caps = new DesiredCapabilities();
        UiAutomator2Options caps = new UiAutomator2Options();

        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Pixel_4");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/ApiDemos.apk");

        URL remoteUrl = new URL("http://localhost:4723/");

        driver = new AndroidDriver(remoteUrl, caps);

    }
    //Scrolling using Android UI Automator 2
    @Test
    public void scrollDown(){
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));
        element.click();
        By scrollElement = AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))");
        driver.findElement(scrollElement).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}