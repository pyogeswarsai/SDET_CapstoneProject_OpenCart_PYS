package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import Pages.LogoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {

	WebDriver driver = Base.BaseClass.getDriver();
	
	String email = "yogeswa@gmail.com";
	String pass = "Yogeswar@1249";
	
	//Verify logout functionality
	LoginPage lp = new LoginPage(driver);
	LogoutPage lop = new LogoutPage(driver);
	@Given("User is on home page and logins to account")
	public void user_is_on_home_page_and_logins_to_account() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickLoginBtn();
	}

	@When("Select My Account Option and click on Logout option")
	public void select_my_account_option_and_click_on_logout_option() {
	    // Write code here that turns the phrase above into concrete actions
		lop.clickAccountOption();
	}

	@When("User logged out from account and verify session termination")
	public void user_logged_out_from_account_and_verify_session_termination() {
	    // Write code here that turns the phrase above into concrete actions
		lop.clickLogout();
		lop.CheckAccountLoggedout();
	}

	@Then("User click continue to redirect to homepage")
	public void user_click_continue_to_redirect_to_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		lop.clickContinue();
		lop.checkHomepageDisplayed();
	}
}
