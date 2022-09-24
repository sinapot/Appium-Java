package Android.ApiDemos;

import Android.ApiDemos.BaseTestApiDemos;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class ScrollJSExec extends BaseTestApiDemos {

    //Scrolling using Javascript Executor until element is clickable
    @Test
    public void mobileScroll(){
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

}