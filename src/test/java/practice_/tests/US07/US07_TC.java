package practice_.tests.US07;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Compare;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.utilities.ActionsUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

import javax.swing.*;

public class US07_TC {
    @Test
    public void tc01() {
        AlloverCommerce_Compare alloverCommerce_compare = new AlloverCommerce_Compare();
        AlloverCommerce_HomePage alloverCommerce_HomePage = new AlloverCommerce_HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //click on sign in link to show sign in popup
        alloverCommerce_HomePage.signIn_Link.click();

        //verify that sign in tab shows + fill in all credentials
        try{
            //wait for popup to show
            WaitUtils.waitForVisibility(alloverCommerce_HomePage.signIn_Tab, 5);

            //Then verify signIn tab shows
            Assert.assertTrue(alloverCommerce_HomePage.signIn_Tab.isDisplayed());

            //then fill in credentials
            alloverCommerce_HomePage.signIn_Username.sendKeys(ConfigReader.getProperty("customer_email"));
            alloverCommerce_HomePage.signIn_Password.sendKeys(ConfigReader.getProperty("customer_password"));

            //sign in
            alloverCommerce_HomePage.signIn_Button.click();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Scroll down to Kitchen products
        ActionsUtils.scrollToElement(alloverCommerce_compare.kitchenImagesSection);

        for (int i = 0; i <= 4; i++) {
            ActionsUtils.hoverOverOnElementActions(
                    alloverCommerce_compare.hoverKitchenImages.get(i)
            );

            alloverCommerce_compare.kitchenCompareIcons.get(i).click();
        }
    }
}
