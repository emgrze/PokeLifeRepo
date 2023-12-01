package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoToWildTest extends BaseTest {
    @Test
    public void goToWildTest() {
        LogInPage logInPage = new LogInPage(driver);
//        logInPage.login("lolku123", "lolku1234");
        logInPage.login("lolku1234", "lolku1234!!");


        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.notificationClose();
        loggedInPage.loggedUser();

        GoWorkPage goWorkPage = new GoWorkPage(driver);
        goWorkPage.checkWorkStatus();

        PokeshopPage pokeshopPage = new PokeshopPage(driver);
        pokeshopPage.buyPokeballs();

        WildPage wildPage = new WildPage(driver);
        wildPage.goWild();

        Assert.assertEquals(wildPage.getWildTitle(), "Dzicz - wyprawa");


        do {
            loggedInPage.getIntPA();
            wildPage.startExp();
            loggedInPage.getIntPA();
            loggedInPage.PAcheck();
        } while (loggedInPage.getIntPA() >= 5);
    }
}