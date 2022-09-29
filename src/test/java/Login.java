import Screens.HomeScreen;
import Screens.LoginScreen;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Login extends Basetest {

    @Test
    public void clickLogin() throws MalformedURLException {

        HomeScreen homeScreen = new HomeScreen(getDriver());
        LoginScreen loginScreen = new LoginScreen(getDriver());

        homeScreen.clickLogin();
        loginScreen.typeEmail("test@webdriver.io");
        loginScreen.typeEmailPassword("Test1234!");
        loginScreen.clickLOGIN();
    }
}