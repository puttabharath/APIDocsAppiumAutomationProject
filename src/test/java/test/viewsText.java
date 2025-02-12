package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import pages.BaseTest;
import pages.LoginPage;
import pages.Viewsmodule;

public class viewsText extends BaseTest{
	 LoginPage loginPage;

	    @BeforeClass
	    public void setup() {
	        loginPage = new LoginPage();
	    }
	    
	    @Test(priority = 3,description = "Verfiy the functionality of the Long press on the People Names from Views")
    public void verifyLongPressPeopleNames() {
	    	Viewsmodule viewsPage = new Viewsmodule();
	    	viewsPage.clickViews();
	    	viewsPage.clickExpandableList();
	    	viewsPage.clickCustomAdapter();
	    	viewsPage.clickPeopleNames();
	    	viewsPage.contextMenuValidation();  
	    	
	    	((JavascriptExecutor)driver).executeScript("window: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity}"));
    }
}
