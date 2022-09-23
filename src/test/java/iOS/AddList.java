package iOS;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class AddList {

    AppiumDriver driver;

    @BeforeMethod
    public void  setUp() throws MalformedURLException {
        XCUITestOptions caps = new XCUITestOptions();
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:platformVersion", "14.4");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone 12 Pro");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/MVCTodo.app");

        URL remoteUrl = new URL("http://localhost:4723");

        driver = new IOSDriver(remoteUrl, caps);
    }

    @Test
    public void addList(){

    driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Create list\"]")).click();
    driver.findElement(AppiumBy.iOSNsPredicateString("value == \"List Name\"")).sendKeys("Test");
    driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Create\"")).click();
    
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}