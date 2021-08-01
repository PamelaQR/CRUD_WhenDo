package controlAppium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

import java.net.MalformedURLException;
import java.util.List;

public class Control {
    protected WebElement control;
    protected List<WebElement> controls;
    protected By locator;

    public Control(By locator){
        this.locator = locator;
    }
    
    protected  void  findControl() throws MalformedURLException {
        Session session = Session.getInstance();
        AppiumDriver appiumDriver=session.getDriver();
        this.control=appiumDriver.findElement(this.locator);
        //this.control= Session.getInstance().getDriver().findElement(this.locator);
    }

    public boolean click() throws MalformedURLException {
        this.findControl();
        this.control.click();
        return true;
    }

    public String getText() throws MalformedURLException {
        this.findControl();
        return this.control.getText();
    }

}
