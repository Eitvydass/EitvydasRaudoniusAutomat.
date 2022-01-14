package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.LogInPage;
import utils.WaitUtils;

import static org.testng.Assert.assertTrue;

public class CategoryTest extends BaseTest {

    @DataProvider(name = "items")
    public static Object[][] createData() {
        return new Object[][]{
                new Object[]{("Gripex, plėvele dengtos tabletės, N12")},
                new Object[]{("Gripex, plėvele dengtos tabletės, N24")},
        };
    }


    @Test
    public void addItemsToCart() {
        CategoryPage categoryPage = new CategoryPage(driver);

        WaitUtils.waitForElementToBeDisplayedBanner(driver, "onetrust-accept-btn-handler", 5);

        categoryPage.clickBannerButton();

        categoryPage.hoverSearchField();

        driver.findElement(By.cssSelector(".tt-input")).sendKeys("nereceptiniai vaistai");

        WaitUtils.waitForElementToBeDisplayedSearch(driver, ".tt-input", 5);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement searchText = driver.findElement(By.xpath("//div[contains(@class,'content-full')]/h1"));
        boolean searchTextIsDisplayed = searchText.isDisplayed();
        assertTrue(searchTextIsDisplayed, "Search result 'nereceptiniai vaistai' is not displayed");


        //WebElement scope = driver.findElement(By.id("s-f"));
        //WebElement scopeButton = scope.findElement(By.cssSelector("//button[contains(text(),'Prekės ženklas:')]"));
        //scopeButton.click();


        //categoryPage.checkBox4();


    }


}
