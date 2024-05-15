package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.*;
import org.testng.annotations.Test;

public class AAllTests extends BaseTest {
    @Test(priority = 1)
    public void login() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login("lolku123", "lolku1234");
    }

    @Test(priority = 2)
    public void checkingPA() {
        login();
        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.notificationClose();
        loggedInPage.PAcheck();
    }

    @Test(priority = 3)
    public void buyPokeballs() {
        login();
        PokeshopPage pokeshopPage = new PokeshopPage(driver);
        pokeshopPage.buyPokeballs();
    }

    @Test(priority = 4)
    public void startWork() {
        login();
        GoWorkPage goWorkPage = new GoWorkPage(driver);
        goWorkPage.checkWorkStatus();
        goWorkPage.goWork();
    }

    @Test(priority = 5)
    public void finishWork() {
        login();
        GoWorkPage goWorkPage = new GoWorkPage(driver);
        goWorkPage.finishWork();
    }

    @Test(priority = 6)
    public void aidRefilling() {
        login();
        PokeCenterPage pokeCenterPage = new PokeCenterPage(driver);
        pokeCenterPage.refillAid();
    }


    @Test(priority = 7)
    public void sellingAllPokemon() {
        login();
        BreedingFarmPage breedingFarmPage = new BreedingFarmPage(driver);
        breedingFarmPage.checkQuantityOfPokemons();
        breedingFarmPage.sellPokemon();
    }
}
