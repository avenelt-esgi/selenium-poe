package pages;

import helpers.TestDriver;
import helpers.TestElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage extends GlpiPageObject {

    private static final String PAGE_URL = "https://tomavt.with16.glpi-network.cloud/index.php";

    public LoginPage(TestDriver driver) {
        super(driver, PAGE_URL);
    }

    public LoginPage gotoPage() {
        this.driver.get(PAGE_URL);
        return this;
    }

    public LoginPage setUser(String username) {
        driver.clickAndSendKeys(By.id("login_name"), username);
        return this;
    }

    public LoginPage setPassword(String password) {
        driver.clickAndSendKeys(By.cssSelector("input[type='password']"), password);
        return this;
    }

    public HomePage clickLoginButton() {
        driver.click(By.cssSelector("button[name='submit']"));
        return new HomePage(driver);
    }
}
