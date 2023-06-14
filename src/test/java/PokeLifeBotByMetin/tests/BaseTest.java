package PokeLifeBotByMetin.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver = new EdgeDriver();
    //TODO: Do podbicia wersja
    @BeforeMethod
    public void setup() {
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get("https://pokelife.pl/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

//branch

//ctrl+alt+o - ogarnia importy
//br2
