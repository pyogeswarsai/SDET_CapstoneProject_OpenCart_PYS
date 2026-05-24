package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
	
	WebDriver driver = Base.BaseClass.getDriver();
	
	String uniqueEmail = "yogeswar_1419" + Base.BaseClass.getBrowserSuffix() + "@gmail.com";
	
	RegistrationPage rp = new RegistrationPage(driver);
	//User Navigated to registration page
	@Given("User is on homepage")
	public void user_is_on_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Homepage loaded");
	}

	@When("User select Register option in account tab")
	public void user_select_register_option_in_account_tab() {
	    // Write code here that turns the phrase above into concrete actions
		rp.selectMyAccountOption();
		rp.clickRegisterOption();
	}

	@Then("User navigated to regsiter page and verify registration page is displayed")
	public void user_navigated_to_regsiter_page_and_verify_registration_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		rp.checkRegistrationPage();
	}

	
	//Register user with valid details
	@Given("User is on hompage and select register option in account tab")
	public void user_is_on_hompage_and_select_register_option_in_account_tab() {
	    // Write code here that turns the phrase above into concrete actions
		rp.selectMyAccountOption();
		rp.clickRegisterOption();
	}

	@When("User enter all necessary details")
	public void user_enter_all_necessary_details() {
	    // Write code here that turns the phrase above into concrete actions
		rp.enterUserName("Polisetty", "Yogeswar Sai");
		rp.enterEmail(uniqueEmail);
		rp.enterPhoneNo();
		rp.enterPassword("Yogeswar@1249");
		rp.enterCnfPassword("Yogeswar@1249");
	}

	@When("Click checkbox and click on continue")
	public void click_checkbox_and_click_on_continue() {
	    // Write code here that turns the phrase above into concrete actions
		rp.clickPolicyCheckbox();
		rp.clickContinue();
	}

	@Then("User successfully registered and verify successful account creation")
	public void user_successfully_registered_and_verify_successful_account_creation() {
	    // Write code here that turns the phrase above into concrete actions
		rp.checkSuccessAccountCreation();
	}

	
	//Register user with existing email
	@Given("User is on hompage and selected register option in my account tab")
	public void user_is_on_hompage_and_selected_register_option_in_my_account_tab() {
	    // Write code here that turns the phrase above into concrete actions
		rp.selectMyAccountOption();
		rp.clickRegisterOption();
	}

	@When("User enters all updated details but used existing {string}")
	public void user_enters_all_updated_details_but_used_existing(String email) {
	    // Write code here that turns the phrase above into concrete actions
		rp.enterUserName("Polisetty", "Yogeswar Sai");
		rp.enterEmail(email);
		rp.enterPhoneNo();
		rp.enterPassword("Yogeswar@123");
		rp.enterCnfPassword("Yogeswar@123");
		rp.clickPolicyCheckbox();
		rp.clickContinue();
	}

	@Then("Click continue and verify warning message")
	public void click_continue_and_verify_warning_message() {
	    // Write code here that turns the phrase above into concrete actions
		rp.checkExistingEmailMsg();
	}

	
	//verify mandatory field validation messages
	@Given("User is on hompage and select register option in my account tab")
	public void user_is_on_hompage_and_select_register_option_in_my_account_tab() {
	    // Write code here that turns the phrase above into concrete actions
		rp.selectMyAccountOption();
		rp.clickRegisterOption();
	}

	@When("User not entered any details and click on continue")
	public void user_not_entered_any_details_and_click_on_continue() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("No Details entered and clicked continue");
		rp.clickPolicyCheckbox();
		rp.clickContinue();
	}

	@Then("User gets a warning message")
	public void user_gets_a_warning_message() {
	    // Write code here that turns the phrase above into concrete actions
		rp.checkReqFieldErrorMsg();
	}


	//Verify password mismatch validation
	@Given("User is on hompage and selected register option in my accounts tab")
	public void user_is_on_hompage_and_selected_register_option_in_my_accounts_tab() {
	    // Write code here that turns the phrase above into concrete actions
		rp.selectMyAccountOption();
		rp.clickRegisterOption();
	}
	
	@When("User entered all details but used two different passwords and click continue")
	public void user_entered_all_details_but_used_two_different_passwords_and_click_continue() {
	    // Write code here that turns the phrase above into concrete actions
		rp.enterUserName("Polisetty", "Yogeswar Sai");
		rp.enterEmail("y@gmail.com");
		rp.enterPhoneNo();
		rp.enterPassword("Yogeswar@123");
		rp.enterCnfPassword("Yogeswa@123");
		rp.clickPolicyCheckbox();
		rp.clickContinue();
	}

	@Then("User gets the Password mismatch error message and verify")
	public void user_gets_the_password_mismatch_error_message_and_verify() {
	    // Write code here that turns the phrase above into concrete actions
		rp.checkPasswordMismatchMsg();
	}
}
