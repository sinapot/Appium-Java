import Screens.DragScreen;
import Screens.HomeScreen;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DragAndDrop extends Basetest {

    @Test
    public synchronized void dragAndDrop() throws MalformedURLException, InterruptedException {

        HomeScreen homeScreen = new HomeScreen(getDriver());
        DragScreen dragScreen = new DragScreen(getDriver());

        homeScreen.clickDrag();
        dragScreen.dragElement(dragScreen.drag_l1,dragScreen.drop_l1);
        dragScreen.dragElement(dragScreen.drag_l2,dragScreen.drop_l2);
        dragScreen.dragElement(dragScreen.drag_l3,dragScreen.drop_l3);
        dragScreen.dragElement(dragScreen.drag_c1,dragScreen.drop_c1);
        dragScreen.dragElement(dragScreen.drag_c2,dragScreen.drop_c2);
        dragScreen.dragElement(dragScreen.drag_c3,dragScreen.drop_c3);
        dragScreen.dragElement(dragScreen.drag_r1,dragScreen.drop_r1);
        dragScreen.dragElement(dragScreen.drag_r2,dragScreen.drop_r2);
        dragScreen.dragElement(dragScreen.drag_r3,dragScreen.drop_r3);

    }
}