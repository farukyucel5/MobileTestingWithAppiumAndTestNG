package tests;

import Locators.CalculatorUserInterface;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {


    AndroidDriver<AndroidElement> driver;
    CalculatorUserInterface calculatorApp;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
        desiredCapabilities.setCapability("platformVersion",ConfigReader.getProperty("platformVersion"));
        desiredCapabilities.setCapability("deviceName",ConfigReader.getProperty("deviceName"));
        desiredCapabilities.setCapability("automationName",ConfigReader.getProperty("automationName"));
        desiredCapabilities.setCapability("app",ConfigReader.getProperty("app"));
        driver= new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        calculatorApp=new CalculatorUserInterface(driver);
    }

    @Test(priority = 1)
    public void multiplyingFeature() throws InterruptedException {
        calculatorApp.clickNum1();
        calculatorApp.getNum1();
        calculatorApp.deleting();
        calculatorApp.clickNum2();
        calculatorApp.getNum2();
        calculatorApp.clickMultiplyingSign();
        calculatorApp.clickNum1();
        calculatorApp.clickEqualsSign();

        Assert.assertEquals(calculatorApp.actualResult(),calculatorApp.expectedResult("*"));
        calculatorApp.clickClear();
    }
    @Test(priority = 2)
    public void dividingFeature() throws InterruptedException {
        calculatorApp.clickNum1();
        calculatorApp.getNum1();
        calculatorApp.deleting();
        calculatorApp.clickNum2();
        calculatorApp.getNum2();
        calculatorApp.clickDividingSign();
        calculatorApp.clickNum1();
        calculatorApp.clickEqualsSign();

        Assert.assertEquals(calculatorApp.actualResult(),calculatorApp.expectedResult("/"));
        calculatorApp.clickClear();

    }
    @Test(priority = 3)
    public void addingFeature() throws InterruptedException {
        calculatorApp.clickNum1();
        calculatorApp.getNum1();
        calculatorApp.deleting();
        calculatorApp.clickNum2();
        calculatorApp.getNum2();
        calculatorApp.clickAddSign();
        calculatorApp.clickNum1();
        calculatorApp.clickEqualsSign();

        Assert.assertEquals(calculatorApp.actualResult(),calculatorApp.expectedResult("+"));
        calculatorApp.clickClear();
    }

    @Test(priority = 4)
    public void subtractingFeature() throws InterruptedException {
        calculatorApp.clickNum1();
        calculatorApp.getNum1();
        calculatorApp.deleting();
        calculatorApp.clickNum2();
        calculatorApp.getNum2();
        calculatorApp.clickSubtractSign();
        calculatorApp.clickNum1();
        calculatorApp.clickEqualsSign();

        Assert.assertEquals(calculatorApp.actualResult(),calculatorApp.expectedResult("-"));
        calculatorApp.clickClear();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
