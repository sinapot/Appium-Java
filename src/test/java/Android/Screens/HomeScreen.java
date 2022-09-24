package Android.Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeScreen {

    public HomeScreen(AppiumDriver driver){
        this.driver=driver;
    }
    protected AppiumDriver driver;

    private final By loginbtn = AppiumBy.accessibilityId("Login");

    public HomeScreen clickLogin(){
        driver.findElement(loginbtn).click();
        return new HomeScreen(driver);
    }

}
