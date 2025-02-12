package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ScrollToWebViewmodule {
	WebDriverWait wait;
	
	public ScrollToWebViewmodule()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver),this);
		wait = new WebDriverWait(BaseTest.driver,Duration.ofSeconds(10));
	}
	
	@AndroidFindBy(accessibility = "Views")
	private WebElement viewmenuText;
	
	public void scrolltillWebView()
	{
		viewmenuText.click();
		BaseTest.utils.scrollToElementWebView();
	}
}
