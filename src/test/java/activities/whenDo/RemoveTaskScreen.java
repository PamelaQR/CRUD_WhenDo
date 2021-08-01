package activities.whenDo;

import controlAppium.Button;
import controlAppium.TextBox;
import org.openqa.selenium.By;

public class RemoveTaskScreen {

    public Button deleteButton= new Button(By.id("android:id/button1"));
    public Button cancelbutton = new Button(By.id("android:id/button2"));

    public RemoveTaskScreen() {
    }
}
