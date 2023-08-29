package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_Wishlist_Page {
    public AlloverCommerce_Wishlist_Page() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//h2[.='Wishlist']")
    public WebElement wishlistHeader;

    @FindBy(xpath = "//li[.='Wishlist']")
    public WebElement wishlistHeaderSmall;

    @FindBy(xpath = "//div[@class='product-details']//a[.='Automatic Crusher']")
    public WebElement homepage_Automatic_Crusher_Item;

    @FindBy(xpath = "//a[@data-product-id='13229']")
    public WebElement homepage_Add_Wishlist_Button;

    @FindBy(linkText = "https://allovercommerce.com/wishlist/view/DECHJJ8FBK7S/")
    public WebElement homepage_Wishlist_Button_After_Clicked;

    @FindBy (xpath = "//a[.='Automatic Crusher']")
    public WebElement wishlist_Page_Automatic_Crusher_Item;

    @FindBy(xpath = "//button[@data-product='13229']")
    public WebElement wishlist_Page_Quick_View_Button;

    @FindBy(xpath = "//*[contains(text(), 'MS46891362')]")
    public WebElement wishlist_Page_Automatic_Crusher_Properties;

    @FindBy(xpath = "//button[@class='mfp-close']")
    public WebElement wishlist_Page_Close_Tab_Button;

    @FindBy(xpath = "//a[@data-product_id='13229']")
    public WebElement wishlist_Page_Add_To_Cart;

    @FindBy(xpath = "//span[@class='cart-name']")
    public WebElement wishlist_Page_Cart_Button;

    @FindBy(xpath = "//a[.='Checkout'] ")
    public WebElement wishlist_Page_Checkout_Button;

    @FindBy(xpath = "//*[@class='w-icon-heart']")
    public WebElement wishList_Button;

    @FindBy(xpath = "//tbody")
    public WebElement verifyAddedProductToWishList;

}
