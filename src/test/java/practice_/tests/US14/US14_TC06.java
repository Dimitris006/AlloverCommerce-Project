package practice_.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_ProductsManage;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class US14_TC06 {

    RepeatedSignIn repeatedSignIn;
    AlloverCommerce_ProductsManage productsManage;
    @Test
    public void tc06_checkProductBrands() {
        productsManage = new AlloverCommerce_ProductsManage();
        repeatedSignIn = new RepeatedSignIn();
        repeatedSignIn.repeatedSignIn();

        Driver.getDriver().get("https://allovercommerce.com/store-manager/products-manage/");
        WaitUtils.waitForPageToLoad(15);

        //1. Scroll down to 'Product brands' checklist
        JSUtils.scrollIntoViewJS(productsManage.productBrands);
        WaitUtils.waitFor(2);

        //2. Confirm that the 'Product brands' checklist is displayed
        WebElement productBrandsTitle = Driver.getDriver().findElement(By.xpath(
                        "//p//strong[.='Product brands']"
        ));

        Assert.assertTrue(productBrandsTitle.isDisplayed());
        System.out.println(productBrandsTitle.getText());
    }

    @AfterTest
    public void closeDriver() {
        Driver.closeDriver();
    }
}
