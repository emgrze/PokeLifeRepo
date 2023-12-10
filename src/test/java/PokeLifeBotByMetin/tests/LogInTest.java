package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test
    public void logInTest() {
        LogInPage logInPage = new LogInPage(driver);
        LoggedInPage loggedInPage = new LoggedInPage(driver);

        logInPage.login("lolku123", "lolku1234");
//        logInPage.login("lolku1234", "lolku1234!");

        if (loggedInPage.isUserLoggedIn()) {
            System.out.println("Login success");
        } else {
            Assert.assertTrue(logInPage.loginFailed());
//            Assert.assertFalse(loggedInPage.isUserLoggedIn());
            System.out.println("Login failed");
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://gra.pokelife.pl/index.php");
    }
}
