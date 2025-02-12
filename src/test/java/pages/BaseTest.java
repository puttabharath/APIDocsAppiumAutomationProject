package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.utilitymethods;

public class BaseTest {
    public AppiumDriverLocalService service;
    public static AndroidDriver driver;
    public static utilitymethods utils;

    @BeforeClass(alwaysRun=true)
    public void ConfigAppium() throws Exception {
        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/testData/data.properties");
            prop.load(fis);

            String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
            String port = prop.getProperty("port");

            System.out.println("Using Appium server at " + ipAddress + ":" + port);

            service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\bharath\\node_modules\\appium\\build\\lib\\main.js"))
                .withArgument(() -> "--session-override")
                .withIPAddress(ipAddress)
                .usingPort(Integer.parseInt(port))
                .build();

            if (!service.isRunning()) {
                service.start();
            }

            UiAutomator2Options options = new UiAutomator2Options();
            options.setUdid("73667afc");

            String appPath = System.getenv("APP_PATH");
            if (appPath == null || appPath.isEmpty()) {
                appPath = "C:\\Users\\bharath\\eclipse-workspace\\API_DOCS_Appium_Automation\\src\\test\\java\\utils\\ApiDemos-debug.apk";
            }
            options.setApp(appPath);
            options.setAutomationName("UiAutomator2");
            options.setPlatformVersion("11");
            options.setNoReset(false);
            options.setFullReset(true);
            options.setNewCommandTimeout(Duration.ofSeconds(60));
            options.setAppPackage("io.appium.android.apis");
            options.setAppActivity("io.appium.android.apis.ApiDemos");

            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().logs().get("logcat").forEach(log -> System.out.println(log));

                   utils = new utilitymethods(driver);
                   
        } catch (Exception e) {
            throw new RuntimeException("Failed to start Appium service: " + e.getMessage());
        }
        
    }
    
    public String getScreenshot(String testCaseName, AndroidDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get(System.getProperty("user.dir"), "reports", testCaseName + ".png");
        FileUtils.copyFile(source, destination.toFile());
        return destination.toString();
    }
    @AfterClass(alwaysRun=true)
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            if (service != null && service.isRunning()) {
                service.stop();
            }
        }
    }
}
