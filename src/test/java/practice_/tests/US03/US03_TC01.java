package practice_.tests.US03;

import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;


public class US03_TC01 {

    @Test
    public void AddBillingAddress() {

        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();

//        Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

//        Click on Sign In button
        alloverCommerceHomePage.signIn_Link.click();
//        Enter Username or email adress
        alloverCommerceHomePage.signIn_Username.sendKeys("ayomiposi.liad@feerock.com");
//        Enter Password
        alloverCommerceHomePage.signIn_Password.sendKeys("A@yomiposi123");
//        Click on SIGN IN button
        alloverCommerceHomePage.signIn_Button.click();
//        Click on My Account
//        Click on Adresses button
//        Click on Add
//        First name, Last name and Email address come up automatically in the input boxes

    }


}
