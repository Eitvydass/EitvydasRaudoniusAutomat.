package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertTrue;

public class LogInPage {

    public WebDriver driver;


    public By accountButton = By.id("user-block");
    public By loginBlock1 = By.xpath("//div[@class='user-hdr' and text()='Prisijungti']");
    public By registrationForm1 = By.xpath("//div[@class='user-hdr' and text()='Tapti EUROVAISTINĖ INTERNETE lojalumo klubo nariu']");
    public By email = By.id("customer_registration_email");
    public By password = By.id("customer_registration_user_plainPassword_first");
    public By repeatPassword = By.id("customer_registration_user_plainPassword_second");
    public By checkBx1 = By.id("customer_registration_marketing_generalOffers");
    public By checkBx2 = By.id("customer_registration_marketing_personalOffers");
    public By checkBx3 = By.id("customer_registration_marketing_typeEmail");
    public By hoverMove = By.cssSelector(".register-login");
    public By registrationButtonClick = By.cssSelector(".register-login");


    public LogInPage(WebDriver driver) {
        super();
        this.driver = driver;
    }


    public void clickOnAccountButton() {
        driver.findElement(accountButton).click();


    }

    public void enterEmailAndPassword() {
        WebElement registrationForm = driver.findElement(registrationForm1);
        boolean registrationFormisDisplayed = registrationForm.isDisplayed();

        if (registrationFormisDisplayed) {
            driver.findElement(email).sendKeys("test@test.com");
            driver.findElement(password).sendKeys("Testauskas10");
            driver.findElement(repeatPassword).sendKeys("Testauskas10");

        }


    }

    public void checkBox1() {
        WebElement checkBoxInput1 = driver.findElement(checkBx1);
        checkBoxInput1.click();
    }

    public void checkBox2() {
        WebElement checkBoxInput2 = driver.findElement(checkBx2);
        checkBoxInput2.click();
    }

    public void checkBox3() {
        WebElement checkBoxInput3 = driver.findElement(checkBx3);
        checkBoxInput3.click();
    }


    public void scrollForRegistrationButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public void hoverRegistrationButton() {
        Actions hover = new Actions(driver);
        WebElement Elem_to_hover = driver.findElement(hoverMove);
        hover.moveToElement(Elem_to_hover).build().perform();

    }

    public void clickOnRegistrationButton() {
        driver.findElement(registrationButtonClick).click();


    }


    public void registrationFormInput() {
        WebElement registrationForm = driver.findElement(registrationForm1);
        boolean registrationFormIsDisplayed = registrationForm.isDisplayed();
        assertTrue(registrationFormIsDisplayed, "Registration form is not displayed");
    }


    public void loginBlockInput() {
        WebElement loginBlock = driver.findElement(loginBlock1);
        boolean loginBlockisDisplayed = loginBlock.isDisplayed();
        assertTrue(loginBlockisDisplayed, "Login block is not displayed");
    }
}
