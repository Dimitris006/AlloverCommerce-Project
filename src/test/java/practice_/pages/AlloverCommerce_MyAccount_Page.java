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

    @FindBy(css = ".wcfm_store_logo_icon")
    public WebElement storeManagerLogo;

    @FindBy(xpath = "//a[.='Orders']")
    public WebElement ordersLink;

    @FindBy(xpath = "//a[.='Browse products']")
    public WebElement browseProductLink;

    @FindBy(xpath = "//a[.='Go Shop']")
    public WebElement goShopLink;

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

    @FindBy (xpath = "//*[(text()='Account details changed successfully.')]")
    public WebElement accountDetails_confirmationMessage;

    @FindBy (xpath = "//li[@data-id='account_first_name']")
    public WebElement accountDetails_ErrorFirstName;

    @FindBy (xpath = "//li[@data-id='account_last_name']")
    public WebElement accountDetails_ErrorLastName;
    @FindBy (xpath = "//a[.='Edit Your Shipping Address']")
    public WebElement editVendorShippingAddress ;

    @FindBy (xpath = "//input[@id='password_current']")
    public WebElement accountDetails_currentPassword;

    @FindBy (xpath = "//input[@id='password_1']")
    public WebElement accountDetails_newPassword;

    @FindBy (xpath = "//input[@id='password_2']")
    public WebElement accountDetails_confirmNewPassword;

    //NEW DON'T DELETE METHODS BELOW
    @FindBy(css = "[href='https://allovercommerce.com/store-manager/products/']")
    public WebElement productLink;

    @FindBy(css = "[href='https://allovercommerce.com/store-manager/products-manage/']")
    public WebElement addNewProduct;
    @FindBy(css = "#product_type")
    public WebElement productSelectInput;
    @FindBy(xpath = "//*[@id=\"wcfm_products_manage_form_inventory_head\"]/div")
    public WebElement inventory;
    @FindBy(xpath = "//*[@id=\"wcfm_products_manage_form_shipping_head\"]/div")
    public WebElement shipping;
    @FindBy(xpath = "//*[@id=\"wcfm_products_manage_form_attribute_head\"]/div")
    public WebElement attributes;
     @FindBy(xpath = "//*[@id=\"wcfm_products_manage_form_linked_head\"]")
     public WebElement linked;
    @FindBy(xpath = "//*[@id=\"wcfm_products_manage_form_yoast_head\"]/div")
    public WebElement seo;
    @FindBy(css = "#page_collapsible_content_holder")
    public WebElement piece_type;
    @FindBy(xpath = "//*[@id=\"wcfm_products_manage_form_advanced_head\"]/div")
    public WebElement advanced;
    @FindBy (xpath = "//*[@id=\"weight\"]")
    public WebElement weight_kg;

    @FindBy (xpath = "//*[@id=\"sku\"]")
    public WebElement sku_field;

   @FindBy (xpath = "//*[@id=\"manage_stock\"]")
   public WebElement manage_stock;

   @FindBy (xpath = "//*[@id=\"stock_qty\"] ")
   public WebElement allow_backorders;

    @FindBy (xpath = "//*[@id=\"sold_individually\"] ")
    public WebElement sold_individually;

    @FindBy (xpath = "//*[@id=\"stock_qty\"] ")
    public WebElement stock_qty;

    @FindBy (xpath = "//*[@id=\"length\"] ")
    public WebElement length;

    @FindBy (xpath = "//*[@id=\"width\"]")
    public WebElement width;

    @FindBy (xpath = "//*[@id=\"height\"] ")
    public WebElement height;

    @FindBy (xpath = "//*[@id=\"shipping_class\"] ")
    public WebElement shipping_class;

    @FindBy (xpath = "//*[@id=\"_wcfmmp_processing_time\"] ")
    public WebElement processing_time;

    @FindBy (id= "attributes_is_active_1")
    public WebElement colorcheckbox;

    @FindBy (id = "attributes_is_active_2")
    public WebElement sizecheckbox;


}
