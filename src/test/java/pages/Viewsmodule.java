package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Viewsmodule extends BaseTest {
	WebDriverWait wait;
    SoftAssert sa = new SoftAssert();

   public Viewsmodule()
   { 
	   PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver),this);
	   wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
   }
    
  @AndroidFindBy(accessibility = "Views")
  private WebElement viewsText;
  
  @AndroidFindBy(accessibility = "Expandable Lists")
  private WebElement expandableListText;
  
  @AndroidFindBy(accessibility = "1. Custom Adapter")
  private WebElement customAdapterText;
    
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
private
  static WebElement peopleNamesText;
  
  @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.FrameLayout")
  private WebElement sampleMenuText;
  
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sample action']")
  private WebElement sampleActionText;
  
  public void clickViews() {
      viewsText.click();
  }

  public void clickExpandableList() {
      expandableListText.click();
  }

  public void clickCustomAdapter() {
      customAdapterText.click();
  }

  public void clickPeopleNames() {
      BaseTest.utils.longPress(peopleNamesText, 2000);
  }    
	
  public void contextMenuValidation()
  {
   String sample_menu_Text = sampleMenuText.getText();
   sa.assertEquals(sample_menu_Text,"Sample menu");
   sa.assertTrue(sampleMenuText.isDisplayed());
    sampleActionText.click();
  }
}
