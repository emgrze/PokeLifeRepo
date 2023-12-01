package PokeLifeBotByMetin.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BreedingFarm {
    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[3]")
    private WebElement placesList;

    @FindBy(xpath = "//a[@href='gra/hodowla.php']")
    private WebElement farmBtn;

    @FindBy(xpath = "//button[text()='Sprzedaj Wszystkie']")
    private WebElement sellBtn;

    @FindBy(name = "tekst")
    private WebElement confirmationInput;

    @FindBy(xpath = "(//div[contains(.,'Za sprzedanie')])[5]")
    private WebElement allSold;

    private static WebDriver driver;

    public BreedingFarm(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        BreedingFarm.driver = driver;
    }

    public void sellPokemon() {
        placesList.click();
        farmBtn.click();
        try {
            if (sellBtn.isDisplayed()) {
                sellBtn.click();
                System.out.println("Sell btn clicked");
                confirmationInput.sendKeys("potwierdzam");
                confirmationInput.sendKeys(Keys.ENTER);
                System.out.println("Pokemons sold");
            }
        } catch (Exception e) {
            System.out.println("No pokemon to sell");
        }
    }

    public boolean arePokemonSold() {
        try {
            return allSold.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}