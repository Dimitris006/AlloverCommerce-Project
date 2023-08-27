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

    @FindBy (xpath = "(//select)[1] ")
    public WebElement checkout_Country;

    @FindBy (xpath = "//input[@id='billing_address_1'] ")
    public WebElement checkout_Street;

    @FindBy (xpath = "//input[@id='billing_city'] ")
    public WebElement checkout_City;

    @FindBy (xpath = "(//select)[2]")
    public WebElement checkout_State;

    @FindBy (xpath = "//input[@id='billing_postcode']")
    public WebElement checkout_ZIP;

    @FindBy (xpath = "//input[@id='billing_phone']")
    public WebElement checkout_Phone;

    @FindBy(xpath = "//input[@id='billing_email']")
    public WebElement checkout_email;

    @FindBy(xpath = "//button[@id='place_order']")
    public WebElement checkout_Place_Order_Button;
}
