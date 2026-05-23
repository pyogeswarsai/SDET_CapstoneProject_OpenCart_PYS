package Runners;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Base.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//i want to override this using TestNG parameter, because
		//i would like to run all my feature files in order. so,
		//i want to change in testng
        features = "src/test/resources/Features",
        glue = {"StepDefinitions", "Hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)

public class OpenCartRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("browser")
    public void setBrowser(String browser) {

        BaseClass.setBrowserName(browser); 
        System.setProperty("browser", browser);
        System.out.println("Browser set: " + browser
                + " | Thread ID: " + Thread.currentThread().getId());
    }


    @DataProvider(parallel = false)
    @Override
    public Object[][] scenarios() {

        return super.scenarios();
    }
}