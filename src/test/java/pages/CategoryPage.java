package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static utils.WaitUtils.waitForElementToBeClickable;

public class CategoryPage {

    public WebDriver driver;

    public By textInputMedicine = By.cssSelector(".tt-input");
    public By submitButtonInput = By.cssSelector("button[type='submit']");
    public By dropDown = By.xpath("//*[@id=\"s-f\"]/div[3]/div[1]");
    public By textInputMedicine1 = By.xpath("/html/body/div[4]/div/div[1]/div[3]/form/div/div[3]/div[2]/div[1]/input");
    public By checkBx4 = By.xpath("//*[@id=\"facet-brand\"]/div[3]/div[85]/label/input");
    public By textResult1 = By.xpath("//div[contains(@class,'content-full')]/h1");
    public By containWord = By.xpath("/html/body/div[4]/div/div[2]/div[2]");
    public By itemsList = By.cssSelector(".product-list clearfix");
    public By itemInList = By.cssSelector(".product-card--title");
    public By addToCartBt = By.cssSelector(".btn btn-green");


    public CategoryPage(WebDriver driver) {
        super();
        this.driver = driver;
    }


    public void textInput() {
        driver.findElement(textInputMedicine).sendKeys("nereceptiniai vaistai");
    }

    public void submitButton() {
        driver.findElement(submitButtonInput).click();
    }


    public void dropDownMenu() {
        WebElement itemName = driver.findElement(dropDown);
        itemName.click();
    }

    public void textInputGripex() {
        driver.findElement(textInputMedicine1).sendKeys("GRIPEX");
    }

    public void checkBox4() {
        driver.findElement(checkBx4).click();
    }

    public void textResult() {
        String actualString = driver.findElement(textResult1).getText();
        assertTrue(actualString.contains("Paieškos rezultatai ieškant \"nereceptiniai+vaistai\""));
    }

    public void containWordGripex() {
        String actualString = driver.findElement(containWord).getText();
        assertTrue(actualString.contains("Gripex"));
    }

    public void addToCart(String itemName) {
        List<WebElement> items = driver.findElements(itemsList);
        for (WebElement item : items) {
            WebElement itemItem = item.findElement(itemInList);
            if (!itemName.equals(itemItem.getText())) {
                continue;
            }
            Assert.assertEquals(itemItem.getText(), itemName);
            WebElement addToCartButton = item.findElement(addToCartBt);
            addToCartButton.click();
            return;
        }
    }


}
