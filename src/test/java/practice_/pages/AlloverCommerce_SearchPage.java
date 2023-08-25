package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_SearchPage {


    public AlloverCommerce_SearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //product selection
   @FindBy(xpath = "//a[.='HiPhone'][1]")
   public  WebElement lovely_Iphone;

    @FindBy(xpath = "//*[@id=\"product-20954\"]/div[2]/div/form/div/div/div/div[2]/div/button[2]")
    public WebElement QuantityPlus;


      @FindBy(xpath = "//*[@id=\"product-20954\"]/div[2]/div/form/div/div/div/button")
       public WebElement ADDtoCART;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/a/i")
    public WebElement CARTicon;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/div[2]/div/p[2]/a[2]")
    public WebElement CHECKOUT;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/div[2]/div/p[2]/a[1]")
    public WebElement VIEW_CART;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[2]/div[1]/form/table/tbody/tr[1]/td[4]/div/div/button[1]")
    public WebElement QuantityMinus;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[2]/div[1]/form/table/tbody/tr[2]/td/div[1]/button[2]")
    public WebElement UPDATE_CART;
    //*[@id="main"]/div/div/div/div/div/div[2]/div[2]/div/div/div/div/a
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[2]/div[2]/div/div/div/div/a")
      public WebElement PROCEED_TO_CHECKOUT_button;
//
//    //SIGN UP
//    @FindBy(xpath = "//div[@id='customer_login']//a[.='Sign Up']")
//    public WebElement signUp_Tab;
//
//    @FindBy(xpath = "//div[@id='customer_login']//input[@id='reg_username']")
//    public WebElement signUp_Username;
//
//    @FindBy(xpath = "//div[@id='customer_login']//input[@id='reg_email']")
//    public WebElement signUp_Email;
//
//    @FindBy(xpath = "//div[@id='customer_login']//input[@id='reg_password']")
//    public WebElement signUp_Password;
//
//    @FindBy(xpath = "//div[@id='customer_login']//a[.='Signup as a vendor?']")
//    public WebElement signUp_AsVendorLink;
//
//    @FindBy(xpath = "//div[@id='customer_login']//input[@id='register-policy']")
//    public WebElement signUp_PrivacyPolicyCheckbox;
//
//    @FindBy(xpath = "//div[@id='customer_login']//button[@value='Sign Up']")
//    public WebElement signUp_Button;
//
//    @FindBy(xpath = "//div[@id='customer_login']//a[.='Become a Vendor']")
//    public WebElement signUp_BecomeVendorLink;
//
//   @FindBy(name = "s")
//    public WebElement searchBox;
}
