package Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScreen {
    protected AppiumDriver driver;

    //constructor
    public LoginScreen(AppiumDriver driver){
        this.driver=driver;
    }

        private final By LOGIN = AppiumBy.accessibilityId("button-LOGIN");
        private final By email = AppiumBy.accessibilityId("input-email");
        private final By password = AppiumBy.accessibilityId("input-password");

        public LoginScreen typeEmail(String username){
            new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.elementToBeClickable(email));
            driver.findElement(email).sendKeys(username);
            return new LoginScreen(driver);
        }

        public LoginScreen typeEmailPassword(String passwordinput){
            new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.elementToBeClickable(password));
            driver.findElement(password).sendKeys(passwordinput);
            return new LoginScreen(driver);
    }

        public LoginScreen clickLOGIN(){
            new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.elementToBeClickable(LOGIN));
            driver.findElement(LOGIN).click();
            return new LoginScreen(driver);
            }

    
}
