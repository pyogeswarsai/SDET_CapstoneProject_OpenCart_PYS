package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
	
	WebDriver driver = Base.BaseClass.getDriver();
	LoginPage lp = new LoginPage(driver);
	ProductPage pp = new ProductPage(driver);
	CartPage cp = new CartPage(driver);
	
	String email = Base.BaseClass.getTestEmail();
	String pass = Base.BaseClass.getTestPassword();
	
	//Add product to cart
	@Given("User is on homepage and logged into account")
	public void user_is_on_homepage_and_logged_into_account() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickLoginBtn();
	}

	@When("User search for product and get the product results")
	public void user_search_for_product_and_get_the_product_results() {
	    // Write code here that turns the phrase above into concrete actions
		pp.enterSearchBox("iMac");
		pp.clickSearchBtn();
	}

	@When("User selected the product and navigated to product page")
	public void user_selected_the_product_and_navigated_to_product_page() {
	    // Write code here that turns the phrase above into concrete actions
		pp.clickProduct();
	}

	@Then("User selected Add to cart button and verify product added to cart")
	public void user_selected_add_to_cart_button_and_verify_product_added_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
		cp.clickAddToCartBtn();
		cp.checkSuccessMsg();
	}

	
	//Update product quantity
	@Given("User is on open cart homepage and logged in to account")
	public void user_is_on_open_cart_homepage_and_logged_in_to_account() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickLoginBtn();
	}

	@When("User select Shopping cart and navigated to cart page")
	public void user_select_shopping_cart_and_navigated_to_cart_page() {
	    // Write code here that turns the phrase above into concrete actions
		cp.selectCartOption();
	}

	@When("User updates the quantity of product")
	public void user_updates_the_quantity_of_product() {
	    // Write code here that turns the phrase above into concrete actions
		cp.updateProdQuantity();
	}

	@Then("Verify price changes and quantity updated")
	public void verify_price_changes_and_quantity_updated() {
	    // Write code here that turns the phrase above into concrete actions
		cp.updatedPriceQuantityCheck();
	}

	
	//Remove product from cart
	@Given("User is on demo open cart homepage and logged in to account")
	public void user_is_on_demo_open_cart_homepage_and_logged_in_to_account() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickLoginBtn();
	}

	@When("User click on Shopping cart and navigated to cart page")
	public void user_click_on_shopping_cart_and_navigated_to_cart_page() {
	    // Write code here that turns the phrase above into concrete actions
		cp.selectCartOption();
	}

	@When("User remove product from cart")
	public void user_remove_product_from_cart() {
	    // Write code here that turns the phrase above into concrete actions
		cp.clickRemoveProduct();
	}

	@Then("Verify product removed from cart")
	public void verify_product_removed_from_cart() {
	    // Write code here that turns the phrase above into concrete actions
		cp.checkCartEmptyMsg();
	}
	

	//Verify empty cart message
	@Given("User is on homepage and log in to account")
	public void user_is_on_homepage_and_log_in_to_account() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickLoginBtn();
	}

	@When("User clicked on Shopping cart and navigated to cart page")
	public void user_clicked_on_shopping_cart_and_navigated_to_cart_page() {
	    // Write code here that turns the phrase above into concrete actions
		cp.selectCartOption();
		cp.clearCartIfNotEmpty();
	}

	@Then("Verify Cart empty message displayed")
	public void verify_cart_empty_message_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		cp.checkCartEmptyMsg();
	}
}
