package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    public WebDriver driver;
    @Before
    public void InitializeBrowser(){
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void FirstSeleniumTest() throws InterruptedException {
        driver.get("http://www.goduckgo.com");
        WebElement searchBox = driver.findElement(By.id("search_form_input_homepage"));
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys("code sprinters");
        searchBox.submit();

        Assert.assertTrue("check that cs page is found", driver.findElements(By.xpath("//a[@class='result__a' and @href='http://codesprinters.com/']")).size() >0);
        Thread.sleep(1500);
    }

    @After
    public void CloseBrowser(){
        if (driver != null) driver.quit();
    }
}

