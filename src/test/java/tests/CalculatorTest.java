package tests;

import Driver.DriverFactoryCalculator;
import Locators.CalculatorUserInterface;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    CalculatorUserInterface calculatorApp=new CalculatorUserInterface(DriverFactoryCalculator.initializeTheCalculatorDriver());

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
    public void dividingFeature(){
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
    public void addingFeature(){
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
    public void subtractingFeature(){
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
        DriverFactoryCalculator.closeDriver();
    }


}
