package practice_.tests.US05;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.tests.UserSignUpCredentials_ByFaker;
import practice_.utilities.BrowserUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;

public class US05_TC04 {

    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;
   @Test(dependsOnMethods = "practice_.tests.UserSignUpCredentials_ByFaker.SignUp_ByFaker", dataProvider = "customerData2", dataProviderClass = UserSignUpCredentials_ByFaker.class)
    public void TC02(String username,String password, String email){

        Faker faker = new Faker();
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();
        Driver.getDriver().navigate().to(ConfigReader.getProperty("allovercommerce_url"));
        alloverCommerceHomePage.signIn_Link.click();
        alloverCommerceHomePage.signIn_Username.sendKeys(username);
        alloverCommerceHomePage.signIn_Password.sendKeys(password);
        alloverCommerceHomePage.signIn_Button.click();
        JSUtils.clickWithTimeoutByJS(alloverCommerceHomePage.myAccountLink);
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.accountDetailslink);
        String name = faker.name().firstName();
        alloverCommerceMyAccountPage.accountDetails_firstname.sendKeys(name);
        String lastName= faker.name().lastName();
        alloverCommerceMyAccountPage.accountDetails_lastname.sendKeys(lastName);
        BrowserUtils.switchIframeByIndex(0);
        alloverCommerceMyAccountPage.accountDetails_Biography.sendKeys(faker.lorem().paragraph());
        Driver.getDriver().switchTo().defaultContent();
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.accountDetails_saveChanges);
        JSUtils.scrollIntoViewJS(alloverCommerceMyAccountPage.accountDetails_confirmationMessage);
        Assert.assertTrue(alloverCommerceMyAccountPage.accountDetails_confirmationMessage.isDisplayed());
        String actualValue = alloverCommerceMyAccountPage.accountDetails_firstname.getAttribute("value");
        Assert.assertEquals(actualValue,name);

        Driver.closeDriver();
    }
}
