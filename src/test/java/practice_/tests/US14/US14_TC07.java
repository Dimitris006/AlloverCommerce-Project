package practice_.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_ProductsManage;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.LoggerUtils;
import practice_.utilities.WaitUtils;

import java.util.Random;

public class US14_TC07 {

    RepeatedSignIn repeatedSignIn;
    AlloverCommerce_ProductsManage productsManage;

    @Test
    public void tc07_addProductBrands() {
        productsManage = new AlloverCommerce_ProductsManage();
        repeatedSignIn = new RepeatedSignIn();
        repeatedSignIn.repeatedSignIn();

        Driver.getDriver().get("https://allovercommerce.com/store-manager/products-manage/");

        //1. Click on 'Add Product brands'
        WaitUtils.waitForPageToLoad(15);
        JSUtils.scrollIntoViewJS(productsManage.addNewProduct_Trigger);
        WaitUtils.waitFor(2);
        productsManage.addNewProduct_Trigger.click();

        //2. Click on input 'Product brands Name' and type in text
        String brand = "Test Brand" + new Random().nextInt(100000);
        productsManage.productBrandNameTextField.sendKeys(brand);

        //3. Click on the 'ADD' button
        productsManage.addBrand.click();

        LoggerUtils.warn(
                "When a new product brand is added it goes to the top of the list" +
                        "The name for the first element does not match with the rest"
        );

//        4. Confirm that the category name added from previous step
//         is now visible inside the 'Product brands' checklist
        WaitUtils.waitFor(2);
        JSUtils.scrollIntoViewJS(productsManage.productBrands);
        WaitUtils.waitFor(2);
        findCustomBrand(brand);
    }

    public void findCustomBrand(String brand) {

        WebElement customBrand = Driver.getDriver().findElement(By.xpath(
                "//ul[@id='product_brand']//li[contains(.,'"+brand+"')]"
        ));

        JSUtils.scrollIntoViewJS(customBrand);
        WaitUtils.waitFor(2);
        System.out.println("method argument: " + brand + "\n" + "custom category: " + customBrand);

        String trimmedBrandWord = customBrand.getText().trim();
        WaitUtils.waitForVisibility(customBrand, 15);
        Assert.assertEquals(trimmedBrandWord, brand);
    }

    @AfterClass
    public void closeDriver() {
        Driver.closeDriver();
    }
}
