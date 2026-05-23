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

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email") WebElement email;
    @FindBy(id = "input-password") WebElement password;
    @FindBy(xpath = "//input[@type='submit']") WebElement loginBtn;
    @FindBy(xpath = "//h2[text()='My Account']") WebElement accMsgDisplayed;
    @FindBy(xpath = "//h2[contains(text(),'Orders')]") WebElement ordersMsgDisplayed;
    @FindBy(xpath = "//div[contains(text(),'Warning')]") WebElement warningMsg;

    public void selectMyAccountOption() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']"))).click();
        System.out.println("Selected My account tab");
    }

    public void selectLoginOption() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Login")
        )).click();
        System.out.println("Selected login option");
    }

    public void enterEmail(String userEmail) {
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(userEmail);
        System.out.println("Entered email");
    }

    public void enterPassword(String userPass) {
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(userPass);
        System.out.println("Entered password");
    }

    public void clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        System.out.println("Selected login button");
    }

    public void checkSuccessfulLogin() {
        WebElement acc = wait.until(ExpectedConditions.visibilityOf(accMsgDisplayed));
        Assert.assertTrue(acc.isDisplayed(), "Login error");
        System.out.println("My account setting displayed");

        WebElement orders = wait.until(ExpectedConditions.visibilityOf(ordersMsgDisplayed));
        Assert.assertTrue(orders.isDisplayed(), "Login error");
        System.out.println("My orders setting displayed");
    }

    public void checkErrorMsg() {
        WebElement warning = wait.until(ExpectedConditions.visibilityOf(warningMsg));
        Assert.assertTrue(warning.isDisplayed(), "No warning message displayed");
        System.out.println("Getting warning message");
    }
}