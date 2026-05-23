package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
	
	String email = "yogeswa@gmail.com";
	String pass = "Yogeswar@1249";
	
	WebDriver driver = Base.BaseClass.getDriver();
	//Search Product using valid keyword
	LoginPage lp = new LoginPage(driver);
	ProductPage pp = new ProductPage(driver);
	@Given("User is on hompage and select login option in account tab and login to account")
	public void user_is_on_hompage_and_select_login_option_in_account_tab_and_login_to_account() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickLoginBtn();
	}

	@When("User enters {string} name using valid keyword and click search button")
	public void user_enters_name_using_valid_keyword_and_click_search_button(String vProduct) {
	    // Write code here that turns the phrase above into concrete actions
		pp.enterSearchBox(vProduct);
		pp.clickSearchBtn();
	}

	@Then("User redirect to product results page and verify user got the related {string}")
	public void user_redirect_to_product_results_page_and_verify_user_got_the_related(String vProduct) {
	    // Write code here that turns the phrase above into concrete actions
		if(vProduct.equals("iMac")) {
			String prodName = pp.checkProductResult1();
			if(prodName.contains(vProduct)) {
				System.out.println(prodName + " Products displayed");
			} else {
				System.out.println("Product results not displayed");
			}
		} else if(vProduct.equals("iPhone")){
			String prodName = pp.checkProductResult2();
			if(prodName.contains(vProduct)) {
				System.out.println(prodName + " Products displayed");
			} else {
				System.out.println("Product results not displayed");
			}
		}
	}

	
	//Search product using invalid keyword
	@Given("User is on hompage and select login option in account tab and loggedin to account")
	public void user_is_on_hompage_and_select_login_option_in_account_tab_and_loggedin_to_account() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickLoginBtn();
	}

	@When("User enter {string} name using invalid keyword and click search button")
	public void user_enter_name_using_invalid_keyword_and_click_search_button(String iProduct) {
	    // Write code here that turns the phrase above into concrete actions
		pp.enterSearchBox(iProduct);
		pp.clickSearchBtn();
	}

	@Then("User redirect to product result page and verify user got the related {string}")
	public void user_redirect_to_product_result_page_and_verify_user_got_the_related(String iProduct) {
	    // Write code here that turns the phrase above into concrete actions
		pp.checkProductResults();
	}

	
	//Search Product using empty field
	@Given("User is on home page and selected register option in my accounts tab")
	public void user_is_on_home_page_and_selected_register_option_in_my_accounts_tab() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickLoginBtn();
	}

	@When("User click search button with empty filed")
	public void user_click_search_button_with_empty_filed() {
	    // Write code here that turns the phrase above into concrete actions
		pp.clickSearchBtn();
	}

	@Then("User navigated to page with no products displayed")
	public void user_navigated_to_page_with_no_products_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		pp.checkProductResults();
	}
}
