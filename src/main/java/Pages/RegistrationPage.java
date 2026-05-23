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

public class RegistrationPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Register") WebElement registerOption;
    @FindBy(id = "input-firstname") WebElement firstName;
    @FindBy(id = "input-lastname") WebElement lastName;
    @FindBy(id = "input-email") WebElement email;
    @FindBy(id = "input-telephone") WebElement phoneNo;
    @FindBy(id = "input-password") WebElement password;
    @FindBy(id = "input-confirm") WebElement cnfPassword;
    @FindBy(xpath = "//input[@type='checkbox']") WebElement policyCheckbox;
    @FindBy(xpath = "//input[@type='submit']")  WebElement continueBtn;

    @FindBy(xpath = "//h1[text()='Register Account']") WebElement registrationPage;
    @FindBy(xpath = "//p[contains(text(),'Congratulations')]") WebElement accountSuccessMsg;
    @FindBy(xpath = "//div[contains(text(),'E-Mail Address is already registered!')]") WebElement existingEmailCheck;
    @FindBy(xpath = "//div[contains(text(),'First Name')]") WebElement firstNameReqErrorMsg;
    @FindBy(xpath = "//div[contains(text(),'Last Name')]") WebElement lastNameReqErrorMsg;
    @FindBy(xpath = "//div[contains(text(),'E-Mail')]") WebElement emailReqErrorMsg;
    @FindBy(xpath = "//div[contains(text(),'Telephone')]") WebElement phoneNoReqErrorMsg;
    @FindBy(xpath = "//div[contains(text(),'Password')]") WebElement passwordReqErrorMsg;
    @FindBy(xpath = "//div[contains(text(),'does not match')]") WebElement passwordMismatch;

    public void selectMyAccountOption() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']"))).click();
        System.out.println("Selected My account tab");
    }

    public void clickRegisterOption() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register"))).click();
        System.out.println("Selected Register option");
    }

    public void enterUserName(String fstName, String lstName) {
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fstName);
        System.out.println("Entered firstname");
        lastName.sendKeys(lstName);
        System.out.println("Entered lastname");
    }

    public void enterEmail(String userEmail) {
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(userEmail);
        System.out.println("Entered email");
    }

    public void enterPhoneNo() {
        wait.until(ExpectedConditions.visibilityOf(phoneNo)).sendKeys("9876543216");
        System.out.println("Entered mobile no");
    }

    public void enterPassword(String userPassword) {
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(userPassword);
        System.out.println("Entered password");
    }

    public void enterCnfPassword(String userCnfPassword) {
        wait.until(ExpectedConditions.visibilityOf(cnfPassword)).sendKeys(userCnfPassword);
        System.out.println("Entered confirm password");
    }

    public void clickPolicyCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(policyCheckbox)).click();
        System.out.println("Clicked privacy policy check box");
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
        System.out.println("Clicked continue");
    }

    public void checkRegistrationPage() {
        WebElement page = wait.until(ExpectedConditions.visibilityOf(registrationPage));
        Assert.assertTrue(page.isDisplayed(), "Register page error");
        System.out.println("User Navigated to Registration page");
    }

    public void checkSuccessAccountCreation() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOf(accountSuccessMsg));
        Assert.assertTrue(msg.isDisplayed(), "Registration error");
        System.out.println("Account created successfully");
    }

    public void checkExistingEmailMsg() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOf(existingEmailCheck));
        Assert.assertTrue(msg.isDisplayed(), "No Msg displayed");
        System.out.println("Email Alredy existed message displyed");
    }

    public void checkReqFieldErrorMsg() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(firstNameReqErrorMsg)).isDisplayed());
        System.out.println("Firstname required error message displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(lastNameReqErrorMsg)).isDisplayed());
        System.out.println("Lastname required error message displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(emailReqErrorMsg)).isDisplayed());
        System.out.println("Email required error message displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(phoneNoReqErrorMsg)).isDisplayed());
        System.out.println("Phone no required error message displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(passwordReqErrorMsg)).isDisplayed());
        System.out.println("Password required error message displayed");
    }

    public void checkPasswordMismatchMsg() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOf(passwordMismatch));
        Assert.assertTrue(msg.isDisplayed(), "No error msg displyed");
        System.out.println("Password mismatch error message displayed");
    }
}