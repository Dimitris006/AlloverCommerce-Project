package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_MyAccountPage {

    public AlloverCommerce_MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Sign Out Link
    @FindBy (xpath = "//*[@class='icon-box-icon icon-addresses']")
    public WebElement addresses;
}
