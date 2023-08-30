package practice_.tests.US14;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_ProductsManage;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Ignore
public class US14_TC02 {

    RepeatedSignIn repeatedSignIn;
    AlloverCommerce_ProductsManage productsManage;
    @Test
    public void tc02_addNewProduct() {
        repeatedSignIn = new RepeatedSignIn();
        productsManage = new AlloverCommerce_ProductsManage();

        repeatedSignIn.repeatedSignIn();
        Driver.getDriver().get("https://allovercommerce.com/store-manager/articles-manage/");
        WaitUtils.waitForPageToLoad(15);

        //1. Click on featured image display from the right side
        JSUtils.scrollIntoViewJS(productsManage.featuredImageBox);
        WaitUtils.waitFor(1);
        productsManage.featuredImageBox.click();

        //2. Confirm that media modal shows up
        WaitUtils.waitForVisibility(productsManage.mediaModal, 15);
        Assert.assertTrue(productsManage.mediaModal.isDisplayed());

        //3. Confirm that Upload files tab is active
        Assert.assertTrue(productsManage.uploadButton.isDisplayed());

        //4. Check image exists in Desktop and select product image
        try {
            String path = System.getProperty("user.home") + "/productImage.jpg";
            File file = new File(path);

            boolean fileExists = Files.exists((Paths.get(path)));
            System.out.println("File Path: " + path);
            System.out.println("File exists: " + fileExists);
            Assert.assertTrue(fileExists, "Image file does not exist");

            StringSelection stringSelection = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            productsManage.uploadButton.click();

            WaitUtils.waitFor(2);
            Robot robot = new Robot();

            // Meta key constant
            int META_M = InputEvent.META_DOWN_MASK;

            robot.delay(2000);

            // Open Goto dialog
            robot.keyPress(META_M);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);

            robot.delay(3000);

            robot.keyRelease(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(META_M);

            // Paste path
            robot.delay(3000);
            robot.keyPress(META_M);
            robot.keyPress(KeyEvent.VK_V);

            robot.delay(3000);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(META_M);

            // Hit enter
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        WaitUtils.waitForVisibility(productsManage.mediaAttachment, 3);
//        Assert.assertTrue(productsManage.mediaAttachment.isDisplayed());
    }
}
