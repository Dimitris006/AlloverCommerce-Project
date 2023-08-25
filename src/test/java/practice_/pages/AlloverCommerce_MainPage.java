package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_MainPage {

    public AlloverCommerce_MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Sign Out Link
    @FindBy (xpath = "//span[.='Sign Out']")
    public WebElement signOut_Link;
}
