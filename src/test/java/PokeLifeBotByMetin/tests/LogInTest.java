package PokeLifeBotByMetin.tests;

import org.testng.annotations.Test;
import PokeLifeBotByMetin.pages.LogInPage;

public class LogInTest extends BaseTest {
    @Test
    public void logInTest()  {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login("lol","lol");
    }
}
//branch2.2