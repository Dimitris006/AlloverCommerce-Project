package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_AddressesPage {

    public AlloverCommerce_AddressesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

        //Addresses Page Locators

    //Shipping Address Locators
    @FindBy (xpath = "//h4[.='Addresses']")
    public WebElement addressesHeader;

    @FindBy (xpath = "//*[@name='shipping_first_name']")
    public WebElement firstNameField;

    @FindBy (xpath = "//*[@href='https://allovercommerce.com/my-account-2/edit-address/shipping/']")
    public WebElement shippingAddressAdd;

    @FindBy (xpath = "//*[@name='shipping_last_name']")
    public WebElement lastNameField;

    @FindBy (xpath = "//*[@name='shipping_company']")
    public WebElement companyName;

    @FindBy (xpath = "//*[@id='select2-shipping_country-container']")
    public WebElement countryDropdwn;

    @FindBy (id = "billing_country")
    public WebElement countryDropdown;

    @FindBy (xpath = "//*[@name='shipping_address_1']")
    public WebElement streetAddress;

    @FindBy (xpath = "//*[@name='shipping_city']")
    public WebElement cityName;

    @FindBy (xpath = "//*[@id='select2-shipping_state-container']")
    public WebElement stateDropdown;

    @FindBy (xpath = "//*[@name='shipping_postcode']")

    public WebElement zipCode;

    @FindBy (xpath = "//*[@name='save_address']")
    public WebElement saveAddressButton;

    @FindBy (xpath = "//*[@class = 'fas fa-check']")
    public WebElement successfulAdd;

    //Billing Address Locators
    @FindBy (xpath = "//*[@href='https://allovercommerce.com/my-account-2/edit-address/billing/']")
    public WebElement billingAddressAdd;

    @FindBy (xpath = "//*[@name='billing_first_name']")
    public WebElement billFirstNameField;

    @FindBy (xpath = "//*[@name='billing_last_name']")
    public WebElement billLastNameField;

    @FindBy (xpath = "//*[@name='billing_company']")
    public WebElement billCompanyName;


//    @FindBy (xpath = "//*[@id='select2-billing_country-container']")

        //    @FindBy (xpath = "//*[@id='select2-billing_country-container']")

//    public WebElement billCountryDropdown;

    @FindBy (xpath = "//*[@name='billing_address_1']")
    public WebElement billStreetAddress;

    @FindBy (xpath = "//*[@name='billing_city']")
    public WebElement billCityName;

    @FindBy (xpath = "//*[@id='select2-billing_state-container']")
    public WebElement billStateDropdown;

    @FindBy (xpath = "//*[@name='billing_postcode']")
    public WebElement billZipCode;

    @FindBy (xpath = "//*[@name='billing_phone']")
    public WebElement billPhone;


//    public WebElement saveAddressButton;
//
//    @FindBy (xpath = "//*[@class = 'fas fa-check']")
//    public WebElement succesfullAdd;

    @FindBy (xpath = "//*[@data-id='shipping_first_name']")
    public WebElement firstNameWrong;

    @FindBy (xpath = "//*[@data-id='shipping_last_name']")
    public WebElement lastNameWrong;

    @FindBy (xpath = "//*[@data-id='shipping_country']")
    public WebElement countryWrong;

    @FindBy (xpath = "//*[@data-id='shipping_address_1']")
    public WebElement addressWrong;

    @FindBy (xpath = "//*[@data-id='shipping_city']")
    public WebElement cityWrong;

    @FindBy (xpath = "//*[@data-id='shipping_state']")
    public WebElement stateWrong;

    @FindBy (xpath = "//*[@data-id='shipping_postcode']")
    public WebElement postcodeWrong;

    @FindBy (xpath = "//*[@name='save_address']")
    public WebElement billSaveAddressButton;

    @FindBy (xpath = "//*[@id='billing_first_name']")
    public WebElement billFirstNameValue;

    @FindBy (xpath = "//*[@name='billing_last_name']")
    public WebElement billLastNameValue;

    @FindBy (xpath = "//*[@data-id='billing_country']")
    public WebElement billCountryWrong;

    @FindBy (xpath = "//*[@data-id='billing_address_1']")
    public WebElement billAddressWrong;

    @FindBy (xpath = "//*[@data-id='billing_city']")
    public WebElement billCityWrong;

    @FindBy (xpath = "//*[@data-id='billing_state']")
    public WebElement billStateWrong;

    @FindBy (xpath = "//*[@data-id='billing_postcode']")
    public WebElement billPostcodeWrong;

    @FindBy (xpath = "//*[@data-id='billing_phone']")
    public WebElement billPhoneWrong;

    @FindBy (xpath = "//select[@id='shipping_country']")
    public WebElement shipCountryDropdown;

    @FindBy (xpath = "//select[@id='billing_country']")
    public WebElement billCountryDropdown;




        //    @FindBy (xpath = "//*[@class = 'fas fa-check']")
//    public WebElement succesfullAdd;

}












