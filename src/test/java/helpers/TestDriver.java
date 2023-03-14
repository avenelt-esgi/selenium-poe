package helpers;

import org.openqa.selenium.By;

public interface TestDriver {

    public TestElement findElement(By by);

    void get(String url);

    String getCurrentUrl();

    void quit();
}
