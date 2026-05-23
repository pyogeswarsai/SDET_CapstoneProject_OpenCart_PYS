package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	String email = "yogeswa@gmail.com";
	String pass = "Yogeswar@1249";
	WebDriver driver = Base.BaseClass.getDriver();
	
	LoginPage lp = new LoginPage(driver);
	//Login with valid credentials
	@Given("User is on hompage and select login option in account tab")
	public void user_is_on_hompage_and_select_login_option_in_account_tab() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
	}

	@When("User enters valid email and password and click on sign in")
	public void user_enters_valid_email_and_password_and_click_on_sign_in() {
	    // Write code here that turns the phrase above into concrete actions
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickLoginBtn();
	}

	@Then("User navigated to users account homepage and verified the page")
	public void user_navigated_to_users_account_homepage_and_verified_the_page() {
	    // Write code here that turns the phrase above into concrete actions
		lp.checkSuccessfulLogin();
	}
	
	
	//Login with invalid credentials
	@Given("User is on hompage and select login option in my account tab")
	public void user_is_on_hompage_and_select_login_option_in_my_account_tab() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
	}

	@When("User enters invalid {string} and {string} and click on sign in")
	public void user_enters_invalid_and_and_click_on_sign_in(String email, String password) {
	    // Write code here that turns the phrase above into concrete actions
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLoginBtn();
	}

	@Then("User will get the Error message")
	public void user_will_get_the_error_message() {
	    // Write code here that turns the phrase above into concrete actions
		lp.checkErrorMsg();
	}
	
	
	//Login with blank credentials
	@Given("User is on hompage and select login option in my accounts tab")
	public void user_is_on_hompage_and_select_login_option_in_my_accounts_tab() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
	}

	@When("User not entered both email and password and click on login")
	public void user_not_entered_both_email_and_password_and_click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
		lp.clickLoginBtn();
	}

	@Then("User get the error message")
	public void user_get_the_error_message() {
	    // Write code here that turns the phrase above into concrete actions
		lp.checkErrorMsg();
	}
}
