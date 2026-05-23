package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
	
WebDriver driver = Base.BaseClass.getDriver();
	
	String email = "yogeswa@gmail.com";
	String pass = "Yogeswar@1249";
	
	LoginPage lp = new LoginPage(driver);
	ProductPage pp = new ProductPage(driver);
	CartPage cp = new CartPage(driver);
	CheckoutPage cop = new CheckoutPage(driver);
	//verify checkout functionality
	@Given("User login to account and search for a product")
	public void user_login_to_account_and_search_for_a_product() {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectMyAccountOption();
		lp.selectLoginOption();
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickLoginBtn();
		
		pp.enterSearchBox("hp");
		pp.clickSearchBtn();

	}

	@When("User select product and added to cart")
	public void user_select_product_and_added_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
		pp.clickCheckoutProduct();
		cp.clickAddToCartBtn();
	}

	@When("User went to cart page and click on checkout button")
	public void user_went_to_cart_page_and_click_on_checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
		cp.selectCartOption();
		cop.clickCheckoutBtn();
	}

	@When("User enters billing details and delivery details")
	public void user_enters_billing_details_and_delivery_details() {
	    // Write code here that turns the phrase above into concrete actions
		cop.checkBillingDetails();
		cop.checkDeliveryDetails();
	}

	@When("User enters delivery method and payment method and confirm order")
	public void user_enters_delivery_method_and_payment_method_and_confirm_order() {
	    // Write code here that turns the phrase above into concrete actions
		cop.checkDeliveryMethod();
		cop.checkPaymentMethod();
		cop.checkConfirmOrder();
	}

	@Then("User get the order confirmation message")
	public void user_get_the_order_confirmation_message() {
	    // Write code here that turns the phrase above into concrete actions
		cop.checkOrderConfirmation();
	}
}
