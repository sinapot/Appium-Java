package Android.Screens;

import Android.Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginForm extends BasePage {
    public LoginForm(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(accessibility = "input-email")
    WebElement email;

    @AndroidFindBy(accessibility = "input-password")
    WebElement password;

    @AndroidFindBy(accessibility = "button-LOGIN")
    WebElement loginbtn;
}
