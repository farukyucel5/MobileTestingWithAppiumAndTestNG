package Locators;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class N11UserInterfacePage {
    AndroidDriver driver;

    public N11UserInterfacePage(AndroidDriver driver) {
        this.driver = driver;
    }

    By searchBar = MobileBy.id("com.dmall.mfandroid:id/tvHomeSearchBar");
    By searchBox = MobileBy.id("com.dmall.mfandroid:id/etSearch");

    By searchElement = MobileBy.id("com.dmall.mfandroid:id/keywordTV");

    By  ad= MobileBy.id("com.dmall.mfandroid:id/dialogImageView");

    By navigateBack= MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

    By price =MobileBy.xpath("//android.widget.TextView[@text='21153 TL ve altı']");

    By filteredProductList= MobileBy.id("com.dmall.mfandroid:id/tvTitle");



    public void clickSearchBox() {
        try{
            WebDriverWait wait = new WebDriverWait(driver,15);
            wait.until(ExpectedConditions.presenceOfElementLocated(ad));
            driver.findElement(ad).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(navigateBack));
            driver.findElement(navigateBack).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(searchBar));
            driver.findElement(searchBar).click();
        }catch (Exception e) {
            WebDriverWait wait = new WebDriverWait(driver,15);
            wait.until(ExpectedConditions.presenceOfElementLocated(searchBar));
            driver.findElement(searchBar).click();

        }


    }

    public void typeSearchBoxAndHitEnter(String text) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text, Keys.ENTER);
        driver.findElement(searchElement).click();
    }

    public void verifyTheProductListedContainLenovo(){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.presenceOfElementLocated(price));
        driver.findElement(price).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(filteredProductList));
        List<WebElement> productList =driver.findElements(filteredProductList);
        productList.forEach(each-> System.out.println(each.getText()));
        productList.forEach(each->Assert.assertTrue(each.getText().toLowerCase().contains("lenovo")));
    }


}
