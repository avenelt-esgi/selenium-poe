package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyTestDriver implements TestDriver {

    private final WebDriver driver;

    public MyTestDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public TestElement findElement(By by) {
        WebElement webElt = this.driver.findElement(by);
        scrollToElement(webElt);
        var elt = new TestElement(webElt);
        try {
            Thread.sleep(1000);
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

    private void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)this.driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
