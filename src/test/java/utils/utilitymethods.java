package utils;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

	public class utilitymethods {
	
		    private WebDriverWait wait;
			public AppiumDriver driver;


		    // Constructor to initialize driver and wait
		    public utilitymethods(AppiumDriver driver) {
		        this.driver = driver;
		        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
		    }

		    // Long Click Gesture Method
		    public void longPress(WebElement element, int duration) {
		        wait.until(ExpectedConditions.elementToBeClickable(element)); // Ensure element is clickable
		        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
		            ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", duration));
		    }
		    
		    
		    //use this if we know till what point to scroll
		    public void scrollToElementWebView() {
		        driver.findElement(AppiumBy.androidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true))" +
		            ".scrollIntoView(new UiSelector().text(\"WebView\"))"
		        ));
		    }
   
		    //Use this If we want to scroll till end
		    
		    public void scrolltillEnd() {
		        boolean canScrollMore;
		        
		        do {
		            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript(
		                "mobile: scrollGesture",
		                com.google.common.collect.ImmutableMap.builder()
		                    .put("left", 100)
		                    .put("top", 100)
		                    .put("width", 200)
		                    .put("height", 200)
		                    .put("direction", "down")
		                    .put("percent", 0.3)  // Use a fractional value between 0 and 1
		                    .build());
		        } while (canScrollMore);
		    }		
		    
		    public void DragandDrop()
		    {
				WebElement dragElement = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
				((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
					    "elementId", ((RemoteWebElement) dragElement).getId(),
					    "endX", 706,
					    "endY", 652
					));
		    }
		    
		    
		    
		
		public void scrollDown()
		{
	    PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

	    // Define the sequence of touch actions
	    Sequence scrollGesture = new Sequence(finger, 1);
	    scrollGesture.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), 47, 80));
	    scrollGesture.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    scrollGesture.addAction(new Pause(finger, Duration.ofMillis(500)));
	    scrollGesture.addAction(finger.createPointerMove(Duration.ofMillis(825), PointerInput.Origin.viewport(), 45, 44));
	    scrollGesture.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    // Perform the gesture
	    driver.perform(Arrays.asList(scrollGesture));
	    }
		
		public void scrollUp() {
		    PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

		    // Define the sequence of touch actions
		    Sequence scrollGesture = new Sequence(finger, 1);
		    scrollGesture.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 46, 16)); // Start position
		    scrollGesture.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())); // Press down
		    scrollGesture.addAction(new Pause(finger, Duration.ofMillis(200))); // Pause
		    scrollGesture.addAction(finger.createPointerMove(Duration.ofMillis(1439), PointerInput.Origin.viewport(), 47, 80)); // End position
		    scrollGesture.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); // Release

		    // Perform the gesture
		    driver.perform(Arrays.asList(scrollGesture));
		}

		
	}



