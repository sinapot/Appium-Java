import Screens.FormScreen;
import Screens.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Forms extends Basetest {
    HomeScreen homeScreen;
    FormScreen formScreen;
    @Test
    public void filloutForm() throws MalformedURLException {

        String textInput = "Lorem Ipsum";
        homeScreen = new HomeScreen(driver);
        formScreen = new FormScreen(driver);

        homeScreen.clickForms();
        formScreen.typeText(textInput);

        //check input field is populated
        String text = formScreen.isInputFieldPopulated();
        Assert.assertEquals(text,textInput);
    }

    @Test
    public void clickSwitch() throws MalformedURLException {

        homeScreen = new HomeScreen(driver);
        formScreen = new FormScreen(driver);

        homeScreen.clickForms();
        formScreen.clickSwitch();

        //check that switch is switched on
        String status = formScreen.isSwitchActive();
        Assert.assertTrue(status.equals("1")||status.equals("ON"));
    }
}