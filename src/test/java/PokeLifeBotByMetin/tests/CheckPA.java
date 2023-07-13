package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckPA extends BaseTest {
    @Test
    public void checkPA() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login("lolku123", "lolku1234");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.PAcheck();
    }
}
