package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPage {
	
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text() = 'My Account']") WebElement myAccountOption;
	@FindBy(linkText = "Register") WebElement registerOption;
	@FindBy(id = "input-firstname") WebElement firstName;
	@FindBy(id = "input-lastname") WebElement lastName;
	@FindBy(id = "input-email") WebElement email;
	@FindBy(id = "input-telephone") WebElement phoneNo;
	@FindBy(id = "input-password") WebElement password;
	@FindBy(id = "input-confirm") WebElement cnfPassword;
	@FindBy(xpath = "//input[@type = 'checkbox']") WebElement policyCheckbox;
	@FindBy(xpath = "//input[@type = 'submit']") WebElement continueBtn;
	
	@FindBy(xpath = "//h1[text() = 'Register Account']") WebElement registrationPage;
	@FindBy(xpath = "//p[contains(text(),'Congratulations')]") WebElement AccountSuccessMsg;
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address is already registered!')]") WebElement existingEmailCheck;
	
	@FindBy(xpath = "//div[contains(text(),'First Name')]") WebElement firstNameReqErrorMsg;
	@FindBy(xpath = "//div[contains(text(),'Last Name')]") WebElement lastNameReqErrorMsg;
	@FindBy(xpath = "//div[contains(text(),'E-Mail')]") WebElement emailReqErrorMsg;
	@FindBy(xpath = "//div[contains(text(),'Telephone')]") WebElement phoneNoReqErrorMsg;
	@FindBy(xpath = "//div[contains(text(),'Password')]") WebElement passwordReqErrorMsg;
	
	@FindBy(xpath = "//div[contains(text(),'does not match')]") WebElement passwordMismatch;
	
	public void selectMyAccountOption() {
		myAccountOption.click();
		System.out.println("Selected My account tab");
	}
	public void clickRegisterOption() {
		registerOption.click();
		System.out.println("Selected Register option");
	}
	public void enterUserName(String fstName, String lstName) {
		firstName.sendKeys(fstName);
		System.out.println("Entered firstname");
		lastName.sendKeys(lstName);
		System.out.println("Entered lastname");
	}
	public void enterEmail(String userEmail) {
		email.sendKeys(userEmail);
		System.out.println("Entered email");
	}
	public void enterPhoneNo() {
		phoneNo.sendKeys("9876543216");
		System.out.println("Entered mobile no");
	}
	public void enterPassword(String userPassword) {
		password.sendKeys(userPassword);
		System.out.println("Entered password");
	}
	public void enterCnfPassword(String userCnfPassword) {
		cnfPassword.sendKeys(userCnfPassword);
		System.out.println("Entered confirm password");
	}
	public void clickPolicyCheckbox() {
		policyCheckbox.click();
		System.out.println("Clicked privacy policy check box");
	}
	public void clickContinue() {
		continueBtn.click();
		System.out.println("Clicked continue");
	}
	public void checkRegistrationPage() {
		boolean isRegisterPageDisplayed = registrationPage.isDisplayed();
		Assert.assertTrue(isRegisterPageDisplayed, "Register page error");
		if(isRegisterPageDisplayed) {
			System.out.println("User Navigated to Registration page");
		}
	}
	public void checkSuccessAccountCreation() {
		boolean isCreatedDisplayed = AccountSuccessMsg.isDisplayed();
		Assert.assertTrue(isCreatedDisplayed, "Registration error");
		if(isCreatedDisplayed) 
			System.out.println("Account created successfully");
	}
	public void checkExistingEmailMsg() {
		boolean isExistingMsgDisplayed = existingEmailCheck.isDisplayed();
		Assert.assertTrue(isExistingMsgDisplayed, "No Msg displayed");
		if(isExistingMsgDisplayed) {
			System.out.println("Email Alredy existed message displyed");
		}
	}
	public void checkReqFieldErrorMsg() {
		boolean isFirstNameReqMsgDisplayed = firstNameReqErrorMsg.isDisplayed();
		Assert.assertTrue(isFirstNameReqMsgDisplayed, "No error message displayed");
		if(isFirstNameReqMsgDisplayed)
			System.out.println("Firstname required error message displayed");
		boolean isLastNameReqMsgDisplayed = lastNameReqErrorMsg.isDisplayed();
		Assert.assertTrue(isLastNameReqMsgDisplayed, "No error message displayed");
		if(isLastNameReqMsgDisplayed)
			System.out.println("Lastname required error message displayed");
		boolean isEmailNameReqMsgDisplayed = emailReqErrorMsg.isDisplayed();
		Assert.assertTrue(isEmailNameReqMsgDisplayed, "No error message displayed");
		if(isEmailNameReqMsgDisplayed)
			System.out.println("Email required error message displayed");
		boolean isphoneNoNameReqMsgDisplayed = phoneNoReqErrorMsg.isDisplayed();
		Assert.assertTrue(isphoneNoNameReqMsgDisplayed, "No error message displayed");
		if(isphoneNoNameReqMsgDisplayed)
			System.out.println("Phone no required error message displayed");
		boolean isPasswordNameReqMsgDisplayed = passwordReqErrorMsg.isDisplayed();
		Assert.assertTrue(isPasswordNameReqMsgDisplayed, "No error message displayed");
		if(isPasswordNameReqMsgDisplayed)
			System.out.println("Password required error message displayed");
	}
	public void checkPasswordMismatchMsg() {
		boolean isMistmatchMsgDisplayed = passwordMismatch.isDisplayed();
		Assert.assertTrue(isMistmatchMsgDisplayed, "No error msg displyed");
		if(isMistmatchMsgDisplayed)
			System.out.println("Password mismatch error message displayed");
	}
}
