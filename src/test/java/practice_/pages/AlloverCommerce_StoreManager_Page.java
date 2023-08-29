package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_StoreManager_Page {

    public AlloverCommerce_StoreManager_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Store Manager Page Locators
    @FindBy(xpath = "//h2[.='Store Manager']")
    public WebElement storeManagerHeader;

    //Products menu item
    @FindBy(css = "a[href='https://allovercommerce.com/store-manager/products/']")
    public WebElement productsMenuItem;

    //Add New link for products
    @FindBy(css = ".wcfm_sub_menu_items [href='https://allovercommerce.com/store-manager/products-manage/']")
    public WebElement addSubMenuItem;

}
