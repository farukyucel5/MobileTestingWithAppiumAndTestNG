import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDay1 {

    AndroidDriver<AndroidElement> driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("platformVersion","9.0");
        desiredCapabilities.setCapability("deviceName","Pixel_2");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("app","C:\\Asoftware\\AppiumProject1\\src\\Apps\\Hm.apk");
        driver= new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
    }
    @Test
    public void app(){

        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementById("com.google.android.calculator:id/digit_8").click();
        AndroidElement result= driver.findElementById("com.google.android.calculator:id/result_preview");
        System.out.println(result.getText());
        Assert.assertEquals(result.getText(), "72");
    }
}
