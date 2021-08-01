package basicTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasicAppium {

    private AppiumDriver driver;
    //setup -initialize -acciones que se ejecutan antes de cada test
    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Mi A1");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
    // cleanup -teardown
    @AfterEach
    public void cleanup() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void createTaskWhenDo(){
        // Click +
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        // Set Title
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("REMOVE");
        // Set Notas
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("esta es una descripcion");
        // Click Save
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        // Verificacion
        String expectedResult="REMOVE";
        String actualResult=driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();
       //  verificacion
        Assertions.assertEquals(expectedResult,actualResult, "ERROR tarea no fue creado!");

    }
    @Test
    public void modifyTaskWhenDo(){
        createTaskWhenDo();
        //Select item
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).click();
        //Modify Title

        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("Pruebas");
        //Modify Notes
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("Pruebas Pame");
        //Click Save
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        //Verification
        String expectedResult="Pruebas";
        String actualResult=driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();
        Assertions.assertEquals(expectedResult, actualResult, "Error item no modificado");


    }

}
