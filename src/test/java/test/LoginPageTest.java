package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        loginPage = new LoginPage();
    }

    @Test(priority = 1, description = "Verify homepage title is 'API Demos'")
    public void verifyHomePageTitle() {
        String homeTitle = loginPage.getHomeTitle();
        Reporter.log("Home Title: " + homeTitle, true);
        Assert.assertEquals(homeTitle, "API Demos");
    }

    @Test(priority = 2, description = "Verify 'Graphics' text is displayed")
    public void verifyGraphicsText() {
        String graphicText = loginPage.getGraphicsText();
        Reporter.log("Graphics Text: " + graphicText, true);
        Assert.assertEquals(graphicText, "Graphics");
    }
}
