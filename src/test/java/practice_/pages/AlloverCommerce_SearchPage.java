package practice_.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.Driver;

public class AlloverCommerce_SearchPage {


    public AlloverCommerce_SearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //product selection
   @FindBy(xpath = "//a[.='HiPhone'][1]")
   public  WebElement lovely_Iphone;

    @FindBy(xpath = "//*[@id=\"product-20954\"]/div[2]/div/form/div/div/div/div[2]/div/button[2]")
    public WebElement QuantityPlus;


      @FindBy(xpath = "//*[@id=\"product-20954\"]/div[2]/div/form/div/div/div/button")
       public WebElement ADDtoCART;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/a/i")
    public WebElement CARTicon;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/div[2]/div/p[2]/a[2]")
    public WebElement CHECKOUT;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/div[2]/div/p[2]/a[1]")
    public WebElement VIEW_CART;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[2]/div[1]/form/table/tbody/tr[1]/td[4]/div/div/button[1]")
    public WebElement QuantityMinus;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[2]/div[1]/form/table/tbody/tr[2]/td/div[1]/button[2]")
    public WebElement UPDATE_CART;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[2]/div[2]/div/div/div/div/a")
      public WebElement PROCEED_TO_CHECKOUT_button;



}
