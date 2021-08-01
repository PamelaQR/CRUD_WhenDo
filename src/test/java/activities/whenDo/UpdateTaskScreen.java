package activities.whenDo;

import controlAppium.Button;
import controlAppium.Label;
import controlAppium.TextBox;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class UpdateTaskScreen {

    public TextBox titleTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox descriptionTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button saveButton= new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    public Button removeButton= new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));


    public UpdateTaskScreen() {
    }
}
