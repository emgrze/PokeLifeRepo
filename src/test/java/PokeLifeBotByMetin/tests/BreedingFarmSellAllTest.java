package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.BreedingFarm;
import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BreedingFarmSellAllTest extends BaseTest {
    @Test
    public void sellAllPokemon() {
        LogInPage logInPage = new LogInPage(driver);
//        logInPage.login("lolku123", "lolku1234!");
        logInPage.login("lolku1234", "lolku1234!");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.notificationClose();
        loggedInPage.loggedUser();

        BreedingFarm breedingFarm = new BreedingFarm(driver);
        breedingFarm.sellPokemon();

        Assert.assertTrue(breedingFarm.arePokemonSold());
    }
}