import Screens.FormScreen;
import Screens.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Forms extends Basetest {

    @Test
    public void filloutForm() throws MalformedURLException {
        String textInput = "Lorem Ipsum";
        HomeScreen homeScreen = new HomeScreen(getDriver());
        FormScreen formScreen = new FormScreen(getDriver());

        homeScreen.clickForms();
        formScreen.typeText(textInput);

        //check input field is populated
        String text = formScreen.isInputFieldPopulated();
        Assert.assertEquals(text,textInput);
    }

    @Test
    public void clickSwitch() throws MalformedURLException {

        HomeScreen homeScreen = new HomeScreen(getDriver());
        FormScreen formScreen = new FormScreen(getDriver());

        homeScreen.clickForms();
        formScreen.clickSwitch();

        //check that switch is switched on
        String status = formScreen.isSwitchActive();
        Assert.assertTrue(status.equals("1")||status.equals("ON"));
    }
}