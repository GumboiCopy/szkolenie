package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordPressLoginPage extends WordPressPage {
    private  @FindBy(id="usernameOrEmail") WebElement userNameBox;
    private  @FindBy(id="password") WebElement passwordBox;

    public WordPressLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WordPressAdminPage login(String userName, String password) {
        driver.get(WORDPRESS_ADDREESS + "wp-login.php");

//        WebElement userNameBox = driver.findElement(By.id("usernameOrEmail"));
        writeInto(userName, userNameBox);
        userNameBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(passwordBox));
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

//        WebElement passwordBox = driver.findElement(By.id("password"));
        writeInto(password, passwordBox);
        passwordBox.submit();

        return new WordPressAdminPage(driver);
    }

    private void writeInto(String value, WebElement webElement) {
        webElement.click();
        webElement.clear();
        webElement.sendKeys(value);
    }
}
