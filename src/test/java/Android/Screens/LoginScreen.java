package Android.Screens;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LoginScreen {
    protected AppiumDriver driver;

    public LoginScreen(AppiumDriver driver){
        this.driver=driver;
    }

    private final By LOGIN = AppiumBy.accessibilityId("button-LOGIN");
    
    public LoginScreen clickLOGIN(){
        driver.findElement(LOGIN).click();
        return new LoginScreen(driver);
    }

    
}
