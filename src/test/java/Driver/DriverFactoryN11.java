package Driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactoryN11 {
    static AndroidDriver driver;
    static String properties;
    static DesiredCapabilities desiredCapabilities;

    public static AndroidDriver initializeTheN11Driver() {
        String platformName = ConfigReader.getProperty("platformName");
        properties = ConfigReader.getProperty(platformName);

        desiredCapabilities= new DesiredCapabilities();
        if (platformName.equals("Android")) {
            desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability("platformVersion",ConfigReader.getProperty("platformVersion"));
            desiredCapabilities.setCapability("deviceName",ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability("automationName",ConfigReader.getProperty("automationName"));
            desiredCapabilities.setCapability("appPackage",ConfigReader.getProperty("n11Package"));
            desiredCapabilities.setCapability("appActivity",ConfigReader.getProperty("n11Activity"));

            try {
                driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }


            int impWait = 15;
            driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
        }


        return driver;
    }

    public static void closeDriver() {
        driver.closeApp();
    }
}
