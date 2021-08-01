package factoryDevices;

public class FactoryDevices{
    public enum DeviceType{
        ANDROID,
        IOS,
        WINDOWS_PHONE
    }
    public static IDevice make(DeviceType tipo){
        IDevice device;
        switch (tipo){
            case ANDROID:
                device= new Android();
                break;
            case IOS:
                device= new IOS();
                break;
            case WINDOWS_PHONE:
                device = new WindowsPhone();
                break;
            default:
                device = new Android();
                break;
        }
        return device;

        }

}
