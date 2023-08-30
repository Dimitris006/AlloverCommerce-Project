package practice_.tests.US14;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_ProductsManage;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
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

            // Assume that filePath is a variable containing the path of the file to upload

// Construct the AppleScript script
            String script = "set filePath to \"" + path + "\"\n" +
                    "-- Bring the file upload dialog to the front\n" +
                    "tell application \"System Events\"\n" +
                    "    set frontmost of process \"Safari\" to true\n" +
                    "end tell\n" +
                    "-- Wait for the file upload dialog to appear\n" +
                    "delay 1\n" +
                    "-- Interact with the file upload dialog\n" +
                    "tell application \"System Events\"\n" +
                    "    keystroke \"g\" using {command down, shift down}\n" +
                    "    delay 1\n" +
                    "    keystroke filePath\n" +
                    "    delay 1\n" +
                    "    keystroke return\n" +
                    "    delay 1\n" +
                    "    keystroke return\n" +
                    "end tell";

// Execute the AppleScript script using the ProcessBuilder class
            ProcessBuilder processBuilder = new ProcessBuilder("osascript", "-e", script);
            processBuilder.start();



//            Robot robot = new Robot();
//
//// Get the OS name
//            String os = System.getProperty("os.name");
//
//// Determine meta key code based on OS
//            int metaKeyCode;
//            if (os.contains("Mac")) {
//                metaKeyCode = KeyEvent.VK_META;
//            } else {
//                metaKeyCode = KeyEvent.VK_WINDOWS;
//            }
//
//            System.out.println("Begin Robot");
//            robot.delay(4000);
//            robot.keyPress(metaKeyCode);
//            robot.keyPress(KeyEvent.VK_SHIFT);
//            robot.keyPress(KeyEvent.VK_G);
//            robot.delay(3000);
//            robot.keyRelease(KeyEvent.VK_G);
//            robot.keyRelease(KeyEvent.VK_SHIFT);
//            robot.keyRelease(metaKeyCode);
//            robot.delay(3000);
//            robot.keyPress(metaKeyCode);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.delay(3000);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(metaKeyCode);
//            robot.delay(3000);
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        WaitUtils.waitForVisibility(productsManage.mediaAttachment, 3);
//        Assert.assertTrue(productsManage.mediaAttachment.isDisplayed());
    }
}
