package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

import java.util.List;

public class AlloverCommerce_Compare {

    public AlloverCommerce_Compare() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //After clicking compare icon, this compare popup will show
    @FindBy(css = "div.compare-popup")
    public WebElement productComparePopup;

    //Use the <main> element to click on -> closes the popup
    @FindBy(css = ".compare-popup-overlay")
    public WebElement hideComparePopup;

    @FindBy(css = "div.compare-popup a[href*='compare']")
    public WebElement startCompareButton;

    @FindBy(css = "a.remove_from_compare")
    public WebElement removeFromComparePage;

    @FindBy(css = "h3 > a[href='/product-category/kitchen-2']")
    public WebElement kitchenImagesSection;

    @FindBy(css = "[data-id='37af579c']")
    public WebElement popularDepartmentImagesSection;

    @FindBy(css = "div[data-id='5cf38cb'] img:nth-of-type(1)")
    List<WebElement> hoverKitchenImages;

}
