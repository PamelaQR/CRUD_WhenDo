package cleanTest;

import activities.whenDo.RemoveTaskScreen;
import activities.whenDo.CreateTaskScreen;
import activities.whenDo.MainScreen;
import activities.whenDo.UpdateTaskScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.net.MalformedURLException;

public class WhenDoTest {

    private MainScreen mainScreen= new MainScreen();
    private CreateTaskScreen createTaskScreen= new CreateTaskScreen();
    private UpdateTaskScreen updateTaskScreen = new UpdateTaskScreen();
    private RemoveTaskScreen confirmationTask = new RemoveTaskScreen();

    public void createTask(String title) throws MalformedURLException {
        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.setValue(title);
        createTaskScreen.descriptionTextBox.setValue("CREANDO TAREA... ");
        createTaskScreen.saveButton.click();
    }

    @Test
    public void verifyCreateTask() throws MalformedURLException {
        String title="CREACION DE TAREA 1";
        createTask(title);

        Assertions.assertEquals(title,mainScreen.nameTaskLabel.getText(),"ERROR! task was not created");
    }

    @Test
    public void modifyTask() throws MalformedURLException {
        String title="CREACION TAREA 2";
        createTask(title);
        mainScreen.nameTaskLabel.click();
        title="MODIFICACION TAREA 2";
        updateTaskScreen.titleTextBox.setValue(title);
        updateTaskScreen.descriptionTextBox.setValue("MODIFICANDO TAREA 2");
        updateTaskScreen.saveButton.click();

        Assertions.assertEquals(title,mainScreen.nameTaskLabel.getText(),"ERROR! task was not modified");

    }
    @Test
    public void removeTask() throws MalformedURLException {
        String title="CREACION TAREA 3";
        createTask(title);
        mainScreen.nameTaskLabel.click();
        updateTaskScreen.removeButton.click();
        boolean result = confirmationTask.deleteButton.click();
        Assertions.assertEquals(true,result,"ERROR! task was not removed");
    }

    @Test
    public void cancelRemoveTask() throws MalformedURLException {
        String title="CREACION TAREA 4";
        createTask(title);
        mainScreen.nameTaskLabel.click();
        updateTaskScreen.removeButton.click();
        boolean result = confirmationTask.cancelbutton.click();
        updateTaskScreen.titleTextBox.getText();
                
        Assertions.assertEquals(true,result,"ERROR! task was not removed");
    }
    @AfterEach
    public void close() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
