package Android.ApiDemos;

import Android.ApiDemos.BaseTestApiDemos;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


public class ScrollUIAut extends BaseTestApiDemos {

    //Scrolling using Android UI Automator 2
    @Test
    public void scrollDown(){
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));
        element.click();
        By scrollElement = AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))");
        driver.findElement(scrollElement).click();
    }
}