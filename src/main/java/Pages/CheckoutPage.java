//package Pages;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//public class CheckoutPage {
//	
//	WebDriver driver;
//	WebDriverWait wait;
//	
//	public CheckoutPage(WebDriver driver) {
//		// TODO Auto-generated constructor stub
//		this.driver = driver;
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		PageFactory.initElements(driver, this);
//	}
//	
//	@FindBy(linkText = "Checkout") WebElement checkoutBtn;
//	
//	@FindBy(xpath = "//a[contains(text(),'Billing Details')]") WebElement billingDetailsSection;
//	@FindBy(xpath = "//input[@value  = 'Continue']") WebElement bdContinueBtn;
//	
//	@FindBy(xpath = "//a[contains(text(),'Delivery Details')]") WebElement deliveryDetailsSection;
//	@FindBy(xpath = "(//input[@value  = 'Continue'])[2]") WebElement ddContinueBtn;
//	
//	@FindBy(xpath = "//a[contains(text(),'Delivery Method')]") WebElement deliveryMethodSection;
//	@FindBy(xpath = "(//input[@value  = 'Continue'])[3]") WebElement dmContinueBtn;
//	
//	@FindBy(xpath = "//a[contains(text(),'Payment Method')]") WebElement paymentMethodSection;
//	@FindBy(xpath = "//input[@type='checkbox']") WebElement pmCheckBox;
//	@FindBy(xpath = "(//input[@value  = 'Continue'])[4]") WebElement pmContinueBtn;
//	
//	@FindBy(xpath = "//a[contains(text(),'Confirm Order')]") WebElement confirmOrderSection;
//	@FindBy(xpath = "//input[@value  = 'Confirm Order']") WebElement cnfirmOrderBtn;
//	
//	@FindBy(xpath = "//h1[contains(text(),'placed!')]") WebElement orderConfirmMessage;
//	
//	public void clickCheckoutBtn() {
//		checkoutBtn.click();
//	}
//	public void checkBillingDetails() {
//		boolean isBDSectionDisplayed = billingDetailsSection.isDisplayed();
//		Assert.assertTrue(isBDSectionDisplayed, "No section displayed");
//		if(isBDSectionDisplayed)
//			System.out.println("User is on billing details section");
//		bdContinueBtn.click();
//	}
//	public void checkDeliveryDetails() {
//		boolean isDDSectionDisplayed = deliveryDetailsSection.isDisplayed();
//		Assert.assertTrue(isDDSectionDisplayed, "No section displayed");
//		if(isDDSectionDisplayed)
//			System.out.println("User is on delivery details section");
//		ddContinueBtn.click();
//	}
//	public void checkDeliveryMethod() {
//		boolean isDMSectionDisplayed = deliveryMethodSection.isDisplayed();
//		Assert.assertTrue(isDMSectionDisplayed, "No section displayed");
//		if(isDMSectionDisplayed)
//			System.out.println("User is on billing section");
//		dmContinueBtn.click();
//	}
//	public void checkPaymentMethod() {
//		boolean isPMSectionDisplayed = paymentMethodSection.isDisplayed();
//		Assert.assertTrue(isPMSectionDisplayed, "No section displayed");
//		if(isPMSectionDisplayed)
//			System.out.println("User is on payment method section");
//		pmCheckBox.click();
//		pmContinueBtn.click();
//	}
//	public void checkConfirmOrder() {
//		boolean isCOSectionDisplayed = confirmOrderSection.isDisplayed();
//		Assert.assertTrue(isCOSectionDisplayed, "No section displayed");
//		if(isCOSectionDisplayed)
//			System.out.println("User is on confirm order section");
//		cnfirmOrderBtn.click();
//	}
//	public void checkOrderConfirmation() {
//		boolean isOrderConfirmMsgDisplayed = orderConfirmMessage.isDisplayed();
//		Assert.assertTrue(isOrderConfirmMsgDisplayed, "No message displayed");
//		if(isOrderConfirmMsgDisplayed)
//			System.out.println("Order confirmation message displayed");
//	}
//}
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

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Checkout") WebElement checkoutBtn;
    @FindBy(xpath = "//input[@value='Confirm Order']") WebElement confirmOrderBtn;
    @FindBy(xpath = "//h1[contains(text(),'placed!')]") WebElement orderConfirmMessage;

    public void clickCheckoutBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }

    public void checkBillingDetails() {
        // Wait for billing section heading to be visible
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[contains(text(),'Billing Details')]")
        ));
        Assert.assertTrue(section.isDisplayed(), "Billing Details section not displayed");
        System.out.println("User is on billing details section");

        // Wait for Continue button then click
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@value='Continue']")
        )).click();
    }

    public void checkDeliveryDetails() {
        // Wait for delivery details section to appear after billing Continue click
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[contains(text(),'Delivery Details')]")
        ));
        Assert.assertTrue(section.isDisplayed(), "Delivery Details section not displayed");
        System.out.println("User is on delivery details section");

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//input[@value='Continue'])[2]")
        )).click();
    }

    public void checkDeliveryMethod() {
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[contains(text(),'Delivery Method')]")
        ));
        Assert.assertTrue(section.isDisplayed(), "Delivery Method section not displayed");
        System.out.println("User is on billing section");

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//input[@value='Continue'])[3]")
        )).click();
    }

    public void checkPaymentMethod() {
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[contains(text(),'Payment Method')]")
        ));
        Assert.assertTrue(section.isDisplayed(), "Payment Method section not displayed");
        System.out.println("User is on payment method section");

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@type='checkbox']")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//input[@value='Continue'])[4]")
        )).click();
    }

    public void checkConfirmOrder() {
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[contains(text(),'Confirm Order')]")
        ));
        Assert.assertTrue(section.isDisplayed(), "Confirm Order section not displayed");
        System.out.println("User is on confirm order section");

        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn)).click();
    }

    public void checkOrderConfirmation() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOf(orderConfirmMessage));
        Assert.assertTrue(msg.isDisplayed(), "Order confirmation message not displayed");
        System.out.println("Order confirmation message displayed");
    }
}