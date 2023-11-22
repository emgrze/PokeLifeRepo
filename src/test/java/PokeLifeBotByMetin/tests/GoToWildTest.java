package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import PokeLifeBotByMetin.pages.WildPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoToWildTest extends BaseTest {
    @Test
    public void goToWildTest() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login("lolku123", "lolku1234");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.notificationClose();
        loggedInPage.loggedUser();

        WildPage wildPage = new WildPage(driver);

        wildPage.goWild();
        Assert.assertEquals(wildPage.getWildTitle(), "Dzicz - wyprawa");

        do {
            loggedInPage.getIntPA();
            wildPage.startExp();
            loggedInPage.getIntPA();
            loggedInPage.PAcheck();
            System.out.println("Pozostałe PA: " + loggedInPage.getIntPA());
        } while (loggedInPage.getIntPA() >= 5);
    }
}