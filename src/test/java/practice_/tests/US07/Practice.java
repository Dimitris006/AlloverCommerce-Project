package practice_.tests.US07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

public class Practice {

    @Test
    public void practice() {

        //create object for pages
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();

        //navigate to URL
        Driver.getDriver().get("https://allovercommerce.com/");

        //click on register link
        alloverCommerceHomePage.register_Link.click();

        //wait util will wait until the WebElement is visible
        //The wait will be for 15s
        Assert.assertTrue(
                WaitUtils.waitForVisibility(alloverCommerceHomePage.signUp_Button, 15).isDisplayed()
        );

        //username
        String username = "John.Doe11";
        alloverCommerceHomePage.signUp_Username.sendKeys(username);

        String emailAddress = "John.d11@gmail.com";
        //email address
        alloverCommerceHomePage.signUp_Email.sendKeys(emailAddress);

        String password = "admin123";
        //password
        alloverCommerceHomePage.signUp_Password.sendKeys(password);

        //checkbox
        alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();

        //sign up
        alloverCommerceHomePage.signUp_Button.click();

        //check sign out shows
        WebElement signOut = Driver.getDriver().findElement(By.cssSelector("a[href=\"https://allovercommerce.com/my-account-2/customer-logout/\"]"));

        //check if sign out link is there
        Assert.assertTrue(
                WaitUtils.waitForVisibility(signOut, 15).isDisplayed()
        );

        //sign out account here
        signOut.click();

        //locate sign out link again on page
        WebElement signOutLink = Driver.getDriver().findElement(By.xpath("//a[.='Log out']"));

        //sign out confirmation done here
        signOutLink.click();

        //use wait. Check if sign in button is showing
        Assert.assertTrue(
                WaitUtils.waitForVisibility(alloverCommerceHomePage.signIn_Link, 15).isDisplayed()
        );

        //click sign in link
        alloverCommerceHomePage.signIn_Link.click();

        //verify that pop up is showing by locating sign in
        Assert.assertTrue(
                WaitUtils.waitForVisibility(alloverCommerceHomePage.signIn_Button, 15).isDisplayed()
        );

        //fill in username
        alloverCommerceHomePage.signIn_Username.sendKeys(username);

        //fill in password
        alloverCommerceHomePage.signIn_Password.sendKeys(password);

        //click signIn button
        alloverCommerceHomePage.signIn_Button.click();

        //wait for sign in + verify that 'My Account' isDisplayed
        WebElement myAccountText = Driver.getDriver().findElement(By.xpath("//h2[.='My Account']"));
        Assert.assertTrue(
                WaitUtils.waitForVisibility(myAccountText, 15).isDisplayed()
        );

        //Complete Test

        Driver.closeDriver();
    }
}
