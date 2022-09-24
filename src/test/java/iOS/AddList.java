package iOS;

import iOS.Base.iosbasetest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AddList extends iosbasetest {

    @Test
    public void addList() throws MalformedURLException {
    ios_setUp();
    driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Create list\"]")).click();
    driver.findElement(AppiumBy.iOSNsPredicateString("value == \"List Name\"")).sendKeys("Test");
    driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Create\"")).click();
    
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}