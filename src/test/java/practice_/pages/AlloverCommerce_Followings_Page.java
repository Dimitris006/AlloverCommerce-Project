package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_Followings_Page {

    public AlloverCommerce_Followings_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Followings Page Locators
    @FindBy(xpath = "//*[contains(text(), 'You are not following')]")
    public WebElement followingsText;

}
