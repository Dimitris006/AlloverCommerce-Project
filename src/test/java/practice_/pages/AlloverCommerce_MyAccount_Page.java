package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_MyAccount_Page {

    public AlloverCommerce_MyAccount_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Web elements on My Account page
    @FindBy(id = "footer")
    public WebElement myAccount;

    @FindBy(xpath = "//a[.='Dashboard']")
    public WebElement dashboardLink;

    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement storeManagerLink;

    @FindBy(xpath = "//a[.='Orders']")
    public WebElement ordersLink;

    @FindBy(xpath = "//a[.='Downloads']")
    public WebElement downloadsLink;

    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement addressesLink;

    @FindBy(xpath = "//a[.='Account details']")
    public WebElement accountDetailslink;

    @FindBy(xpath = "//a[.='Account details']")
    public WebElement wishlistLinks;

    @FindBy(xpath = "//a[.='Support Tickets']")
    public WebElement supportTicketsLink;

    @FindBy(xpath = "//a[.='Followings']")
    public WebElement followingsLink;

    //Sign Out Link
    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutLink;

    @FindBy(xpath = "//*[@class='icon-box-icon icon-addresses']")
    public WebElement addressesLinkIcon;

    @FindBy (xpath = "//p[.='Logout']")
    public WebElement logoutButton;

    @FindBy (xpath = "//input[@autocomplete='given-name']")
    public WebElement accountDetails_firstname;

    @FindBy (xpath = "//input[@autocomplete='family-name']")
    public WebElement accountDetails_lastname;

    @FindBy (xpath = "//input[@id='account_display_name']")
    public WebElement accountDetails_displayName;

    @FindBy (xpath = "//input[@id='account_email']")
    public WebElement accountDetails_email;

    @FindBy (xpath = "//body[@id='tinymce']")
    public WebElement accountDetails_Biography;

    @FindBy (xpath = "//button[@name='save_account_details']")
    public WebElement accountDetails_saveChanges;

    @FindBy (xpath = "//div[@role='alert']")
    public WebElement accountDetails_confirmationMessage;

    @FindBy (xpath = "//li[@data-id='account_first_name']")
    public WebElement accountDetails_ErrorFirstName;

    @FindBy (xpath = "//li[@data-id='account_last_name']")
    public WebElement accountDetails_ErrorLastName;
    @FindBy (xpath = "//a[.='Edit Your Shipping Address']")
    public WebElement editVendorShippingAddress ;






}
