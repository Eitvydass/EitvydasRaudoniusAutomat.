package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CategoryPage;
import pages.LogInPage;
import utils.WaitUtils;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class CategoryTest extends BaseTest {


    @Test(dataProvider = "items")
    public void addItemsToCart(String itemName) {
        CategoryPage categoryPage = new CategoryPage(driver);
        BasePage basePage = new BasePage(driver);

        basePage.clickBannerButton();
        categoryPage.textInput();
        categoryPage.submitButton();
        WaitUtils.waitForElementToBeDisplayed(driver, "//*[@id=\"s-f\"]/div[3]/div[1]", 6);
        categoryPage.dropDownMenu();
        categoryPage.textInputGripex();
        categoryPage.checkBox4();
        categoryPage.textResult();
        categoryPage.containWordGripex();
        categoryPage.addToCart(itemName);

    }

    @DataProvider(name = "items")
    public static Object[][] createData() {
        return new Object[][]{
                new Object[]{("Gripex, plėvele dengtos tabletės, N12")},
                new Object[]{("Gripex, plėvele dengtos tabletės, N24")},
        };
    }


}
