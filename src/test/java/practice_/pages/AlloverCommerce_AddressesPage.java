package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_AddressesPage {

    public AlloverCommerce_AddressesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Sign Out Link
    @FindBy (xpath = "//*[@href='https://allovercommerce.com/my-account-2/edit-address/shipping/']")
    public WebElement shippingAddressAdd;
}
