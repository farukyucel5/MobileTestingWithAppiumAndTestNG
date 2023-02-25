package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class MobilBrowserTesting {

    @Test
    public void Mobil() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", ConfigReader.getProperty("platformVersionTablet"));
        caps.setCapability("deviceName", ConfigReader.getProperty("deviceNameTablet"));
        caps.setCapability("browserName", "chrome");
        caps.setCapability("chromedriverExecutable", "C:\\Asoftware\\AppiumProject1\\src\\test\\java\\Driver\\chromedriver.exe");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), caps);

        driver.get("https://www.amazon.com");


     //  Set<String> allkinds=driver.getContextHandles();
     //  for (String each:allkinds
     //  ) {
     //      System.out.println(each);
     //      if (each.contains("CHROM")){
     //          driver.context(each);
     //          System.out.println(each);
     //      }

     //  }

     //  System.out.println(driver.getContext());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        MobileElement logo= driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isEnabled());

        MobileElement singUp=driver.findElement(By.xpath("//a[@id='nav-logobar-greeting']"));
        singUp.click();

        MobileElement singUpTitle=driver.findElement(By.tagName("h2"));
        Assert.assertTrue(singUpTitle.isEnabled());

        MobileElement newAccount=driver.findElement(By.xpath("//a[@id='register_accordion_header']"));
        newAccount.isDisplayed();
        newAccount.click();

        driver.findElement(By.xpath("//*[@id='ap_customer_name']"))
                .sendKeys("farukyucel5" + Keys.ENTER);

        MobileElement missingPhoneNumberAndPasswordError=driver.findElement(By.xpath("//h4[text()='There was a problem']"));
        Assert.assertTrue(missingPhoneNumberAndPasswordError.isDisplayed());

        driver.closeApp();




    }
}