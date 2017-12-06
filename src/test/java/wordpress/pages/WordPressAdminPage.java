package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WordPressAdminPage extends WordPressPage {
    public WordPressAdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElements(By.id("wpadminbar")).size() == 1;
    }
}
