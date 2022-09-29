package Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.function.Function;

import static org.testng.AssertJUnit.assertEquals;

public class SwipeScreen {
    protected AppiumDriver driver;
    //constructor
    public SwipeScreen(AppiumDriver driver) { this.driver = driver;  }
    private final By screenText = AppiumBy.accessibilityId("Or swipe vertical to find what I'm hiding.");

    public void waitTextToBeVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(screenText));
    }

    public synchronized void SwipeLeft() throws InterruptedException {

        //created separate methods to get center coordinates of source and target elements
        int sourceX = 350;
        int sourceY = 500;
        int targetX = 50;
        int targetY = 500;

        //instantiate PointerInput Class
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        //instantiate Sequence Class to execute
        Sequence dragNDrop = new Sequence(finger, 1);
        //move finger to source
        dragNDrop.addAction(finger.createPointerMove(   Duration.ofMillis(0),
                PointerInput.Origin.viewport(),sourceX,sourceY));
        //press pointer down at current location
        dragNDrop.addAction(finger.createPointerDown(   PointerInput.MouseButton.LEFT.asArg()));

        //move while pressed down to target
        dragNDrop.addAction(finger.createPointerMove(   Duration.ofMillis(2000),
                PointerInput.Origin.viewport(),targetX,targetY));
        //release the finger
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        //execute the dragNDrop Sequence
        driver.perform(Arrays.asList(dragNDrop));

        Thread.sleep(1000);
    }
}
