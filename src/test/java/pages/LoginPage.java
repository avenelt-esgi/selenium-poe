package pages;

import helpers.TestDriver;
import helpers.TestElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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
        TestElement loginName = driver.findElement(By.id("login_name"));
        loginName.click();
        loginName.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        TestElement passwd = driver.findElement(By.cssSelector("input[type='password']"));
        passwd .click();
        passwd .sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        driver.findElement(By.cssSelector("button[name='submit']")).click();
        return new HomePage(driver);
    }
}
