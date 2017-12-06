package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rafal on 2017-12-04.
 */
public class SeleniumTest {
    private static final String LOCATOR_CS_PAGE = "//*[@class='rc']/*[@class='r']/a[@href='http://agileszkolenia.pl/']";
    private static final By CS_PAGE_RESULT_LINK = By.xpath(LOCATOR_CS_PAGE);
    private static final String CS_PAGE_NAME = "code sprinters";
    private static final String GOOGLE_LINK = "http://google.com";
    private static final By SEARCH_BOX_LOCATOR = By.id("lst-ib");
    public WebDriver driver;

    @Before
    public void initializeBrowser()  throws IOException {
//        driver = new ChromeDriver();
        driver = new RemoteWebDriver(new URL("http://localhost:6543/wd/hub"), new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void canFindCsPageOnFirstGoogleResultPage() {
        driver.get(GOOGLE_LINK);
        WebElement searchBox = driver.findElement(SEARCH_BOX_LOCATOR);
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(CS_PAGE_NAME);
        searchBox.submit();

        Assert.assertTrue("CS page found", driver.findElements(CS_PAGE_RESULT_LINK).size() > 0);
    }

    @After
    public void closeBrowser() {
        if (driver != null) driver.quit();
    }
}
