package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import PokeLifeBotByMetin.pages.PokeCenterPage;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class AidRefillTest extends BaseTest{

    private static Logger LogManager;
    private static final Logger logger = LogManager.getLogger(GoToWildTest.class);

    @Test
    public void checkAndRefillAid() {
        LogInPage logInPage = new LogInPage(driver);
        LoggedInPage loggedInPage = new LoggedInPage(driver);
        PokeCenterPage pokeCenterPage = new PokeCenterPage(driver);

        logInPage.login("lolku123", "lolku1234");
        loggedInPage.notificationClose();

        loggedInPage.aidKitLevelCheck();
        pokeCenterPage.refillAid();
    }
}
