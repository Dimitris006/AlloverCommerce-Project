package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

import java.awt.*;

public class AlloverCommerce_Coupons_Page {

    public AlloverCommerce_Coupons_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Coupon Page Locators
    @FindBy(xpath = "//*[contains(text(),'Coupons')]")
    public WebElement couponsLink;

    @FindBy(id = "add_new_coupon_dashboard")
    public WebElement addCouponButton;

    @FindBy(id = "title")
    public WebElement codeTextField;

    @FindBy(id = "description")
    public WebElement descriptionTextField;

    @FindBy(id = "discount_type")
    public WebElement discountTypeDropdown;

    @FindBy(id = "coupon_amount")
    public WebElement couponAmountTextField;

    @FindBy(id = "expiry_date")
    public WebElement expiryDateField;

    @FindBy(id = "free_shipping")
    public WebElement freeShippingCheckbox;

    @FindBy(id = "show_on_store")
    public WebElement showOnStoreCheckbox;

    @FindBy(id = "wcfm_coupon_manager_submit_button")
    public WebElement couponSubmitButton;

    @FindBy(xpath = "//a[@class='wcfm_dashboard_item_title']")
    public WebElement titleOfCreatedCouponLink;

    @FindBy(xpath = "//*[contains(text(),'Please insert atleast Coupon')]")
    public WebElement missingCouponTitleErrorMessage;

    @FindBy(xpath = "(//tbody)[1]/tr/td[1]")
    public WebElement listOfCouponCodes;

    @FindBy(xpath = "//option[.='Percentage discount']")
    public WebElement percentageDisountDropDown;

    @FindBy(xpath = "//*[.='Fixed Product Discount']")
    public WebElement fixedProductDiscountDropDown;

}
