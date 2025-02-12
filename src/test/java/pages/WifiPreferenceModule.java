package pages;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WifiPreferenceModule {
	
	public WifiPreferenceModule()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver),this);
	}
	
	@AndroidFindAll({@AndroidBy(accessibility = "Preference"),
		@AndroidBy(xpath = "//android.widget.TextView[@content-desc=\"Preference\"]")})
	private WebElement preferenceButton;
	
	@AndroidFindAll({@AndroidBy(accessibility = "3. Preference dependencies"),@AndroidBy(xpath = "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")})
	private WebElement perferenceDependenciesButton;
	
	@AndroidFindBy(id = "android:id/checkbox")
	private WebElement checkboxWifi;
	
	@AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
	private WebElement wifiSettingsoption;
	
	@AndroidFindBy(id = "android:id/edit")
	private WebElement wifiSettingsInputfield;
	
	public void preferenceWifiSettings() throws InterruptedException
	{
		preferenceButton.click();
		perferenceDependenciesButton.click();
		checkboxWifi.click();
		DeviceRotation landScape = new DeviceRotation(0,0,90);
		BaseTest.driver.rotate(landScape);
		wifiSettingsoption.click();
		DeviceRotation portrait = new DeviceRotation(0,0,0);
		BaseTest.driver.rotate(portrait);
		wifiSettingsoption.click();
		//Copy to ClipBoard - Paste It on clipboard
		BaseTest.driver.setClipboardText("Bharath Wifi");
		wifiSettingsInputfield.sendKeys(BaseTest.driver.getClipboardText());
		BaseTest.driver.switchTo().alert().accept();
		BaseTest.driver.pressKey(new KeyEvent(AndroidKey.BACK));
		BaseTest.driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	
	
}
