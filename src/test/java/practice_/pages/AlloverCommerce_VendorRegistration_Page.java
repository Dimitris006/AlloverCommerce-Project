package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_VendorRegistration_Page {

    public AlloverCommerce_VendorRegistration_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    //VENDOR REGISTRATION
    @FindBy(id="user_email")
    public WebElement vendorRegister_Email;

    @FindBy(name = "wcfm_email_verified_input")
    public WebElement verificationCode;

    @FindBy(name = "wcfm_email_verified_button")
    public WebElement resendCodeButton;

    @FindBy(id = "passoword")
    public WebElement vendorPassword;

    @FindBy(id = "confirm_pwd")
    public WebElement vendorConfirmPassword;

    //password strength
    @FindBy(id = "password_strength")
    public WebElement vendorPasswordStrength;

    @FindBy(name = "save-data")
    public WebElement registerButton;

    @FindBy(xpath = "//a[.='Not right now']")
    public WebElement notRightNowButton;

    @FindBy(xpath = "//a[.='Let's go!'])")
    public WebElement letsGoButton;

    @FindBy(linkText = "My Account")
    public WebElement myAccountLink;

    @FindBy(xpath = "//div[@id=\"wcfm_membership_registration_form_expander\"]")
    public WebElement verificationCodeMessage;

    @FindBy(xpath = "//*[.='Email: This field is required.']")
    public WebElement emailRequireMessage;

    @FindBy(xpath = "//*[@id=\"wcfm_membership_registration_form\"]/div[3]/span")
    public WebElement applyAsVendorMessage;

    @FindBy(xpath ="//*[@id=\"wcfm_membership_registration_form_expander\"]/div[2]")
    public WebElement invalidVerificationCodeMessage;

    @FindBy(xpath = "//*[@id=\"wcfm_membership_registration_form_expander\"]/div[2]")
    public WebElement fieldRequired;

    //BreadCrumb
    @FindBy(css=".breadcrumb li:nth-child(3)")
    public WebElement breadCrumb;
}