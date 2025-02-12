package test;

import org.testng.annotations.Test;

import pages.BaseTest;
import pages.WifiPreferenceModule;

public class PreferenceWifiSettingsTest extends BaseTest{
	
	@Test (priority = 6,description = "Verify the functioanlity of the wifi settings")
	public void ValidatewifisettingsModule() throws InterruptedException
	{
		 WifiPreferenceModule wpm = new WifiPreferenceModule();
		 wpm.preferenceWifiSettings();
	}

}
