package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppAlertDialogs {
	
	AppiumDriver driver;
	SoftAssert sa = new SoftAssert();
	WebDriverWait wait = new WebDriverWait(BaseTest.driver,Duration.ofSeconds(10));
	public AppAlertDialogs()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver),this);
		
	}
	
	@AndroidFindBy(accessibility = "App")
	private WebElement appText;
	
	@AndroidFindBy(accessibility = "Alert Dialogs")
	private WebElement alertDialogText;
	
	@AndroidFindBy(id = "io.appium.android.apis:id/two_buttons")
	private WebElement okCancelDialogMessage;
	
	@AndroidFindBy(id = "android:id/alertTitle")
	private WebElement alertGetText;
	
	@AndroidFindBy(id = "android:id/button2")
	private WebElement cancelAlertOption1;
	
	public void getAppButton()
	{
		appText.click();
	}
	public void getAlertDialogsButton()
	{
		alertDialogText.click();
	}
	
	public void getokCancelDialogMessageOption1()
	{
		okCancelDialogMessage.click();
	}
	
	public void getCancelbuttonAlertOption1()
	{
		cancelAlertOption1.click();
	}
	
	public void getAlertTextOption1()
	{
		String Alert1Text	=BaseTest.driver.switchTo().alert().getText();
	 System.out.println("Text of the Alert text on the option1: "+Alert1Text);
	 sa.assertEquals(Alert1Text,"Lorem ipsum dolor sit aie consectetur adipiscing\\nPlloaso mako nuto siwuf cakso dodtos anr koop.");
	 BaseTest.driver.switchTo().alert().accept();
	}
	public void getAlertTextCancelOption1()
	{
		okCancelDialogMessage.click();
        cancelAlertOption1.click();
        
	}
}
