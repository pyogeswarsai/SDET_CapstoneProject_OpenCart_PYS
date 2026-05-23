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

public class ProductPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ProductPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(name = "search") WebElement searchBox;
//	@FindBy(xpath = "(//button[@type='button'])[4]") WebElement searchBtn;
	
	@FindBy(linkText = "iMac") WebElement vProductResult1;
	@FindBy(linkText = "iPhone") WebElement vProductResult2;
	
	@FindBy(xpath = "//p[contains(text(),'no product')]") WebElement checkProductResult;
	
//	@FindBy(partialLinkText = "HP") WebElement checkoutProduct;
	
	public void enterSearchBox(String product) {
		WebElement searchBox = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.name("search"))
	        );
	        searchBox.clear();
		searchBox.sendKeys(product);
		System.out.println(product + " name send to check box");
	}
	public void clickSearchBtn() {
		WebElement searchBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.cssSelector("button[type='button'].btn-default")
	            )
	        );
		searchBtn.click();
		System.out.println("Clicked search button");
	}
	public String checkProductResult1() {
		WebElement pr1 = wait.until(ExpectedConditions.visibilityOf(vProductResult1));
        String prodName = pr1.getText();
        pr1.click();
        return prodName;
	}
	public String checkProductResult2() {
		WebElement pr2 = wait.until(ExpectedConditions.visibilityOf(vProductResult2));
        String prodName = pr2.getText();
        pr2.click();
        return prodName;
	}
	public void checkProductResults() {
		WebElement msg = wait.until(
	            ExpectedConditions.visibilityOf(checkProductResult)
	        );
		boolean isNoProductMsgDisplayed = msg.isDisplayed();
		Assert.assertTrue(isNoProductMsgDisplayed, "Products displayed");
		if(isNoProductMsgDisplayed) {
			System.out.println("No related products displayed");
		}
	}
	public void clickProduct() {
		wait.until(ExpectedConditions.visibilityOf(vProductResult1)).click();
	}
	
	public void clickCheckoutProduct() {
		WebElement hp = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.partialLinkText("HP")
	            )
	        );
	        hp.click();
	}
}
