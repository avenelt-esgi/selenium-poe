package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public TestElement click(By by) {
        findElement(by);

        // wait for element to be clickable
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        WebElement element = wait.until( ExpectedConditions.elementToBeClickable(by) );

        element.click();

        return new TestElement(element);
    }

    @Override
    public TestElement clickAndSendKeys(By by, String content) {
        TestElement elt = click(by);
        elt.sendKeys(content);
        return elt;
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
