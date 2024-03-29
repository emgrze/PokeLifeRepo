package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test
    public void logInTest() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login("lolku123", "lolku1234");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.loggedUser();

        Assert.assertEquals(driver.getCurrentUrl(), "https://gra.pokelife.pl/index.php");
    }
}
