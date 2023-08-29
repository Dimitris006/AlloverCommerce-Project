package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_ProductsManage {

    public AlloverCommerce_ProductsManage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //The selection box for products
    @FindBy(css = "#product_type")
    public WebElement productSelectInput;

    @FindBy(css = "#featured_img_display")
    public WebElement featuredImageBox;

    //Media Modal parts
    @FindBy(css = ".media-modal-content")
    public WebElement mediaModal;

    @FindBy(css = "#menu-item-upload")
    public WebElement uploadFilesTab;

    @FindBy(css = ".upload-ui button")
    public WebElement uploadButton;

    @FindBy(css = "#menu-item-browse")
    public WebElement mediaLibraryTab;

    @FindBy(css = ".attachments li")
    public WebElement mediaAttachment;


}
