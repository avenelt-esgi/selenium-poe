package pages;

import helpers.TestDriver;

public class HomePage extends GlpiPageObject {

    private static final String PAGE_URL = "https://tomavt.with16.glpi-network.cloud/front/central.php";

    public HomePage(TestDriver driver) {
        super(driver, PAGE_URL);
    }

}
