package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage {
    WebDriverWait wait;
    SoftAssert sa = new SoftAssert();

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
        wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='API Demos']")
    @iOSXCUITFindBy (xpath = "//android.widget.TextView[@text='API Demos']")
    private WebElement APIDocTitlename;

    @AndroidFindBy(accessibility = "Graphics")
    @iOSXCUITFindBy(accessibility = "Graphics")
    private WebElement graphicsText;

    public String getHomeTitle() {
        return APIDocTitlename.getText();
    }

    public String getGraphicsText() {
        return graphicsText.getText();
    }
}
