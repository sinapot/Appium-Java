import Screens.HomeScreen;
import Screens.LoginScreen;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Login extends Basetest {

    HomeScreen homeScreen;
    LoginScreen loginScreen;

    @Test
    public void clicklogin() throws MalformedURLException {

        homeScreen = new HomeScreen(driver);
        loginScreen = new LoginScreen(driver);


        homeScreen.clickLogin();
        loginScreen.typeEmail("test@webdriver.io");
        loginScreen.typeEmailPassword("Test1234!");
        loginScreen.clickLOGIN();
    }
}