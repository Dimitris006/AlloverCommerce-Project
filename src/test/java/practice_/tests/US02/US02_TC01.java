package practice_.tests.US02;

import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.MediaUtils;
import practice_.utilities.WaitUtils;

import java.io.IOException;

public class US02_TC01   {
    @Test
    public void UnsuccessfulRegister() throws IOException {
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        //Go to homepage
        Driver.getDriver().get("https://allovercommerce.com/");
        //Verify if the url runs
        Assert.assertTrue(alloverCommerceHomePage.welcomeToAllovercommerce.isDisplayed());
        //Click the register Link
        alloverCommerceHomePage.register_Link.click();
        //Enter registered username in the Username field
        alloverCommerceHomePage.signUp_Username.sendKeys("ayomiposi");
        //Enter registered email in the Email field
        alloverCommerceHomePage.signUp_Email.sendKeys("ayomiposi.liad@feerock.com");
        //Enter password in password field
        alloverCommerceHomePage.signUp_Password.sendKeys("A@yomiposi123");
        //Confirm I agree to the privacy policy
        alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
        //Click the SIGN-UP button
        alloverCommerceHomePage.signUp_Button.click();
        //Verify if the warning text and "Please log in." message must be seen
        Assert.assertTrue(alloverCommerceHomePage.alreadyRegisteredAcount.isDisplayed());
        //Wait 2 Second
        WaitUtils.waitFor(2);
        //Close the drive
        Driver.closeDriver();
        //Take Screenshot
        MediaUtils.takeScreenshotOfTheEntirePage();


    }
}
