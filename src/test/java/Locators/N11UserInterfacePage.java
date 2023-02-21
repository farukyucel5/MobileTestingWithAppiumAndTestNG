package Locators;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class N11UserInterfacePage {
    AndroidDriver driver;

    public N11UserInterfacePage(AndroidDriver driver) {
        this.driver = driver;
    }

    By searchBar = MobileBy.id("com.dmall.mfandroid:id/tvHomeSearchBar");
    By searchBox = MobileBy.id("com.dmall.mfandroid:id/etSearch");

    By searchElement = MobileBy.id("com.dmall.mfandroid:id/keywordTV");


    public void clickSearchBox() {
        WebDriverWait wait = new WebDriverWait(driver,75);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchBar));
        driver.findElement(searchBar).click();

    }

    public void typeSearchBoxAndHitEnter(String text) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text, Keys.ENTER);
        driver.findElement(searchElement).click();
    }


}
