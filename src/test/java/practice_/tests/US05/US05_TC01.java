package practice_.tests.US05;

import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.tests.UserSignUpCredentials_ByFaker;
import practice_.utilities.*;

public class US05_TC01{

    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;


    @Test(dependsOnMethods = "practice_.tests.UserSignUpCredentials_ByFaker.SignUp_ByFaker", dataProvider = "customerData2", dataProviderClass = UserSignUpCredentials_ByFaker.class)
    public void TC01(String username, String password, String email) {

        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

        Driver.getDriver().navigate().to(ConfigReader.getProperty("allovercommerce_url"));

        alloverCommerceHomePage.signIn_Link.click();
        alloverCommerceHomePage.signIn_Username.sendKeys(username);
        alloverCommerceHomePage.signIn_Password.sendKeys(password);
        alloverCommerceHomePage.signIn_Button.click();
        //Assert.assertTrue(alloverCommerceMyAccountPage.accountDetailslink.isDisplayed());
        Driver.closeDriver();
    }
}
