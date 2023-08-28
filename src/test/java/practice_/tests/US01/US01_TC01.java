package practice_.tests.US01;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.*;

import static practice_.utilities.JSUtils.clickWithTimeoutByJS;

public class US01_TC01 {
        AlloverCommerce_HomePage alloverCommerceHomePage;
        AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;


        @Test
        public void TC01() {

                Faker faker = new Faker();
                alloverCommerceHomePage = new AlloverCommerce_HomePage();
                alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
                alloverCommerceHomePage.register_Link.click();
                String username = faker.name().name();
                String email = faker.internet().emailAddress();
                System.out.println("username = " + username);
                System.out.println("email = " + email);
                alloverCommerceHomePage.signUp_Username.sendKeys(username);
                alloverCommerceHomePage.signUp_Email.sendKeys(email);
                alloverCommerceHomePage.signUp_Password.sendKeys("Jackdoe1234.");
                alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
                clickWithTimeoutByJS(alloverCommerceHomePage.signUp_Button);
                WaitUtils.waitFor(2);
                BrowserUtils.verifyElementDisplayed(alloverCommerceHomePage.signOut_Link);
                Driver.closeDriver();

        }
}
