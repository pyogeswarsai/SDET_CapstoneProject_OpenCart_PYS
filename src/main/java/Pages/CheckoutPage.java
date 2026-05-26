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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Checkout") WebElement checkoutBtn;
    @FindBy(xpath = "//input[@value='Confirm Order']") WebElement confirmOrderBtn;
    @FindBy(xpath = "//h1[contains(text(),'placed!')]") WebElement orderConfirmMessage;

    public void clickCheckoutBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }

    public void checkBillingDetails() {

        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Billing Details')]")));
        Assert.assertTrue(section.isDisplayed(), "Billing Details section not displayed");
        System.out.println("User is on billing details section");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']"))).click();
    }

    public void checkDeliveryDetails() {

        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Delivery Details')]")));
        Assert.assertTrue(section.isDisplayed(), "Delivery Details section not displayed");
        System.out.println("User is on delivery details section");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Continue'])[2]"))).click();
    }

    public void checkDeliveryMethod() {
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Delivery Method')]")));
        Assert.assertTrue(section.isDisplayed(), "Delivery Method section not displayed");
        System.out.println("User is on billing section");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Continue'])[3]"))).click();
    }

    public void checkPaymentMethod() {
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Payment Method')]")));
        Assert.assertTrue(section.isDisplayed(), "Payment Method section not displayed");
        System.out.println("User is on payment method section");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Continue'])[4]"))).click();
    }

    public void checkConfirmOrder() {
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Confirm Order')]")));
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