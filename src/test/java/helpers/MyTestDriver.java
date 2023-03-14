package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyTestDriver implements TestDriver {

    private final WebDriver driver;

    public MyTestDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public TestElement findElement(By by) {
        var elt = new TestElement(this.driver.findElement(by));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Sleep in findElement decorator interrupted", e);
        }
        return elt;
    }

    @Override
    public void get(String url) {
        this.driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    @Override
    public void quit() {
        this.driver.quit();
    }
}
