package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import PokeLifeBotByMetin.pages.PokeCenterPage;
import org.testng.annotations.Test;

public class AidRefillTest extends BaseTest {


    @Test
    public void checkAndRefillAid() {
        LogInPage logInPage = new LogInPage(driver);
        LoggedInPage loggedInPage = new LoggedInPage(driver);
        PokeCenterPage pokeCenterPage = new PokeCenterPage(driver);

        logInPage.login("lolku123", "lolku1234");
//        logInPage.login("lolku1234", "lolku1234!");
        loggedInPage.notificationClose();

        loggedInPage.aidKitLevelCheck();
        pokeCenterPage.refillAid();
    }
}
