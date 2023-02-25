package tests;

import Driver.DriverFactoryN11;
import Locators.N11UserInterfacePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
public class N11Test {
    N11UserInterfacePage n11UserInterfacePage = new N11UserInterfacePage(DriverFactoryN11.initializeTheN11Driver());

    @Test
    public void searchBoxFunctionality(){

        n11UserInterfacePage.clickSearchBox();
        n11UserInterfacePage.typeSearchBoxAndHitEnter("Lenovo Thinkpad");
        n11UserInterfacePage.verifyTheProductListedContainLenovo();

    }

    @AfterTest
    public void tearDown(){
        DriverFactoryN11.closeDriver();
    }
}
