package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LogInPage;
import utils.WaitUtils;


import static org.testng.Assert.assertTrue;

public class LogInTest extends BaseTest {

    @Test
    public void infoInputToLoginPage() {
        LogInPage loginPage = new LogInPage(driver);
        BasePage basePage = new BasePage(driver);

        WaitUtils.waitForElementToBeDisplayedBanner(driver, "onetrust-accept-btn-handler", 5);
        basePage.clickBannerButton();
        loginPage.clickOnAccountButton();
        loginPage.loginBlockInput();
        loginPage.registrationFormInput();
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
