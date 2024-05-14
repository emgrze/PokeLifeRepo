package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static PokeLifeBotByMetin.utils.TestLogger.log;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UserSimulator extends BaseTest {

    @Test
    public void goToWildTest() {
        LogInPage logInPage = new LogInPage(driver);
        LoggedInPage loggedInPage = new LoggedInPage(driver);

        logInPage.login("lolku123", "lolku1234");
//        logInPage.login("lolku1234", "lolku1234!");


        try {
            if (loggedInPage.isUserLoggedIn()) {
                assertTrue(loggedInPage.isUserLoggedIn());
            }
        } catch (Exception e) {
            assertFalse(loggedInPage.isUserLoggedIn());
        }

        loggedInPage.notificationClose();

        GoWorkPage goWorkPage = new GoWorkPage(driver);
        goWorkPage.checkWorkStatus();

        PokeshopPage pokeshopPage = new PokeshopPage(driver);
        pokeshopPage.buyPokeballs();

        WildPage wildPage = new WildPage(driver);

        BreedingFarmPage breedingFarmPage = new BreedingFarmPage(driver);

        if (loggedInPage.getIntAid() < 80) {
            PokeCenterPage pokeCenterPage = new PokeCenterPage(driver);
            pokeCenterPage.refillAid();
        }

        loggedInPage.PAcheck();

        while (loggedInPage.getIntPA() >= 5) {
            wildPage.goWild();
            wildPage.startExp();

            try {
                loggedInPage.PAcheck();
                if (loggedInPage.getIntPA() < 25) {
                    wildPage.drinkGreenPotion();
                    wildPage.potionConfirmationWindowsClose();
                    log.info("Confirmation closed");
                }
            } catch (Exception e) {
                wildPage.potionLimitReached();
                log.warn("Green potion limit exceeded");
            }

            try {
                loggedInPage.PAcheck();
                if (wildPage.isWildTitleVisible()) {
                    wildPage.startExp();
                    Assert.assertEquals(wildPage.getWildTitle(), "Dzicz - wyprawa");
                }
            } catch (Exception e) {
                wildPage.goWild();
            }

            try {
                if (wildPage.fullStorageAlert()) {
                    wildPage.teleportToBreedingFarm();
                    wildPage.sellPokemon();
                    Assert.assertTrue(breedingFarmPage.arePokemonSold());
                    wildPage.goWild();
                } else {
                    wildPage.goWild();
                }
            } catch (Exception e) {
                wildPage.goWild();
            }
        }
    }
}