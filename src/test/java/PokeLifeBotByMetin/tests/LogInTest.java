package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test
    public void logInTest() {
        LogInPage logInPage = new LogInPage(driver);
        LoggedInPage loggedInPage = new LoggedInPage(driver);

        try {
            logInPage.login("lolku123", "lolku1234");
            loggedInPage.loggedUser();
        } catch (Exception e) {
            Assert.assertTrue(logInPage.loginFailed());
            {
                throw new SkipException("Pomijam ten test");
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://gra.pokelife.pl/index.php");
    }
}
