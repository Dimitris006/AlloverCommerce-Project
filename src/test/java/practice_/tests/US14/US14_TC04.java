package practice_.tests.US14;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_ProductsManage;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class US14_TC04 {
    RepeatedSignIn repeatedSignIn;
    AlloverCommerce_ProductsManage productsManage;

    @Test
    public void tc04_confirmFashionCategory() {
        repeatedSignIn = new RepeatedSignIn();
        productsManage = new AlloverCommerce_ProductsManage();
        repeatedSignIn.repeatedSignIn();

        Driver.getDriver().get("https://allovercommerce.com/store-manager/products-manage/");
        WaitUtils.waitForPageToLoad(15);

        JSUtils.scrollIntoViewJS(productsManage.categoriesCheckList);
        JSUtils.scrollIntoViewJS(productsManage.fashionCategoryInChecklist);

        WaitUtils.waitFor(2);
        Assert.assertTrue(
                productsManage.fashionCategoryInChecklist.isDisplayed()
        );

    }

    @AfterTest
    public void closeDriver() {
        Driver.closeDriver();
    }
}
