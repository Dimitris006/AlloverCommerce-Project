package practice_.tests.US03;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccountCustomerPage;

import practice_.utilities.*;

import java.io.IOException;


public class US03_TC03 {

    @Test
    public void AddBillingAddress() throws IOException {

        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        AlloverCommerce_MyAccountCustomerPage myAccountCustomerPage = new AlloverCommerce_MyAccountCustomerPage();
        Faker faker = new Faker();


//        Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on register link
        alloverCommerceHomePage.register_Link.click();
        WaitUtils.waitFor(1);
        //Enter username
        alloverCommerceHomePage.signUp_Username.sendKeys(faker.name().username());
        WaitUtils.waitFor(1);
        //Enter useremail
        alloverCommerceHomePage.signUp_Email.sendKeys(faker.internet().emailAddress());
        WaitUtils.waitFor(1);
        //enter password
        alloverCommerceHomePage.signUp_Password.sendKeys(faker.internet().password());
        WaitUtils.waitFor(1);
        //select the checkbox
        alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
        WaitUtils.waitFor(1);
        //Click on signup button
        alloverCommerceHomePage.signUp_Button.click();
        WaitUtils.waitFor(10);

        //Click on My Account
        JSUtils.scrollIntoViewJS(AlloverCommerce_MyAccountCustomerPage.myAccountCustomer);
        WaitUtils.waitForClickablility(AlloverCommerce_MyAccountCustomerPage.myAccountCustomer, 10).click();
        //WaitUtils.waitFor(3);
        // MyAccount_CustomerPage.myAccountCustomer.click();

        //Click on Adresses button
        AlloverCommerce_MyAccountCustomerPage.AddressesCustomer.click();
        //Click on Add button for billing adress
        AlloverCommerce_MyAccountCustomerPage.add_link.click();


        AlloverCommerce_MyAccountCustomerPage.billingFirstName.sendKeys(faker.name().username());
        AlloverCommerce_MyAccountCustomerPage.billingLastName.sendKeys(faker.name().username());
        WaitUtils.waitFor(2);

        BrowserUtils.selectByValue(AlloverCommerce_MyAccountCustomerPage.billingCountryName,"TR");

        AlloverCommerce_MyAccountCustomerPage.billingAddress1.sendKeys(faker.address().streetName());
        AlloverCommerce_MyAccountCustomerPage.billingCity.sendKeys(faker.address().city());
        AlloverCommerce_MyAccountCustomerPage.billingPostcode.sendKeys(faker.address().zipCode());
        WaitUtils.waitFor(2);
        BrowserUtils.selectByValue(AlloverCommerce_MyAccountCustomerPage.billingState,"TR07");
        WaitUtils.waitFor(2);
        AlloverCommerce_MyAccountCustomerPage.billingPhone.sendKeys(faker.phoneNumber().cellPhone());
        AlloverCommerce_MyAccountCustomerPage.saveAddressButton.click();
        MediaUtils.takeScreenshotOfTheEntirePage();

        //faker.address().zipCode()
        //faker.phoneNumber().cellPhone()



//        First name, Last name and Email address come up automatically in the input boxes

    }


}


////        Click on Sign In button
//        alloverCommerceHomePage.signIn_Link.click();
////        Enter Username or email adress
//        WaitUtils.waitFor(1);
//        alloverCommerceHomePage.signIn_Username.sendKeys(faker.internet().emailAddress());
//        WaitUtils.waitFor(1);
////        Enter Password
//        alloverCommerceHomePage.signIn_Password.sendKeys(faker.internet().password());
////        Click on SIGN IN button
//        WaitUtils.waitFor(2);
//        alloverCommerceHomePage.signIn_Button.click();
//        WaitUtils.waitFor(2)

//    public void enterSignUpUserEmail() {
//        userEmail.sendKeys(faker.internet().emailAddress());
//    }
//
//    public void enterSignUpUserEmailNegative() {
//        userEmail.sendKeys(ConfigReader.getProperty("customer_email"));
//    }
//
//    public void enterSignUpPassword() {
//        password.sendKeys(faker.internet().password());
//    }







