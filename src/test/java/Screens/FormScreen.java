package Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormScreen {
    protected AppiumDriver driver;
    //constructor
    public FormScreen(AppiumDriver driver){
        this.driver=driver;
    }

        private final By switchbtn = AppiumBy.accessibilityId("switch");
        private final By textInput = AppiumBy.accessibilityId("text-input");


        public void clickSwitch(){
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(switchbtn));
            driver.findElement(switchbtn).click();
            }
        public void typeText(String text){
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(textInput));
            driver.findElement(textInput).sendKeys(text);
        }

        public String isInputFieldPopulated(){
            String text = driver.findElement(textInput).getText();
            return text;
        }
        public String isSwitchActive(){
            String status = driver.findElement(switchbtn).getText();
            return status;
    }

    
}
