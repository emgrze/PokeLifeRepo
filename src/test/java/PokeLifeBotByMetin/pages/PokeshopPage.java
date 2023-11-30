package PokeLifeBotByMetin.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PokeshopPage {
    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[3]")
    private WebElement placesBtn;

    @FindBy(xpath = "//a[@href='gra/pokesklep.php']")
    private WebElement pokeshopBtn;

    @FindBy(xpath = "(//input[@id='target1'])[1]")
    private WebElement pokeballQuantityInput;

    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement shoppingSuccess;

    private static WebDriver driver;

    public PokeshopPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        PokeshopPage.driver = driver;
    }

    public void buyPokeballs() {
        placesBtn.click();
        pokeshopBtn.click();
        pokeballQuantityInput.sendKeys("25", Keys.ENTER);
    }

    public boolean isShoppingSuccessful() {
        try {
            return shoppingSuccess.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
