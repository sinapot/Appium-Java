package Android.Screens;

import Android.Base.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

public class SimpleDrag extends AndroidBaseTest {

    @Test
    public void dragTest() throws MalformedURLException {
    Android_setUp();
    WebElement drag = driver.findElement(AppiumBy.accessibilityId("Drag"));
    new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.elementToBeClickable(drag));
    drag.click();
    //explicit wait
    WebElement source1 = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(AppiumBy.accessibilityId("drag-l1")));
    WebElement target1 = new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(driver -> driver.findElement(AppiumBy.accessibilityId("drop-l1")));
    //get element coordinates
    Point source = source1.getLocation();
    Point target = target1.getLocation();
    //instantiate PointerInput and Sequence
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence dragNDrop = new Sequence(finger, 1);
    //move finger to source
    dragNDrop.addAction(finger.createPointerMove(   Duration.ofMillis(0),
                                                    PointerInput.Origin.viewport(),
                                                    source.x,
                                                    source.y));
    //press pointer down at current location
    dragNDrop.addAction(finger.createPointerDown(   PointerInput.MouseButton.LEFT.asArg()));

    //move while pressed down to target
    dragNDrop.addAction(finger.createPointerMove(   Duration.ofMillis(700),
                                                    PointerInput.Origin.viewport(),
                                                    target.x,
                                                    target.y));
    //release the finger
    dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    //execute dragNDrop Sequence
    driver.perform(Arrays.asList(dragNDrop));
    }
}