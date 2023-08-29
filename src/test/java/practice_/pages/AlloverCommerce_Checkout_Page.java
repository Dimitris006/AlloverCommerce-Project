package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_Checkout_Page {
    public AlloverCommerce_Checkout_Page() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy (xpath = "//div[@id='customer_details'] //input[@name='billing_first_name']")
    public WebElement checkout_Firstname;

    @FindBy (xpath = "//div[@id='customer_details'] //input[@name='billing_last_name']")
    public WebElement checkout_Lastname;

    @FindBy (xpath = "//span[@id='select2-billing_country-container']")
    public WebElement checkout_Country;

    @FindBy (xpath = "//input[@id='billing_address_1'] ")
    public WebElement checkout_Street;

    @FindBy (xpath = "//input[@id='billing_city'] ")
    public WebElement checkout_City;

    @FindBy (xpath = "//span[@id='select2-billing_state-container']")
    public WebElement checkout_State;

    @FindBy (xpath = "//input[@id='billing_postcode']")
    public WebElement checkout_ZIP;

    @FindBy (xpath = "//input[@id='billing_phone']")
    public WebElement checkout_Phone;

    @FindBy(xpath = "//input[@id='billing_email']")
    public WebElement checkout_email;

//    @FindBy(xpath = "//button[@id='place_order']")
//    public WebElement checkout_Place_Order_Button;

   @FindBy(xpath = "//*[@id=\"payment_method_bacs\"]")
    public WebElement Wire_transfer_EFT;

    @FindBy(xpath ="//*[@id=\"payment_method_cod\"]")
    public WebElement Pay_at_the_door;

    @FindBy(xpath = "//*[@id=\"place_order\"]")
    public WebElement checkout_Place_Order_Button;

}
