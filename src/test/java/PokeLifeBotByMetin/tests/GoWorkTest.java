package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.GoWorkPage;
import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoWorkTest extends BaseTest {
    @Test
    public void goToWork() {
        LogInPage logInPage = new LogInPage(driver);
//        logInPage.login("lolku123", "lolku1234!");
        logInPage.login("lolku1234", "lolku1234!");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.notificationClose();
        Assert.assertTrue(loggedInPage.isUserLoggedIn());
//        loggedInPage.loggedUser();

        GoWorkPage goWorkPage = new GoWorkPage(driver);
        goWorkPage.goWork();
    }

    @Test
    public void finishWork() {
        LogInPage logInPage = new LogInPage(driver);
//        logInPage.login("lolku123", "lolku1234!");
        logInPage.login("lolku1234", "lolku1234!");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.notificationClose();
        Assert.assertTrue(loggedInPage.isUserLoggedIn());
//        loggedInPage.loggedUser();

        GoWorkPage goWorkPage = new GoWorkPage(driver);
        goWorkPage.finishWork();
    }
}
