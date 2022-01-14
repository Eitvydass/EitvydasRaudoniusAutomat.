package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.WaitUtils.waitForElementToBeClickable;

public class CategoryPage {

    public WebDriver driver;

    public By bannerButton = By.id("onetrust-accept-btn-handler");


    public CategoryPage(WebDriver driver) {
        super();
        this.driver = driver;
    }


    public void clickBannerButton() {
        driver.findElement(bannerButton).click();
    }

    public void hoverSearchField() {
        Actions hover = new Actions(driver);
        WebElement Elem_to_hover = driver.findElement(By.cssSelector(".header--search"));
        hover.moveToElement(Elem_to_hover);
        hover.perform();
    }

    public void checkBox4() {
        WebElement checkBoxInput4 = driver.findElement(By.cssSelector(".filter-input"));
        checkBoxInput4.click();
    }
}
