package PokeLifeBotByMetin.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

import java.time.Duration;

public class PokeshopPage {
    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[3]")
    private WebElement placesBtn;

    @FindBy(xpath = "//div[@id='menu-collapse']/ul[1]/li[3]/ul[1]/li[4]/a[1]")
    private WebElement pokeshopBtn;

    @FindBy(id = "shopCategorySelect")
    private WebElement dropDownList;

    @FindBy(xpath = "//img[@src='images/pokesklep/pokeballe.png']")
    private WebElement pokeballBtn;

    @FindBy(id = "ilosc")
    private WebElement pokeballQuantityInput;

    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement shoppingSuccess;

    @FindBy(xpath = "//button[text()=' Kup ']")
    private WebElement buyButton;

    private static WebDriver driver;

    private static Logger LogManager;
    private static final Logger logger = LogManager.getLogger(WildPage.class);

    public PokeshopPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        PokeshopPage.driver = driver;
    }

    public void buyPokeballs() {
        placesBtn.click();
        pokeshopBtn.click();
        dropDownList.click();
        Select select = new Select(dropDownList);
        select.selectByVisibleText("Pokeballe");
        pokeballBtn.click();
        pokeballQuantityInput.sendKeys("25", Keys.ENTER);
        buyButton.click();
        logger.info("Pokeballs bought");
    }

    public boolean isShoppingSuccessful() {
        try {
            return shoppingSuccess.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
