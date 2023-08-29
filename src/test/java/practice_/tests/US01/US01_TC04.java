package practice_.tests.US01;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.BrowserUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

import java.time.Duration;

public class US01_TC04 {
        AlloverCommerce_HomePage alloverCommerceHomePage;
        AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;
        @Test
        public void TC04() {
                Faker faker = new Faker();
                String username = faker.name().name();
                String email = faker.internet().emailAddress();
                System.out.println("username = " + username);
                System.out.println("email = " + email);

                alloverCommerceHomePage = new AlloverCommerce_HomePage();
                alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
                alloverCommerceHomePage.register_Link.click();
                alloverCommerceHomePage.signUp_Username.sendKeys(username);
                alloverCommerceHomePage.signUp_Email.sendKeys(email);
                alloverCommerceHomePage.signUp_Password.sendKeys("Janedoe12345");
                alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
                alloverCommerceHomePage.signUp_Button.click();
                WaitUtils.waitFor(2);
                BrowserUtils.verifyElementDisplayed(alloverCommerceHomePage.signOut_Link);
                Driver.closeDriver();

        }
}
