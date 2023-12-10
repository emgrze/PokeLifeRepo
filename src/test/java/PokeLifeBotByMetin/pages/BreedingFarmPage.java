package PokeLifeBotByMetin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import java.time.Duration;

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

    private static WebDriver driver;

    private static Logger LogManager;
    private static final Logger logger = LogManager.getLogger(LoggedInPage.class);

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
                logger.info("Sell btn clicked");
                confirmationInput.sendKeys("potwierdzam");
                confirmationInput.sendKeys(Keys.ENTER);
                logger.info("Pokemon sold");
            }
        } catch (Exception e) {
            logger.info("No pokemon to sell");
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
            logger.info("Sell btn clicked");
            confirmationInput.sendKeys("potwierdzam");
            confirmationInput.sendKeys(Keys.ENTER);
            logger.info("Pokemons sold");
        }
    }
}