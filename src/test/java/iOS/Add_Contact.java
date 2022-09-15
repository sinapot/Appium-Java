package iOS;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Add_Contact {

    AppiumDriver driver;

    @BeforeMethod
    public void  setUp() throws MalformedURLException {
        XCUITestOptions caps = new XCUITestOptions();
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:platformVersion", "15.5");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone 12 Pro");
        caps.setCapability("bundleId","com.apple.MobileAddressBook");

        URL remoteUrl = new URL("http://localhost:4723");

        driver = new IOSDriver(remoteUrl, caps);
    }

    @Test
    public void addContact(){

        driver.findElement(AppiumBy.accessibilityId("Add")).click();
        driver.findElement(AppiumBy.accessibilityId("First name")).sendKeys("Alon");
        driver.findElement(AppiumBy.accessibilityId("Last name")).sendKeys("Alon");
        driver.findElement(AppiumBy.accessibilityId("Company")).sendKeys("Alon");


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}