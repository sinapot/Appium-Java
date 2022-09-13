package iOS;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {

    AppiumDriver driver;

    @BeforeTest
    public void  setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:platformVersion", "15.5");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone 12 Pro");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/MVCTodo.app");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new IOSDriver(remoteUrl, caps);
    }

    @Test
    public void clickButton(){

    driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Create list\"]")).click();
    driver.findElement(AppiumBy.iOSNsPredicateString("value == \"List Name\"")).sendKeys("Test");
    driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Create\"")).click();
    
    }
    /*
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
     */
}