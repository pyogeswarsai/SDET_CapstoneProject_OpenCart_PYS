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

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Shopping Cart')]") WebElement cartOption;
	@FindBy(xpath = "//button[contains(text(),'Add to Cart')]") WebElement addToCartBtn;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") WebElement prodAddSuccessMsg;
	@FindBy(xpath = "(//p[contains(text(),'cart is empty')])[2]") WebElement cartEmptyMsg;
	
	@FindBy(xpath = "//input[@type = 'text' and @size='1']") WebElement prodQuantityUpdate;
	@FindBy(xpath = "//button[@type = 'submit' and @data-original-title='Update']") WebElement updateQuantityBtn;
	
	@FindBy(xpath = "//button[@type = 'button' and @data-toggle='tooltip']") WebElement removeProduct;
	
//	@FindBy(xpath = "(//td[contains(text(),'244')])[4]") WebElement updatedPriceCheck;
//	@FindBy(xpath = "//input[@value = '2']") WebElement updatedQuantityCheck;
	
	@FindBy(xpath = "//input[@type='text' and @size='1']") WebElement quantityInputAfterUpdate;
	
	public void clickAddToCartBtn() {
		addToCartBtn.click();
		System.out.println("Add to cart button clicked");
	}
	public void selectCartOption() {
		 WebElement cart = wait.until(
			        ExpectedConditions.elementToBeClickable(
			            By.xpath("//span[contains(text(),'Shopping Cart')]")
			        )
			    );
			    cart.click();
			    System.out.println("Selected shopping cart option");
	}
	public void updateProdQuantity() {
		wait.until(ExpectedConditions.visibilityOf(prodQuantityUpdate));
		prodQuantityUpdate.click();
		System.out.println("clicked on quanity text box");
		prodQuantityUpdate.clear();
		System.out.println("cleared existing quantity");
		prodQuantityUpdate.sendKeys("2");
		System.out.println("update quantity to 2");
		updateQuantityBtn.click();
		System.out.println("clicked update cart button");
	}
	public void clickRemoveProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(removeProduct));
		removeProduct.click();
		System.out.println("Clicked remove product button");
	}
//	public void updatedPriceQuantityCheck() {
//		boolean isUpdatedPriceDisplayed = updatedPriceCheck.isDisplayed();
//		Assert.assertTrue(isUpdatedPriceDisplayed, "not updated");
//		if(isUpdatedPriceDisplayed)
//			System.out.println("Price updated");
//		
//		boolean isUpdatedQuantityDisplayed = updatedQuantityCheck.isDisplayed();
//		Assert.assertTrue(isUpdatedQuantityDisplayed, "not updated");
//		if(isUpdatedQuantityDisplayed)
//			System.out.println("Quantity updated");
//	}
	public void updatedPriceQuantityCheck() {
        // Wait for the page to re-render after AJAX update before asserting
        // FIXED: removed hardcoded price "244" — price changes on demo site
        // We verify quantity updated to "2" which is reliable and meaningful
        wait.until(ExpectedConditions.attributeToBe(
            By.xpath("//input[@type='text' and @size='1']"), "value", "2"
        ));
 
        String quantityValue = driver.findElement(
            By.xpath("//input[@type='text' and @size='1']")
        ).getAttribute("value");
 
        Assert.assertEquals(quantityValue, "2", "Quantity was not updated to 2");
        System.out.println("Quantity successfully updated to: " + quantityValue);
    }
	public void checkSuccessMsg() {
		WebElement successMsg = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//div[contains(@class,'alert-success')]")
	            )
	        );
		boolean isSuccessMsgDisplayed = successMsg.isDisplayed();
		Assert.assertTrue(isSuccessMsgDisplayed, "No message displayed");
		if(isSuccessMsgDisplayed)
			System.out.println("Product Added to cart, success message displayed");
	}
//	public void checkCartEmptyMsg() {
//		boolean isEmptyDisplayed = cartEmptyMsg.isDisplayed();
//		Assert.assertTrue(isEmptyDisplayed, "No message displayed");
//		if(isEmptyDisplayed) {
//			System.out.println("Cart Empty Message displayed");
//		}
//	}
	public void checkCartEmptyMsg() {
        // Wait for empty cart message to appear after AJAX removal re-render
        WebElement emptyMsg = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//p[contains(text(),'cart is empty')])[2]")
            )
        );
        boolean isEmptyDisplayed = emptyMsg.isDisplayed();
        Assert.assertTrue(isEmptyDisplayed, "Cart empty message not displayed");
        if (isEmptyDisplayed)
            System.out.println("Cart empty message displayed");
    }
	public void clearCartIfNotEmpty() {
	    try {
	        // If a remove button exists, click all of them
	        java.util.List<WebElement> removeButtons = driver.findElements(
	            By.xpath("//button[@type='button' and @data-toggle='tooltip']")
	        );
	        for (WebElement btn : removeButtons) {
	            wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
	            // Small pause for AJAX to settle between removals
	            Thread.sleep(500);
	        }
	    } catch (Exception e) {
	        // Cart was already empty — nothing to do
	    }
	}
}
