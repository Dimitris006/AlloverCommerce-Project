package practice_.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_ProductsManage;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class US14_TC03 {

    RepeatedSignIn repeatedSignIn;
    AlloverCommerce_ProductsManage productsManage;
    @Test
    public void tc03_productInformation() {
        repeatedSignIn = new RepeatedSignIn();
        productsManage = new AlloverCommerce_ProductsManage();

        repeatedSignIn.repeatedSignIn();

        Driver.getDriver().get("https://allovercommerce.com/store-manager/products-manage/");

        //1. Click on 'Product Title' and input some text
        productsManage.productTitleInput.sendKeys("Perfume");

        //2. Scroll down to the 'Short Description' Iframe
        JSUtils.scrollIntoViewJS(productsManage.shortDescription_IFrame);

        //3. Type a short description inside the 'Short Description' Iframe
        Driver.getDriver().switchTo().frame(productsManage.shortDescription_IFrame);
        String short_IframeHandle = Driver.getDriver().getWindowHandle();
        System.out.println(short_IframeHandle);

        WebElement iframeP = Driver.getDriver().findElement(By.cssSelector(
                "#tinymce p"
        ));

        WaitUtils.waitFor(3);

        iframeP.sendKeys("What is Lorem Ipsum?");
        WaitUtils.waitFor(3);
        System.out.println(iframeP.getText());

        Driver.getDriver().switchTo().parentFrame();

        //Type some description inside the 'Description' Iframe
        JSUtils.scrollIntoViewJS(productsManage.longDescription_IFrame);
        WaitUtils.waitFor(1);
        Driver.getDriver().switchTo().frame(productsManage.longDescription_IFrame);
        iframeP = Driver.getDriver().findElement(By.cssSelector(
                "#tinymce p"
        ));

        iframeP.sendKeys(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
        );

        WaitUtils.waitFor(2);
    }


    @AfterTest
    public void closeDriver() {
        Driver.closeDriver();
    }
}
