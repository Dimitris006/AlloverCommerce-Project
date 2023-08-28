package practice_.tests.US07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Compare;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.utilities.*;
import java.io.IOException;
import java.util.List;

public class US07_TC {

    ExtentReportUtils extentReportUtils = new ExtentReportUtils();


    @BeforeSuite
    public void setExtentReportConfigurations() {

        //Set the custom file path
        //6 character hash code will be added after the name
        ExtentReportUtils.screenshotFilePathName("AlloverCommerce");

        //Set meta-data
        //All this will appear in the dashboard view
        extentReportUtils.addCustomSystemInfo("Application Name", "Allover Commerce Website");
        extentReportUtils.addCustomSystemInfo("Browser", "Chrome");
        extentReportUtils.addCustomSystemInfo("Team Name", "Potter");
        extentReportUtils.addCustomSystemInfo("SQA", "Furkan");
        extentReportUtils.addCustomSystemInfo("Issue", "AC-11");

        // Set the report name and document title
        extentReportUtils.setReportInfo("Smoke Test Report", "Smoke Extent Reports");

        //The test entry would appear in the report’s table of contents,
        // and its details would be displayed in the main report body when the test entry is selected.
        ExtentReportUtils.createTestReport("Compare Product Test (US_07)", "Smoke Test");
    }

    @Test
    public void test01() throws IOException {
        //create object for pages
        AlloverCommerce_Compare alloverCommerceCompare = new AlloverCommerce_Compare();
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();

        //navigate to URL
        ExtentReportUtils.info("Starting Test Case 1");
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        ExtentReportUtils.pass("Navigating to the Homepage");

        //click sign in link
        alloverCommerceHomePage.signIn_Link.click();
        ExtentReportUtils.pass("Sign in button is clicked");

        //wait for popup to show with sign in tab displayed
        ExtentReportUtils.info("Waiting for customer login window to show");
        WaitUtils.waitForVisibility(alloverCommerceHomePage.signIn_Tab, 3);
        Assert.assertTrue(alloverCommerceHomePage.signIn_Tab.isDisplayed());

        //fill in customer logIn credentials
        ExtentReportUtils.info("Entering login credentials");
        alloverCommerceHomePage.signIn_Username.sendKeys(
                ConfigReader.getProperty("customer_email")
        );
        alloverCommerceHomePage.signIn_Password.sendKeys(
                ConfigReader.getProperty("customer_password")
        );
        ExtentReportUtils.passAndCaptureScreenshot("Login input successful");

        WaitUtils.waitFor(1);

        //signIn user
        alloverCommerceHomePage.signIn_Button.click();

        //verify signIn is successful
        Assert.assertTrue(alloverCommerceHomePage.signOut_NavLink.isDisplayed());
        ExtentReportUtils.pass("Successful Login");

//      Scroll down to kitchen products
        ExtentReportUtils.info("Scrolling down to the Kitchen section on the Home page");
        JSUtils.scrollIntoViewJS(alloverCommerceCompare.kitchenImagesSection);
        ExtentReportUtils.passAndCaptureScreenshot("Successfully scrolled down to Kitchen section on Home page");
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
            ExtentReportUtils.pass("Image " + (i + 1) + " successfully added to compare popup");

            if (i != 3) {
                WaitUtils.waitFor(2);
                alloverCommerceCompare.hideComparePopup.click();
                ExtentReportUtils.pass("Image " + (i + 1) + " successfully added to compare popup");
            }
        }
    }

    @Test
    public void test02() throws IOException {
        ExtentReportUtils.info("Starting Test case 2");
        WaitUtils.waitFor(2);
        //create object for pages
        AlloverCommerce_Compare alloverCommerceCompare = new AlloverCommerce_Compare();

        //Locate all remove icons on images that are on the compare popup
        List<WebElement> removeFromComparePopup = Driver.getDriver().findElements(By.cssSelector(
                "div.compare-popup a.remove_from_compare"
        ));

        //Loop and remove all images form compare popup
        int imageIndex = 0;
        int countImages = 1;
        while (removeFromComparePopup.get(imageIndex).isDisplayed()) {
            WaitUtils.waitForClickablility(removeFromComparePopup.get(imageIndex), 5);
            removeFromComparePopup.get(imageIndex).click();
            ExtentReportUtils.pass("Image " + countImages + " successfully removed from compare popup");

            imageIndex++;
            countImages++;
            //needs to scroll right to view remove icon
            if (imageIndex == 3) {
                JSUtils.scrollIntoViewJS(removeFromComparePopup.get(3));
                ActionsUtils.doubleClick(removeFromComparePopup.get(3));
                ExtentReportUtils.info("Final image requires a double click to remove from popup");

                System.out.println("images removed from compare popup");
                break;
            }
        }

        ExtentReportUtils.warning("Last item requires double-clicking to remove...");

        WaitUtils.waitFor(2);
        alloverCommerceCompare.hideComparePopup.click();
        ExtentReportUtils.pass("Compare popup successfully closed");

        WaitUtils.waitFor(2);
        //verify that the compare products popup is not being displayed
        Assert.assertFalse(alloverCommerceCompare.hideComparePopup.isDisplayed());
        ExtentReportUtils.pass("Compare popup no longer showing");

        //scroll to the popular department images section
        JSUtils.scrollIntoViewJS(alloverCommerceCompare.popularDepartmentImagesSection);
        ExtentReportUtils.passAndCaptureScreenshot("Successfully scrolled down to Popular Departments section on Home page");

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
        int countImages2 = 1;

        for (WebElement image : departmentImages) {
            ActionsUtils.hoverOverOnElementActions(image);
            WaitUtils.waitForVisibility(departmentCompareIcons.get(imageIndex2), 5);
            departmentCompareIcons.get(imageIndex2).click();
            ExtentReportUtils.pass("Image " + countImages2 + " successfully added to compare popup");
            imageIndex2++;
            countImages2++;

            if (imageIndex2 == 3) {
                ExtentReportUtils.pass("Image " + countImages2 + " successfully added to compare popup");
                break;
            }
        }
    }

    @Test
    public void test03() throws IOException {
        ExtentReportUtils.info("Starting test case 3");

        AlloverCommerce_Compare alloverCommerceCompare = new AlloverCommerce_Compare();
        WaitUtils.waitFor(2);

        ExtentReportUtils.info("Clicking compare START COMPARE button on compare popup");
        alloverCommerceCompare.startCompareButton.click();
        ExtentReportUtils.pass("Successfully clicked START COMPARE button");

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

        ExtentReportUtils.warning("Last item requires double-clicking to remove...");
        ExtentReportUtils.warning("Sometimes dynamically adds random products when removing last product from the compare page");

        WaitUtils.waitFor(1);

        Assert.assertTrue(alloverCommerceCompare.goShopButton.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("All images successfully removed from the Compare page");
    }

    @AfterSuite
    public void tearDown() {
        Driver.closeDriver();
        ExtentReportUtils.flush();
    }
}