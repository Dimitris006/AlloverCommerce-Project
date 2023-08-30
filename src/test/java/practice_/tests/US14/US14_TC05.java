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

public class US14_TC05 {

    RepeatedSignIn repeatedSignIn;
    AlloverCommerce_ProductsManage productsManage;
    @Test
    public void tc05_addNewCategory() {
        productsManage = new AlloverCommerce_ProductsManage();
        repeatedSignIn = new RepeatedSignIn();
        repeatedSignIn.repeatedSignIn();
        Driver.getDriver().get("https://allovercommerce.com/store-manager/products-manage/");

        //1. Click on 'Add new category'
        JSUtils.scrollIntoViewJS(productsManage.createCategory);
        WaitUtils.waitFor(2);
        productsManage.createCategory.click();
        WaitUtils.waitForVisibility(productsManage.categoryNameField, 15);
        Assert.assertTrue(productsManage.categoryNameField.isDisplayed());

        //2. Click on input 'Category Name' and type in text
        String category = "Test Category333333";
        productsManage.categoryNameField.sendKeys(category);

        //3. Click on the 'ADD' button
        productsManage.addCategory.click();

        //4. Confirm that the category name added from previous step is
        // now visible inside the 'Categories' checklist
        WaitUtils.waitFor(2);
        findCustomCategory(category);
    }

    public void findCustomCategory(String category) {

        WebElement customCategory = Driver.getDriver().findElement(By.xpath(
                "//ul[@id='product_cats_checklist']//li//span[.='"+category+"']"
        ));

        JSUtils.scrollIntoViewJS(customCategory);
        WaitUtils.waitFor(2);
        System.out.println("method argument: " + category + "\n" + "custom category: " + customCategory);

        WaitUtils.waitForVisibility(customCategory, 15);
        Assert.assertEquals(customCategory.getText(), category);
    }

    @AfterTest
    public void closeDriver() {
        Driver.closeDriver();
    }
}
