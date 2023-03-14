package helpers;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class Helpers {

    public static HomePage login(WebDriver driver, String username, String password) {
        return new LoginPage(new MyTestDriver(driver))
                .gotoPage()
                .setUser(username)
                .setPassword(password)
                .clickLoginButton();
    }
}
