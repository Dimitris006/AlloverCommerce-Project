package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_Downloads_Page {

    public AlloverCommerce_Downloads_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Downloads Page Locators
    @FindBy(xpath = "//h4[.='Downloads']")
    public WebElement downloadsHeader;
}
