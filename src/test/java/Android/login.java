package Android;

import Android.Base.BaseTest;
import Android.Screens.HomeScreen;
import Android.Screens.LoginForm;
import org.testng.annotations.*;

public class login extends BaseTest {

    HomeScreen homeScreen;
    LoginForm loginForm;

    @Test
    public void gotologin(){

    homeScreen.clickLoginButton();

    }
}