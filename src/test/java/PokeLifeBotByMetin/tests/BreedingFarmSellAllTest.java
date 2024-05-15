package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.BreedingFarmPage;
import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BreedingFarmSellAllTest extends BaseTest {

    @BeforeMethod
    public void loginBeforeSellAllTest() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login("lolku123", "lolku1234!");
//        logInPage.login("lolku1234", "lolku1234!");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.notificationClose();
        Assert.assertTrue(loggedInPage.isUserLoggedIn());
    }

    @Test
    public void sellAllPokemon() {
        BreedingFarmPage breedingFarmPage = new BreedingFarmPage(driver);
        breedingFarmPage.sellPokemon();

        Assert.assertTrue(breedingFarmPage.arePokemonSold());
    }
}