package PokeLifeBotByMetin.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver = new EdgeDriver();
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
