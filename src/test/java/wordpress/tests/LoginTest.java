package wordpress.tests;

import org.junit.Assert;
import org.junit.Test;
import utils.tests.BaseTest;
import wordpress.pages.WordPressAdminPage;
import wordpress.pages.WordPressLoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void shouldOpenAdminPageAfterLogin() {
        WordPressLoginPage loginPage = new WordPressLoginPage(driver);

        String userName = "autotestjava@gmail.com";
        String password = "P@ssw0rd1";
        WordPressAdminPage adminPage = loginPage.login(userName, password);

        Assert.assertTrue("Should open admin page after log in", adminPage.isOpened());
    }
}
