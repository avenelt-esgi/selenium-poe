package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TestImplementation {

    private static final String TEST_USER = "admin";
    private static final String TEST_PASSWORD = "#g9eYkRd9dYHFeXiaof987";

    private WebDriver driver;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
        // for Firefox 
        // System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        // for Firefox
        // driver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginToGlpi() {
        // Arrange
        driver.get("https://tomavt.with16.glpi-network.cloud/index.php");

        // Act
        WebElement loginName = driver.findElement(By.id("login_name"));
        loginName.click();
        loginName.sendKeys(TEST_USER);

        WebElement passwd = driver.findElement(By.cssSelector("input[type='password']"));
        passwd .click();
        passwd .sendKeys(TEST_PASSWORD);

        WebElement loginButton = driver.findElement(By.cssSelector("button[name='submit']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", loginButton);
        loginButton.click();

        // Assert
        String HOME_URL = "https://tomavt.with16.glpi-network.cloud/front/central.php";
        assertEquals("The home page is expected",
                HOME_URL,
                driver.getCurrentUrl());
    }
}
