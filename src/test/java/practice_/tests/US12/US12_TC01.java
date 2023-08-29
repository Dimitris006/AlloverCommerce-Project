package practice_.tests.US12;


public class US12_TC01 {

    // import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
//import practice_.pages.AlloverCommerce_AddressesPage;
//import practice_.pages.AlloverCommerce_HomePage;
//import practice_.pages.AlloverCommerce_MyAccount_Page;
//import practice_.utilities.ConfigReader;
//import practice_.utilities.Driver;
//import practice_.utilities.MediaUtils;
//import practice_.utilities.WaitUtils;

//import java.io.IOException;

//import static org.testng.AssertJUnit.assertEquals;
//import static org.testng.AssertJUnit.assertTrue;
//import static practice_.utilities.JSUtils.clickWithTimeoutByJS;

    //public class US12_TC01 {

        // WebDriver driver;
        // AlloverCommerce_HomePage alloverCommerceHomePage;
        // AlloverCommerce_MyAccount_Page myAccountPage;
        // AlloverCommerce_AddressesPage alloverCommerceAddressesPage;

        // @Test
        // public void BillingAddress01() throws IOException {

        //Go to homepage
        // Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on Sign In Link
        //alloverCommerceHomePage = new AlloverCommerce_HomePage();
        //alloverCommerceHomePage.signIn_Link.click();

        //Enter username or email address
        // alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter password
        // alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Click on Sign In Button
        //alloverCommerceHomePage.signIn_Button.click();

        //Click on Sign Out Link
        // WaitUtils.waitFor(5);
        // alloverCommerceHomePage.signOut_Link.click();

        //Click on Addresses Link
        // myAccountPage = new AlloverCommerce_MyAccount_Page();
        // clickWithTimeoutByJS(myAccountPage.addressesLinkIcon);

        //Click on Add Link at Shipping Address
        //  alloverCommerceAddressesPage =new AlloverCommerce_AddressesPage();
        //  clickWithTimeoutByJS(alloverCommerceAddressesPage.billingAddressAdd);

        //Insertion of Details
        // System.out.println(alloverCommerceAddressesPage.billFirstNameValue.getText());
        // assertTrue(alloverCommerceAddressesPage.billFirstNameValue.getText().contains("John"));

//        assertEquals(alloverCommerceAddressesPage.bill.toString(), "Lenon");


//        alloverCommerceAddressesPage.billFirstNameField.sendKeys("Jane");
//        alloverCommerceAddressesPage.billLastNameField.sendKeys("Veo");
//        alloverCommerceAddressesPage.billCompanyName.sendKeys("One");
//        BrowserUtils.selectDropdownByValue(AlloverCommerce_AddressesPage(alloverCommerceAddressesPage.billCountryDropdwn), String "Afghanistan");
//        alloverCommerceAddressesPage.billStreetAddress.sendKeys("Home 2");
//        alloverCommerceAddressesPage.billCityName.sendKeys("Village");
//       BrowserUtils.selectDropdownByValue;
//        alloverCommerceAddressesPage.billZipCode.sendKeys("11333");
//        alloverCommerceAddressesPage.billPhone.sendKeys("0001110001");
//
//        //Visibility of Save Address Button
       // assertTrue(alloverCommerceAddressesPage.billSaveAddressButton.isDisplayed());
//        clickWithTimeoutByJS(alloverCommerceAddressesPage.billSaveAddressButton);
//        assertTrue(alloverCommerceAddressesPage.addressesHeader.isDisplayed());

       // MediaUtils.takeScreenshotOfTheEntirePage();

       // Driver.closeDriver();


    }

