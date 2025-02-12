package test;

import org.testng.annotations.Test;

import pages.BaseTest;
import pages.LoginPage;
import pages.ScrollToWebViewmodule;

public class ScrollToWebViewTest extends BaseTest {
	LoginPage loginpage;
	@Test(priority = 4,description = "Verify the functionality of the scroll to \"WebView\" in the Views List")
	public void ScrollingtoWebView()
	{
		ScrollToWebViewmodule swm = new ScrollToWebViewmodule();
		swm.scrolltillWebView();
	}

}
