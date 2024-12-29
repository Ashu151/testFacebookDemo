package testcomponenets;

import facebookconfig.ConfigReader;
import facebookconfig.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({reports.TestListener.class})
public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Before suite method to load config values
    @BeforeSuite
    public void setupSuite() throws Exception {
        ConfigReader.populateSettings(); // Load config properties before any tests start
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext context) {
        WebDriver driverInstance = createDriver(); // Dynamically create the driver
        driver.set(driverInstance); // Set the driver for parallel execution
        driver.get().manage().window().maximize(); // Maximize the browser window
        driver.get().get(Settings.websiteUrl); // Navigate to the base URL from config
    }

    private WebDriver createDriver() {
        WebDriver driverInstance = null;

        // Retrieve the browser name from Jenkins or default to Chrome
        String browser = System.getProperty("browserName", "chrome").toLowerCase();

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (Settings.isHeadless) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
                driverInstance = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (Settings.isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                driverInstance = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (Settings.isHeadless) {
                    edgeOptions.addArguments("headless");
                }
                driverInstance = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driverInstance;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit(); // Quit the driver instance
            driver.remove(); // Remove the ThreadLocal driver instance
        }
    }

    public WebDriver getDriver() {
        return driver.get(); // Return the current thread's WebDriver instance
    }
}
