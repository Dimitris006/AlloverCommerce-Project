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

public class US07_TC02 {

    @Test
    public void test02() throws IOException {
        //create object for pages
        AlloverCommerce_Compare alloverCommerceCompare = new AlloverCommerce_Compare();
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();

        //navigate to URL
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //        Scroll down to kitchen products
        JSUtils.scrollIntoViewJS(alloverCommerceCompare.kitchenImagesSection);
        WaitUtils.waitFor(2);
        MediaUtils.takeScreenshotOfThisElement(alloverCommerceCompare.kitchenImagesSection);

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

        WaitUtils.waitFor(2);
        //Locate all remove icons on images that are on the compare popup
        List<WebElement> removeFromComparePopup = Driver.getDriver().findElements(By.cssSelector(
                "div.compare-popup a.remove_from_compare"
        ));

        //Loop and remove all images form compare popup
        int imageIndex = 0; //1/2
        while (removeFromComparePopup.get(imageIndex).isDisplayed()) {
            WaitUtils.waitForClickablility(removeFromComparePopup.get(imageIndex));
            removeFromComparePopup.get(imageIndex).click();

            imageIndex++;
            //needs to scroll right to view remove icon
            if (imageIndex == 3) {
                JSUtils.scrollIntoViewJS(removeFromComparePopup.get(3));
                ActionsUtils.doubleClick(removeFromComparePopup.get(3));
                System.out.println("images removed from compare popup");
                break;
            }
        }

        MediaUtils.takeScreenshotOfTheEntirePageAsString();
        WaitUtils.waitFor(2);
        alloverCommerceCompare.hideComparePopup.click();

        WaitUtils.waitFor(2);
        //verify that the compare products popup is not being displayed
        Assert.assertFalse(alloverCommerceCompare.hideComparePopup.isDisplayed());

        //scroll to the popular department images section
        JSUtils.scrollIntoViewJS(alloverCommerceCompare.popularDepartmentImagesSection);

        //A list with all the images found in the Department section
        List<WebElement> departmentImages = Driver.getDriver().findElements(By.cssSelector(
                "[data-id='16e6c7'] img:nth-of-type(1)"
        ));

        //Returns a list of compare icons for the Department section
        List<WebElement> departmentCompareIcons = Driver.getDriver().findElements(By.cssSelector(
                "[data-id='16e6c7'] a[title='Compare']"
        ));
        WaitUtils.waitFor(2);
        MediaUtils.takeScreenshotOfThisElement(alloverCommerceCompare.popularDepartmentImagesSection);
        WaitUtils.waitFor(2);

        //loop and hover each element + click on each compare icon for first 4 images

        int imageIndex2 = 0;
        for (WebElement image : departmentImages) {
            ActionsUtils.hoverOverOnElementActions(image);
            WaitUtils.waitForVisibility(departmentCompareIcons.get(imageIndex2), 5);
            departmentCompareIcons.get(imageIndex2).click();
            imageIndex2++;

            if (imageIndex2 == 3) {
                break;
            }
        }
    }

    @AfterClass
    public void tearUp() {
        Driver.closeDriver();
    }
}
