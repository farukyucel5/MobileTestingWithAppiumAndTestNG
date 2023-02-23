package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MobilBrowserTesting {

    @Test
    public void Mobil() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("deviceName", "Pixel_2");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("chromedriverExecutable", "C:\\Asoftware\\AppiumProject1\\src\\test\\java\\Driver\\chromedriver.exe");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), caps);

        driver.get("https://www.amazon.com");

    }
}