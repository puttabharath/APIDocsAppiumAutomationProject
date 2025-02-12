package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DragandDropmodule {
	AppiumDriver driver;
	SoftAssert sa = new SoftAssert();
	public DragandDropmodule()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
	}
	
	@AndroidFindBy(accessibility = "Views")
	private WebElement viewTexts;
	
	@AndroidFindBy(accessibility = "Drag and Drop")
	private WebElement DragandDropText;
	
	@AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
	private WebElement point1;
	
	@AndroidFindBy(id = "io.appium.android.apis:id/drag_result_text")
	private WebElement DroppedElement;

	public void getViewText()
	{
		viewTexts.click();
	}
	
	public void getDragandDrop()
	{
		DragandDropText.click();
	}
	
	public void getDroppedElement() throws InterruptedException
	{
		String dropText = DroppedElement.getText();

		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(DroppedElement, "Dropped!"));
		System.out.println("The Text after dropping the object on other circle: " + dropText);
		sa.assertEquals(dropText, "Dropped!");
	}
}
