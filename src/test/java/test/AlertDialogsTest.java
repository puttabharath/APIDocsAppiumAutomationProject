package test;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import pages.AppAlertDialogs;
import pages.BaseTest;

public class AlertDialogsTest extends BaseTest {
 
	@Test(priority = 7,description = "Verify the functionality of Alert Dialogs")
	public void ValidationOfAlertDialogs()
	{
	
		AppAlertDialogs aad = new AppAlertDialogs();
		aad.getAppButton();
		aad.getAlertDialogsButton();
		aad.getokCancelDialogMessageOption1();
		aad.getAlertTextOption1();
		aad.getAlertTextCancelOption1();
		
		((JavascriptExecutor)driver).executeScript("window: startActivity",ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity}"));
       
        
      
	}

}
