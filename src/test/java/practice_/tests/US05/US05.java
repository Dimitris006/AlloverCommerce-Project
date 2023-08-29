package practice_.tests.US05;

import com.github.javafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class US05 {
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;
    public static String username;
    public static String email;
    public static String password;



    @BeforeTest
            public void US05_signUp(){
        Faker faker = new Faker();

        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        alloverCommerceHomePage.register_Link.click();
        String username = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(12,13,true,true,true);
        alloverCommerceHomePage.signUp_Username.sendKeys(username);
        alloverCommerceHomePage.signUp_Email.sendKeys(email);
        alloverCommerceHomePage.signUp_Password.sendKeys(password);
        alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
        alloverCommerceHomePage.signUp_Button.click();
        WaitUtils.waitFor(2);
        alloverCommerceHomePage.signOut_NavLink.click();
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.logoutButton);
        Driver.closeDriver();
    }

    }

