package practice_.tests.US01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.*;

public class US01_TC07 {
        AlloverCommerce_HomePage alloverCommerceHomePage;
        AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;
        @Test
        public void TC07() {

                Faker faker = new Faker();
                String username = faker.name().name();
                String email = faker.internet().emailAddress();

                alloverCommerceHomePage = new AlloverCommerce_HomePage();
                alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
                alloverCommerceHomePage.register_Link.click();
                alloverCommerceHomePage.signUp_Username.sendKeys(username);
                alloverCommerceHomePage.signUp_Email.sendKeys(email);
                alloverCommerceHomePage.signUp_Password.sendKeys("Janedoe1234.");
                //alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
                alloverCommerceHomePage.signUp_Button.click();
                WaitUtils.waitFor(2);
                //BrowserUtils.verifyElementNotDisplayed(alloverCommerceHomePage.signOut_Link);
                //Assert.assertFalse(alloverCommerceHomePage.signOut_Link.isDisplayed());
                Driver.closeDriver();

        }
}
