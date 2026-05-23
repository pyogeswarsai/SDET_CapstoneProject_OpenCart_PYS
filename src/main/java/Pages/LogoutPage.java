package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // Keep these for stable pages — logout/continue pages don't reload mid-scenario
    @FindBy(xpath = "//h1[text() = 'Account Logout']") WebElement checkAccountLogout;
    @FindBy(linkText = "Continue")                     WebElement continueBtn;
    @FindBy(linkText = "Qafox.com")                    WebElement homepageDisplayed;

    public void clickAccountOption() {
        // Re-locate fresh every time — stale after any page navigation
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(text(),'Account')]")
        )).click();
    }

    public void clickLogout() {
        // Re-locate fresh — dropdown only appears after clickAccountOption
        wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Logout")
        )).click();
    }

    public void CheckAccountLoggedout() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOf(checkAccountLogout));
        Assert.assertTrue(msg.isDisplayed(), "Logout error");
        System.out.println("User Logged out successfully");
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public void checkHomepageDisplayed() {
        WebElement homepage = wait.until(ExpectedConditions.visibilityOf(homepageDisplayed));
        Assert.assertTrue(homepage.isDisplayed(), "Homepage not loaded");
        System.out.println("User successfully navigated to homepage after logout");
    }
}