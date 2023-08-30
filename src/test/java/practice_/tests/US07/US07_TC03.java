package practice_.tests.US07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Compare;
import practice_.utilities.*;

import java.io.IOException;
import java.util.List;

public class US07_TC03 {
    @Test
    public void test03() throws IOException {
        AlloverCommerce_Compare alloverCommerceCompare = new AlloverCommerce_Compare();

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        WaitUtils.waitForPageToLoad(15);

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

        JSUtils.clickWithTimeoutByJS(alloverCommerceCompare.startCompareButton);

        List<WebElement> removeFromComparePage = Driver.getDriver().findElements(By.cssSelector(
                "a.remove_from_compare"
        ));

        WaitUtils.waitForVisibility(removeFromComparePage.get(0), 3);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://allovercommerce.com/compare-2/");

        while (!removeFromComparePage.isEmpty()) {

            for (WebElement remove : removeFromComparePage) {
                //Re-find remove element
                WebElement currentRemove = Driver.getDriver().findElement(By.cssSelector("a.remove_from_compare"));
                currentRemove.click();
                WaitUtils.waitFor(1);
            }
            // Refresh list
            removeFromComparePage = Driver.getDriver().findElements(By.cssSelector("a.remove_from_compare"));
        }

        WaitUtils.waitFor(1);
        Assert.assertTrue(alloverCommerceCompare.goShopButton.isDisplayed());
    }

    @AfterClass
    public void tearUp() {
        Driver.closeDriver();
    }
}
