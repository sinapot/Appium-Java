package Android;

import Android.Base.BaseTest;
import Android.Screens.HomeScreen;
import Android.Screens.LoginForm;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class simpletest extends BaseTest {

    HomeScreen homeScreen;
;

    @Test
    public void gotologin(){

        driver.findElement(AppiumBy.accessibilityId("Login")).click();

    }
}