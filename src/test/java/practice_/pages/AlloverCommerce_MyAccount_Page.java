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

    @FindBy(xpath = "//a[.='Wishlist']")
    public WebElement wishlistLink;

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
}
