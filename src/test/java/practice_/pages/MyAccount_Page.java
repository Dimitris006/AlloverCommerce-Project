package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

import java.nio.file.WatchEvent;

public class MyAccount_Page {
    public MyAccount_Page() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(linkText = "https://allovercommerce.com/my-account-2/customer-logout/?_wpnonce=8af2174925")
    public WebElement logOut_Button;
}
