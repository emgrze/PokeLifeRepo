package PokeLifeBotByMetin.tests;

import PokeLifeBotByMetin.pages.LogInPage;
import PokeLifeBotByMetin.pages.LoggedInPage;
import PokeLifeBotByMetin.pages.PokeshopPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuyPokeballsTest extends BaseTest {
@BeforeMethod
    public void loginBeforeBuyTest() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login("lolku123", "lolku1234");
//        logInPage.login("lolku1234", "lolku1234!");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.notificationClose();
        Assert.assertTrue(loggedInPage.isUserLoggedIn());
    }
    @Test
    public void buyPokeballs() {
        PokeshopPage pokeshopPage = new PokeshopPage(driver);
        pokeshopPage.buyPokeballs();

        Assert.assertTrue(pokeshopPage.isShoppingSuccessful());
    }
}
