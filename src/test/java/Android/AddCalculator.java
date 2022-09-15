package Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class AddCalculator {

    AppiumDriver driver;

    @BeforeMethod
    public void  setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Pixel_4");
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity",".Calculator");
        //non apppium 2.0
        URL remoteUrl = new URL("http://localhost:4723/");

        driver = new AndroidDriver(remoteUrl, caps);
    }

    @Test
    public void clickButton(){

        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();

        Assert.assertEquals(driver.findElement(By.id("com.android.calculator2:id/result")).getText(),"2");


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
