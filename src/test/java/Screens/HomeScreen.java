package Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomeScreen {
    protected AppiumDriver driver;

    public HomeScreen(AppiumDriver driver){
        this.driver=driver;
    }

        private final By login = AppiumBy.accessibilityId("Login");
        private final By forms = AppiumBy.accessibilityId("Forms");
        private final By home = AppiumBy.accessibilityId("Home");
        private final By swipe = AppiumBy.accessibilityId("Swipe");
        private final By drag = AppiumBy.accessibilityId("Drag");


        public void clickLogin(){
            driver.findElement(login).click();
        }
        public void clickHome(){
            driver.findElement(home).click();
        }
        public void clickForms(){
            driver.findElement(forms).click();
        }
        public void clickSwipe(){
            driver.findElement(swipe).click();
        }
        public void clickDrag(){
            driver.findElement(drag).click();
        }

}
