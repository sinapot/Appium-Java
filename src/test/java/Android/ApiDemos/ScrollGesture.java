package Android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import Android.Base.BaseTestApiDemos;

import java.net.MalformedURLException;

public class ScrollGesture extends BaseTestApiDemos {


    //Scrolling using Android UI Automator 2
    @Test
    public void scrollGestureDown() throws MalformedURLException {
    AndroidSetUp();
    driver.findElement(AppiumBy.accessibilityId("Views")).click();
    //Get Screen Dimension
    Dimension size = driver.manage().window().getSize();
    //scroll based on screen percentage
    ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
            "left", size.getWidth()/2, "top", size.getHeight()/4, "width", size.getWidth()/2, "height", size.getHeight()/2,
            "direction", "down",
            "percent", 3.0
    ));
    }
}