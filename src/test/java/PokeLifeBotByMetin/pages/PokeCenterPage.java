package PokeLifeBotByMetin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class PokeCenterPage {

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[3]")
    private WebElement placesList;

    @FindBy(xpath = "(//a[@href='gra/lecznica.php'])[1]")
    private WebElement pokemonCenterBtn;

    @FindBy(xpath = "//button[contains(text(),'Uzupełnij')]")
    private WebElement aidRefillBtn;

    private static WebDriver driver;

    private static Logger LogManager;
    private static final Logger logger = LogManager.getLogger(WildPage.class);

    public PokeCenterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PokeCenterPage.driver = driver;
    }

    public void refillAid() {
        placesList.click();
        pokemonCenterBtn.click();
        aidRefillBtn.click();
        logger.info("Aid refilled");
    }
}
