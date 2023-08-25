package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_MyAccountCustomerPage {


    public AlloverCommerce_MyAccountCustomerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Faker faker = new Faker();

    //Web elements on Customer My Account page
    @FindBy(xpath = "//a[.='My Account']")
    public static WebElement myAccountCustomer;
    //a[.='My Account'] Addresses
    @FindBy(xpath = "//a[.='Addresses']")
    public static WebElement AddressesCustomer;

    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public static WebElement add_link;

    @FindBy(id = "billing_first_name")
    public static WebElement billingFirstName;

    @FindBy(id = "billing_last_name")
    public static WebElement billingLastName;

    @FindBy(id = "billing_country")
    public static WebElement billingCountryName;
    @FindBy(id = "billing_address_1")
    public static WebElement billingAddress1;
    @FindBy(id = "billing_city")
    public static WebElement billingCity;
    @FindBy(id = "billing_state")
    public static WebElement billingState;
    @FindBy(id = "billing_postcode")
    public static WebElement billingPostcode;
    @FindBy(id = "billing_phone")
    public static WebElement billingPhone;
    @FindBy(name = "save_address")
    public static WebElement saveAddressButton;



}