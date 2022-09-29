import Screens.DragScreen;
import Screens.HomeScreen;
import Screens.SwipeScreen;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Swipe extends Basetest {

    @Test
    public synchronized void swipeLeft() throws MalformedURLException, InterruptedException {

        HomeScreen homeScreen = new HomeScreen(getDriver());
        SwipeScreen swipeScreen = new SwipeScreen(getDriver());

        homeScreen.clickSwipe();
        swipeScreen.waitTextToBeVisible();
        swipeScreen.SwipeLeft();
    }
}