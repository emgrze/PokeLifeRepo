package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.GoWorkPage;
import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkTest extends BaseTest {
    @Test(priority = 1)
    public void goToWork() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login("lolku123", "lolku1234");
//        logInPage.login("lolku1234", "lolku1234!");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.notificationClose();
        Assert.assertTrue(loggedInPage.isUserLoggedIn());

        GoWorkPage goWorkPage = new GoWorkPage(driver);
        goWorkPage.goWork();
    }

    @Test(priority = 2)
    public void finishWork() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login("lolku123", "lolku1234");
//        logInPage.login("lolku1234", "lolku1234!");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.notificationClose();
        Assert.assertTrue(loggedInPage.isUserLoggedIn());

        GoWorkPage goWorkPage = new GoWorkPage(driver);
        goWorkPage.finishWork();
    }
}
