package Pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;	
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text() = 'My Account']") WebElement myAccountOption;
	@FindBy(linkText = "Login") WebElement loginOption;
	@FindBy(id = "input-email") WebElement email;
	@FindBy(id = "input-password") WebElement password;
	@FindBy(xpath = "//input[@type = 'submit']") WebElement loginBtn;
	
	@FindBy(xpath = "//h2[text() = 'My Account']") WebElement accMsgDisplayed;
	@FindBy(xpath = "//h2[contains(text(),'Orders')]") WebElement ordersMsgDisplayed;
	
	@FindBy(xpath = "//div[contains(text(),'Warning')]") WebElement warningMsg;
	
	public void selectMyAccountOption() {
		myAccountOption.click();
		System.out.println("Selected My account tab");
	}
	public void selectLoginOption() {
		loginOption.click();
		System.out.println("Selected login option");
	}
	public void enterEmail(String userEmail) {
		email.sendKeys(userEmail);
		System.out.println("Entered email");
	}
	public void enterPassword(String userPass) {
		password.sendKeys(userPass);
		System.out.println("Entered password");
	}
	public void clickLoginBtn() {
		loginBtn.click();
		System.out.println("Selected login button");
	}
	public void checkSuccessfulLogin() {
		boolean isAccDisplayed = accMsgDisplayed.isDisplayed();
		Assert.assertTrue(isAccDisplayed, "Login error");
		if(isAccDisplayed)
			System.out.println("My account setting displayed");
		boolean isOrderDisplayed = ordersMsgDisplayed.isDisplayed();
		Assert.assertTrue(isOrderDisplayed, "Login error");
		if(isOrderDisplayed)
			System.out.println("My orders setting displayed");
	}
	public void checkErrorMsg() {
		boolean isWarningDisplayed = warningMsg.isDisplayed();
		Assert.assertTrue(isWarningDisplayed, "No warning message displayed");
		if(isWarningDisplayed)
			System.out.println("Getting warning message");
	}
}
