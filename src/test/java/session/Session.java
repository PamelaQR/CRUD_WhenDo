package session;

import factoryDevices.FactoryDevices;
import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;

public class Session {
    //Para crear este tipo de clase Singleton se debe cumplir 3 cosas:
    // 1.- tener un atributo del mismo tipo
    private static Session instance= null;
    private AppiumDriver driver;

    //2.- tener un constructor privado
    private Session() throws MalformedURLException {
        driver= FactoryDevices.make(FactoryDevices.DeviceType.ANDROID).create();

    }

    //3.-tener un metodo statico publico que retorne la instancia unica
    //synchronized --> no usar para evitar problemas de ejecucion paralela

    public   static Session getInstance() throws MalformedURLException {
        if(instance == null)
            instance = new Session();
        return instance;
    }

    public void closeSession(){
        driver.quit();
        instance=null;
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
