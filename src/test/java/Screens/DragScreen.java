package Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class DragScreen {
    protected AppiumDriver driver;
    //constructor
    public DragScreen(AppiumDriver driver) { this.driver = driver;  }

    public final By drag_l1 = AppiumBy.accessibilityId("drag-l1");
    public final By drag_l2 = AppiumBy.accessibilityId("drag-l2");
    public final By drag_l3 = AppiumBy.accessibilityId("drag-l3");
    public final By drag_c1 = AppiumBy.accessibilityId("drag-c1");
    public final By drag_c2 = AppiumBy.accessibilityId("drag-c2");
    public final By drag_c3 = AppiumBy.accessibilityId("drag-c3");
    public final By drag_r1 = AppiumBy.accessibilityId("drag-r1");
    public final By drag_r2 = AppiumBy.accessibilityId("drag-r2");
    public final By drag_r3 = AppiumBy.accessibilityId("drag-r3");
    public final By drop_l1 = AppiumBy.accessibilityId("drop-l1");
    public final By drop_l2 = AppiumBy.accessibilityId("drop-l2");
    public final By drop_l3 = AppiumBy.accessibilityId("drop-l3");
    public final By drop_c1 = AppiumBy.accessibilityId("drop-c1");
    public final By drop_c2 = AppiumBy.accessibilityId("drop-c2");
    public final By drop_c3 = AppiumBy.accessibilityId("drop-c3");
    public final By drop_r1 = AppiumBy.accessibilityId("drop-r1");
    public final By drop_r2 = AppiumBy.accessibilityId("drop-r2");
    public final By drop_r3 = AppiumBy.accessibilityId("drop-r3");

    public void dragElement(By sourceElement, By destElement) throws InterruptedException {

        //explicit wait
        WebElement source1 = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(sourceElement));
        WebElement target1 = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(destElement));
        //get element coordinates
        Point source = source1.getLocation();
        Point target = target1.getLocation();
        //instantiate PointerInput Class
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        //instantiate Sequence Class to execute
        Sequence dragNDrop = new Sequence(finger, 1);
        //move finger to source
        dragNDrop.addAction(finger.createPointerMove(   Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                source.x,
                source.y));
        //press pointer down at current location
        dragNDrop.addAction(finger.createPointerDown(   PointerInput.MouseButton.LEFT.asArg()));

        //move while pressed down to target
        dragNDrop.addAction(finger.createPointerMove(   Duration.ofMillis(2000),
                PointerInput.Origin.viewport(),
                target.x,
                target.y));
        //release the finger
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        //execute the dragNDrop Sequence
        driver.perform(Arrays.asList(dragNDrop));
        Thread.sleep(3000);

    }

}