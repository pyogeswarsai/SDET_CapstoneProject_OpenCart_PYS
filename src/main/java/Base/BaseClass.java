package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<String> browserName = new ThreadLocal<>();

    // Set Browser Name for current thread
    public static void setBrowserName(String browser) {
        browserName.set(browser);
    }

    // Get Browser Name for current thread
    public static String getBrowserName() {
        return browserName.get();
    }

  
    // Launch Browser
    public static void launchBrowser() {

        String browser = browserName.get();

        // Default Browser
        if (browser == null) {
            browser = "chrome";
        }

        System.out.println("Launching Browser: " + browser +
                " | Thread ID: " + Thread.currentThread().getId());

        if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
//            EdgeOptions edgeOptions = new EdgeOptions();
//            edgeOptions.addArguments("--headless=new");
//            edgeOptions.addArguments("--window-size=1920,1080");
//            edgeOptions.addArguments("--disable-gpu");
//            edgeOptions.addArguments("--no-sandbox");
//            edgeOptions.addArguments("--disable-dev-shm-usage");
//            driver.set(new EdgeDriver(edgeOptions));
            driver.set(new EdgeDriver());

        } else {

            WebDriverManager.chromedriver().setup();
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless=new"); 
//            chromeOptions.addArguments("--window-size=1920,1080");
//            chromeOptions.addArguments("--disable-gpu");
//            chromeOptions.addArguments("--no-sandbox");           
//            chromeOptions.addArguments("--disable-dev-shm-usage");
//            driver.set(new ChromeDriver(chromeOptions));
            driver.set(new ChromeDriver());
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        getDriver().get("https://tutorialsninja.com/demo/");
    }


    // Get Driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Close Browser
    public static void closeBrowser() {
    	if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Clear ThreadLocal
        }
    }
    public static String getBrowserSuffix() {
        String browser = browserName.get();
        if (browser == null) browser = "chrome";
        return browser.toLowerCase(); // returns "chrome" or "edge"
    }
    public static String getTestEmail() {
        return "yogeswar_2" + getBrowserSuffix() + "@gmail.com";
    }
 
    public static String getTestPassword() {
        return "Yogeswar@1249";
    }

//    public static String getRegistrationEmail() {
//        return "yogeswar_reg_" + getBrowserSuffix() + "@gmail.com";
//    }
}