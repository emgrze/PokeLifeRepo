package PokeLifeBotByMetin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class WildPage {
    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[3]")
    private WebElement placesList;

    @FindBy(xpath = "//a[@href='gra/dzicz.php']")
    private WebElement wildButton;

    @FindBy(xpath = "(//button[text()='Podróżuj'])[1]")
    private WebElement alejkaSpacerowaButton;

    @FindBy(xpath = "(//button[contains(@class,'btn btn-akcja')]//img)[1]")
    private WebElement pokemonToFight;

    @FindBy(xpath = "(//div[@role='group']//button)[2]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[text()='Dzicz - wyprawa']")
    private WebElement wildTitle;

    @FindBy(xpath = "//label[@data-original-title='Pokeball']")
    private WebElement pokeBall;

    private static WebDriver driver;

    public WildPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        WildPage.driver = driver;
    }

    public void goWild() {
        placesList.click();
        wildButton.click();
        alejkaSpacerowaButton.click();
    }

    public void startExp() {
        try {
            if (pokemonToFight.isDisplayed()) {
                pokemonToFight.click();
                System.out.println("Pokemon chosen");
                pokeBall.click();

            } else {
                pokeBall.click();
                System.out.println("Pokeball thrown");
            }
        } catch (Exception e) {
            if (continueButton.isDisplayed()) {
                continueButton.click();
                System.out.println("Continue button clicked");
            }
        }
    }

    public String getWildTitle() {
        return wildTitle.getText();
    }
}