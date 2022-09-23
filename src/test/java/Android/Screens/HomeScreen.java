package Android.Screens;


import Android.Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BasePage {

    public HomeScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(accessibility = "Login")
    WebElement loginbtn;

    public void clickLoginButton(){
        click(loginbtn);
    }
}
