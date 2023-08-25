package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_AccountDetails_Page {

    public AlloverCommerce_AccountDetails_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Account Details Page Locators
    @FindBy(xpath = "//h4[.='Account Details']")
    public WebElement accountDetailsHeader;
}
