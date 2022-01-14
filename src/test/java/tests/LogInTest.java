package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import utils.WaitUtils;


import static org.testng.Assert.assertTrue;

public class LogInTest extends BaseTest {

    @Test
    public void infoInputToLoginPage() {
        LogInPage loginPage = new LogInPage(driver);

        WaitUtils.waitForElementToBeDisplayedBanner(driver, "onetrust-accept-btn-handler", 5);

        loginPage.clickBannerButton();

        loginPage.clickOnAccountButton();

        WebElement loginBlock = driver.findElement(By.xpath("//div[@class='user-hdr' and text()='Prisijungti']"));
        boolean loginBlockisDisplayed = loginBlock.isDisplayed();
        assertTrue(loginBlockisDisplayed, "Login block is not displayed");

        WebElement registrationForm = driver.findElement(By.xpath("//div[@class='user-hdr' and text()='Tapti EUROVAISTINĖ INTERNETE lojalumo klubo nariu']"));
        boolean registrationFormisDisplayed = registrationForm.isDisplayed();
        assertTrue(registrationFormisDisplayed, "Registration form is not displayed");

        loginPage.enterEmailAndPassword();

        loginPage.checkBox1();
        loginPage.checkBox2();
        loginPage.checkBox3();

        loginPage.scrollForRegistrationButton();

        loginPage.hoverRegistrationButton();

        WaitUtils.waitForElementToBeDisplayedRegistration(driver, ".register-login", 3);

        loginPage.clickOnRegistrationButton();


    }
}
