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

    @FindBy(xpath = "(//img[@class='img-responsive'])[2]")
    private WebElement pokemonToFight;

    @FindBy(xpath = "(//div[@role='group']//button)[2]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[text()='Dzicz - wyprawa']")
    private WebElement wildTitle;

    @FindBy(xpath = "//img[@alt='Pokeball']")
    private WebElement pokeBall;

    private static WebDriver driver;

    public WildPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        WildPage.driver = driver;
    }
    public void goWild() {
        placesList.click();
        wildButton.click();
        alejkaSpacerowaButton.click();
    }
    public void startExp() {
        try{
            if (pokemonToFight.isDisplayed()){
            pokemonToFight.click();
        }
        }catch (Exception e) {
            if (continueButton.isDisplayed()){
            continueButton.click();}
        }
//        if (pokemonToFight.isDisplayed()){
//            pokemonToFight.click();
//        } else if (pokeBall.isDisplayed()){
//            pokeBall.click();
//        } else{
//            continueButton.click();
//        }
    }

    public String getWildTitle() {
        return wildTitle.getText();
    }
}