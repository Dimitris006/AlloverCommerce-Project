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

    @FindBy(css = "#pro_title")
    public WebElement productTitleInput;

    @FindBy(css = "#excerpt_ifr")
    public WebElement shortDescription_IFrame;

    @FindBy(css = "#description_ifr")
    public WebElement longDescription_IFrame;

    @FindBy(css = "#product_cats_checklist")
    public WebElement categoriesCheckList;

    @FindBy(css = "#product_cats_checklist [data-item=\"344\"] > span:nth-of-type(2)")
    public WebElement fashionCategoryInChecklist;

    @FindBy(xpath = "//div[p='+Add new category']//p")
    public WebElement createCategory;

    @FindBy(css = "#wcfm_new_cat")
    public WebElement categoryNameField;

    @FindBy(xpath = "//div[p='+Add new category']//button[.='Add']")
    public WebElement addCategory;

    @FindBy(id = "product_brand")
    public WebElement productBrands;

    @FindBy(xpath = "//div[p='+Add new Product brands']//p")
    public WebElement addNewProduct_Trigger;

    @FindBy(css = "#wcfm_new_product_brand")
    public WebElement productBrandNameTextField;

    @FindBy(xpath = "//div[p='+Add new Product brands']//button[.='Add']")
    public WebElement addBrand;

}
