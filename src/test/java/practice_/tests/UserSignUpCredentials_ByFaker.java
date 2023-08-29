package practice_.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class UserSignUpCredentials_ByFaker {
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;
    private static String username;
    private static String email;
    private static String password;



    @Test
    public void SignUp_ByFaker(){
        Faker faker = new Faker();

        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        alloverCommerceHomePage.register_Link.click();
        username = faker.name().username();
        email = faker.internet().emailAddress();
        password = faker.internet().password(12,13,true,true,true);
        alloverCommerceHomePage.signUp_Username.sendKeys(username);
        alloverCommerceHomePage.signUp_Email.sendKeys(email);
        alloverCommerceHomePage.signUp_Password.sendKeys(password);
        alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
        alloverCommerceHomePage.signUp_Button.click();
        WaitUtils.waitFor(2);
        alloverCommerceHomePage.signOut_NavLink.click();
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.logoutButton);
    }

    @DataProvider
    public Object[][] customerData2(){
        Object[][] data = {
                {username, password, email},
        };

        return data;
    }

}

