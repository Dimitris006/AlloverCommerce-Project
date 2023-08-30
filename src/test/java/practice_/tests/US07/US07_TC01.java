
package practice_.tests.US07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Compare;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.utilities.*;
import java.io.IOException;
import java.util.List;

public class US07_TC01 {

    @Test
    public void test01() throws IOException {
        //create object for pages
        AlloverCommerce_Compare alloverCommerceCompare = new AlloverCommerce_Compare();
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();

        //navigate to URL
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //click sign in link
        alloverCommerceHomePage.signIn_Link.click();

        //wait for popup to show with sign in tab displayed
        WaitUtils.waitForVisibility(alloverCommerceHomePage.signIn_Tab, 3);
        Assert.assertTrue(alloverCommerceHomePage.signIn_Tab.isDisplayed());

        //fill in customer logIn credentials
        alloverCommerceHomePage.signIn_Username.sendKeys(
                ConfigReader.getProperty("customer_email")
        );
        alloverCommerceHomePage.signIn_Password.sendKeys(
                ConfigReader.getProperty("customer_password")
        );

        WaitUtils.waitFor(1);

        //signIn user
        alloverCommerceHomePage.signIn_Button.click();

        //verify signIn is successful
        Assert.assertTrue(alloverCommerceHomePage.signOut_NavLink.isDisplayed());

//        Scroll down to kitchen products
        JSUtils.scrollIntoViewJS(alloverCommerceCompare.kitchenImagesSection);
        WaitUtils.waitFor(2);

        //Locate all images in Kitchen section
        List<WebElement> hoverKitchenImages = Driver.getDriver().findElements(By.cssSelector(
                "div[data-id='5cf38cb'] img:nth-of-type(1)"
        )) ;

        //    //Returns a list of compare icons for the Kitchen section
        List<WebElement> kitchenCompareIcons = Driver.getDriver().findElements(By.cssSelector(
                "[data-id='5cf38cb'] a[title='Compare']"
        ));

        //loop and hover each element + click on each compare icon for first 4 images
        for (int i = 0; i <= 3; i++) {
            ActionsUtils.hoverOverOnElementActions(
                    hoverKitchenImages.get(i)
            );
            WaitUtils.waitFor(2);
            kitchenCompareIcons.get(i).click();

            if (i != 3) {
                WaitUtils.waitFor(2);
                alloverCommerceCompare.hideComparePopup.click();
            }
        }
    }

    @AfterClass
    public void tearUp() {
        Driver.closeDriver();
    }
}