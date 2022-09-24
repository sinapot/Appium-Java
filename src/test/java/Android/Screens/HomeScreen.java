package Android.Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomeScreen {
    protected AppiumDriver driver;

    public HomeScreen(AppiumDriver driver){
        this.driver=driver;
    }

    private final By loginbtn = AppiumBy.accessibilityId("Login");

    public HomeScreen clickLogin(){
        driver.findElement(loginbtn).click();
        return new HomeScreen(driver);
    }

}
