package Hooks;

import Base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class OpenCartHooks {

    @Before
    public void setupBrowser() {
        BaseClass.launchBrowser();
    }

    @After
    public void quitBrowser() {
        BaseClass.closeBrowser();
    }
}