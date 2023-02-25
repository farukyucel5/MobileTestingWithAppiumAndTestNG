package Locators;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CalculatorUserInterface {
    AndroidDriver driver;

    public CalculatorUserInterface(AndroidDriver driver){
        this.driver = driver;
    }

    By num1 = MobileBy.AccessibilityId("3");
    By num2 = MobileBy.AccessibilityId("9");

    By multiplyingSign=MobileBy.AccessibilityId("çarpı");
    By dividingSign=MobileBy.AccessibilityId("bölü");

    By addSign=MobileBy.AccessibilityId("artı");

    By subtractSign=MobileBy.AccessibilityId("eksi");

    By equalsSign=MobileBy.AccessibilityId("eşittir");

    By deleteSign=MobileBy.AccessibilityId("sil");

    By resultSpace=MobileBy.id("com.google.android.calculator:id/formula");

    By finalResultSpace=MobileBy.id("com.google.android.calculator:id/result_final");

    By clear=MobileBy.AccessibilityId("temizle");





    int intNumber1;
    int intNumber2;


    public void clickClear(){
       driver.findElement(clear).click();
    }
   public void clickNum1(){
       driver.findElement(num1).click();
   }
   public void getNum1(){
       intNumber1 = Integer.parseInt(driver.findElement(resultSpace).getText());
   }
   public  void deleting(){
       driver.findElement(deleteSign).click();
   }
   public void clickNum2(){
       driver.findElement(num2).click();
   }
   public void getNum2(){
       intNumber2 = Integer.parseInt(driver.findElement(resultSpace).getText());
   }

   public void clickMultiplyingSign(){
       driver.findElement(multiplyingSign).click();
   }

   public void clickDividingSign(){
       driver.findElement(dividingSign).click();
   }
   public void clickAddSign(){
       driver.findElement(addSign).click();
   }
   public void clickSubtractSign(){
       driver.findElement(subtractSign).click();
   }


   public void clickEqualsSign(){
       driver.findElement(equalsSign).click();
   }

   public int expectedResult(String operation){
       switch(operation){
           case "+":
               return intNumber2 + intNumber1;
           case "-":
               return intNumber2 - intNumber1;
           case "*":
               return intNumber2 * intNumber1;
           case "/":
               return intNumber2 / intNumber1;
           default:
               return 0;
       }
   }

   public int actualResult(){
       return Integer.parseInt(driver.findElement(finalResultSpace).getText());
   }
}
