package PokeLifeBotByMetin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import static PokeLifeBotByMetin.utils.TestLogger.log;

public class BreedingFarmPage {
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

    @FindBy(xpath = "//div[@data-original-title='Posiadanych pokemonów / Maksymalna ilość pokemonów']")
    private WebElement pokemonQuantity;

    private static WebDriver driver;

    public BreedingFarmPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        BreedingFarmPage.driver = driver;
    }

    public void sellPokemon() {
        placesList.click();
        farmBtn.click();
        try {
            if (sellBtn.isDisplayed()) {
                sellBtn.click();
                log.info("Sell btn clicked");
                confirmationInput.sendKeys("potwierdzam");
                confirmationInput.sendKeys(Keys.ENTER);
                log.info("Pokemon sold");
            }
        } catch (Exception e) {
            log.info("Pokemon used for fighting, nothing to sell");
        }
    }

    public boolean arePokemonSold() {
        try {
            return allSold.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void sellPokemonFromWild() {
        if (sellBtn.isDisplayed()) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", sellBtn);
            log.info("Sell btn clicked");
            confirmationInput.sendKeys("potwierdzam");
            confirmationInput.sendKeys(Keys.ENTER);
            log.info("Pokemons sold");
        }
    }
    public void checkQuantityOfPokemons() {
        String str = pokemonQuantity.getText();
        String pokeQuan = str.substring(0, str.indexOf("/"));
        if(pokeQuan == "1") {
            log.info("There's no pokemon to sell");
        } else {
            log.info("There's: " + pokeQuan + " Pokemon(s) in the inventory");
        }
    }
}