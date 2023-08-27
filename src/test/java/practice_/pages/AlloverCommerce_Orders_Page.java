package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_Orders_Page {

    public AlloverCommerce_Orders_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Orders Page Locators
    @FindBy(xpath = "//h4[.='Orders']")
    public WebElement ordersHeader;

    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement verifyOrderMessageIsSeen;
}
