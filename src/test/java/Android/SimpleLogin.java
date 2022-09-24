package Android;

import Android.Screens.HomeScreen;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class login extends BaseTest {

    HomeScreen homeScreen;

    @Test
    public void Gotologin() throws MalformedURLException {
    Android_setUp();

    homeScreen = new HomeScreen(driver);
    homeScreen.clickLogin();

    }
}