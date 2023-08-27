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

    @FindBy (xpath = "//*[@id='select2-billing_country-container']")
    public WebElement billCountryDropdown;

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


//    @FindBy (xpath = "//*[@name='save_address']")
//    public WebElement saveAddressButton;
//
//    @FindBy (xpath = "//*[@class = 'fas fa-check']")
//    public WebElement succesfullAdd;





}
