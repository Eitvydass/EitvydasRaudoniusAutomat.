package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WaitUtils;

import static org.testng.Assert.assertTrue;
import static utils.WaitUtils.waitForElementToBeClickable;

public class LogInPage {

    public WebDriver driver;

    public By bannerButton = By.id("onetrust-accept-btn-handler");
    public By accountButton = By.id("user-block");
    public By email = By.id("customer_registration_email");
    public By password = By.id("customer_registration_user_plainPassword_first");
    public By repeatPassword= By.id("customer_registration_user_plainPassword_second");
    public By registrationButtonClick = By.cssSelector(".register-login");


    public LogInPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void clickBannerButton() {
        driver.findElement(bannerButton).click();
    }

    public void clickOnAccountButton() {
        driver.findElement(accountButton).click();


    }

    public void enterEmailAndPassword() {
        WebElement registrationForm = driver.findElement(By.xpath("//div[@class='user-hdr' and text()='Tapti EUROVAISTINĖ INTERNETE lojalumo klubo nariu']"));
        boolean registrationFormisDisplayed = registrationForm.isDisplayed();

        if (registrationFormisDisplayed) {
            driver.findElement(email).sendKeys("test@test.com");
            driver.findElement(password).sendKeys("Testauskas10");
            driver.findElement(repeatPassword).sendKeys("Testauskas10");

        }


    }

    public void checkBox1() {
        WebElement checkBoxInput1 = driver.findElement(By.id("customer_registration_marketing_generalOffers"));
        checkBoxInput1.click();
    }

    public void checkBox2() {
        WebElement checkBoxInput2 = driver.findElement(By.id("customer_registration_marketing_personalOffers"));
        checkBoxInput2.click();
    }

    public void checkBox3() {
        WebElement checkBoxInput3 = driver.findElement(By.id("customer_registration_marketing_typeEmail"));
        checkBoxInput3.click();
    }


    public void scrollForRegistrationButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public void hoverRegistrationButton() {
        Actions hover = new Actions(driver);
        WebElement Elem_to_hover = driver.findElement(By.cssSelector(".register-login"));
        hover.moveToElement(Elem_to_hover);
        hover.build();
        hover.perform();
    }

    public void clickOnRegistrationButton() {
        driver.findElement(registrationButtonClick).click();


    }


}