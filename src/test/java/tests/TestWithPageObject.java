package tests;

import helpers.Helpers;
import helpers.MyTestDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GlpiPageObject;
import pages.HomePage;
import pages.LoginPage;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TestWithPageObject {

    private static final String TEST_USER = "admin";
    private static final String TEST_PASSWORD = "#g9eYkRd9dYHFeXiaof987";
    private HomePage page = null;
    private ChromeDriver driver = null;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
    }

 @Before
    public void setup() {
        this.driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        Optional.ofNullable(page).map(GlpiPageObject::close);
    }

    @Test
    public void testLoginToGlpi() {
        // Arrange - nothing

        // Act
        this.page = new LoginPage(new MyTestDriver(driver))
                .gotoPage()
                .setUser(TEST_USER)
                .setPassword(TEST_PASSWORD)
                .clickLoginButton();

        // Assert
        assertEquals(
                "The home page is expected",
                page.getExpectedUrl(),
                page.getCurrentUrl()
        );
    }
}
