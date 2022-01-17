package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;

    public By bannerButton = By.id("onetrust-accept-btn-handler");

    public BasePage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void clickBannerButton() {
        driver.findElement(bannerButton).click();
    }
}
