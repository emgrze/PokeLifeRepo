package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static PokeLifeBotByMetin.utils.TestLogger.log;

public class LogInTest extends BaseTest {
    @Test
    public void logInTest() {
        LogInPage logInPage = new LogInPage(this.driver);
        LoggedInPage loggedInPage = new LoggedInPage(this.driver);

        logInPage.login("lolku123", "lolku1234");
//        logInPage.login("lolku1234", "lolku1234!");

        if (loggedInPage.isUserLoggedIn()) {
            log.info("Login success");
        } else {
            Assert.assertTrue(logInPage.loginFailed());
            log.warn("Login failed");
        }
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://gra.pokelife.pl/index.php");
    }
}
