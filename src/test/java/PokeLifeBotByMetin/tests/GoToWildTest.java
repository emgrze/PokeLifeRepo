package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class GoToWildTest extends BaseTest {
    private static Logger LogManager;
    private static final Logger logger = LogManager.getLogger(GoToWildTest.class);
    @Test
    public void goToWildTest() {
        LogInPage logInPage = new LogInPage(driver);
        LoggedInPage loggedInPage = new LoggedInPage(driver);

//        logInPage.login("lolku1234", "lolku1234!");
        logInPage.login("lolku123", "lolku1234");
        try {
            if (loggedInPage.isUserLoggedIn()) {
                assertTrue(loggedInPage.isUserLoggedIn());
            }
        } catch (Exception e) {
            assertFalse(loggedInPage.isUserLoggedIn());
            driver.quit();
        }

        loggedInPage.notificationClose();

        GoWorkPage goWorkPage = new GoWorkPage(driver);
        goWorkPage.checkWorkStatus();

        PokeshopPage pokeshopPage = new PokeshopPage(driver);
        pokeshopPage.buyPokeballs();

        WildPage wildPage = new WildPage(driver);

        BreedingFarmPage breedingFarmPage = new BreedingFarmPage(driver);

        wildPage.goWild();

        do {
            loggedInPage.getIntPA();
            loggedInPage.PAcheck();
            wildPage.startExp();

            try {
                if (loggedInPage.getIntPA() < 25) {
                    wildPage.drinkGreenPotion();
                    wildPage.confirmPotionUsage();
                    wildPage.potionConfirmationWindowsClose();
                    logger.info("Confirmation closed");
//                    System.out.println("Confirmation closed");
                }
            } catch (Exception e) {
                wildPage.potionLimitReached();
                logger.warn("Green potion limit exceeded");
//                System.out.println("Green potion limit exceeded");
            }

            try {
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
//                    wildPage.sellPokemon();
                    Assert.assertTrue(breedingFarmPage.arePokemonSold());
                    wildPage.goWild();
                } else {
                    wildPage.goWild();
                }
            } catch (Exception e) {
                logger.warn("catch storage alert");
//                System.out.println("catch storage alert");
            }

        } while (loggedInPage.getIntPA() >= 5);
    }
}