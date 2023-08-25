package practice_.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import practice_.utilities.ActionsUtils;
import practice_.utilities.Driver;

import java.util.List;

public class AlloverCommerce_Compare {

    public AlloverCommerce_Compare() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
