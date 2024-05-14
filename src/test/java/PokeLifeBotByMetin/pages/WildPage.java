package PokeLifeBotByMetin.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import java.time.Duration;

public class WildPage {

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    private WebElement characterList;

    @FindBy(xpath = "//a[@href='gra/plecak.php']")
    private WebElement backPackButton;

    @FindBy(xpath = "//div[@data-target='#plecak-zielony_napoj']//img[1]")
    private WebElement greenPotionInBackpackBtn;

    @FindBy(xpath = "(//button[text()='Użyj'])[1]")
    private WebElement confirmPotionInBackPack;

    @FindBy(xpath = "(//button[text()=' Potwierdź '])[1]")
    private WebElement definetelyConfirmPotionUsage;

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

    @FindBy(id = "$0")
    private WebElement pokeballQuantity;

    @FindBy(xpath = "//img[@src='images/ikony/zielony_napoj.png']")
    private WebElement greenPotion;

    @FindBy(xpath = "(//button[text()=' Potwierdź '])[1]")
    private WebElement potionConfirmationBtn;

    @FindBy(xpath = "(//button[@class='close']//span)[4]")
    private WebElement potionConfirmationBtnClose;

    @FindBy(xpath = "(//div[contains(@class,'alert alert-warning')])")
    private WebElement potionLimitReached;

    @FindBy(xpath = "//div[@class='col-xs-12']//div[1]")
    private WebElement fullStorageAlert;

    @FindBy(xpath = "//a[@href='gra/hodowla.php']")
    private WebElement teleportToBreedingFarmBtn;

    @FindBy(xpath = "//body")
    private WebElement emptyActionBtn;

    @FindBy(xpath = "//button[text()='Sprzedaj Wszystkie']")
    private WebElement sellBtn;

    @FindBy(name = "tekst")
    private WebElement confirmationInput;

    @FindBy(css = "button#wyloguj>span")
    private WebElement logoutBtn;

    @FindBy(xpath = "//div[text()='Spróbowałeś uwięzić pokemona w pokeballu, niestety stwór się uwolnił po czym uciekł.']")
    private WebElement catchUnsuccessful;

    @FindBy(xpath = "//*[contains(text(), 'Udało Ci się złapać')]")
    private WebElement catchSuccessful;

    private static WebDriver driver;

    private static Logger LogManager;
    private static final Logger logger = LogManager.getLogger(WildPage.class);

    public WildPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        WildPage.driver = driver;
    }

    public void goWild() {
        placesList.click();
        wildButton.click();
        try {
            alejkaSpacerowaButton.click();
            emptyActionBtn();
            startExp();
        } catch (NoSuchElementException e) {
            teleportToBreedingFarm();
        } catch (Exception e) {
            try {
                potionConfirmationBtnClose.click();
            } catch (Exception f) {
                System.out.println("gowild exception f");
            }
        }
    }

    public void startExp() {
        try {
            if (pokemonToFight.isDisplayed()) {
                pokemonToFight.click();
                logger.info("Pokemon chosen for fight");
                if (pokeBall.isDisplayed()) {
                    logger.info("Fight won");
                }
                pokeBall.click();
                logger.info("Pokeball thrown");
                if (catchUnsuccessful.isDisplayed()) {
                    logger.info("Catching Pokemon unsuccessful");
                } else {
                    logger.info("Pokemon catched!");
                }
            } else {
                continueAdventure();
            }

        } catch (
                Exception e) {
            try {
                if (continueButton.isDisplayed()) {
                    continueButton.click();
                    logger.info("Continue button clicked");
                } else {
                    confirmPotionUsage();
                }
            } catch (Exception f) {
                f.printStackTrace();
                logger.warn("Exception in startexp");
            }
        }

    }

    public void continueAdventure() {
        continueButton.click();
        try {
            startExp();
        } catch (NoSuchElementException e) {
            teleportToBreedingFarm();
        } catch (Exception e) {
            try {
                potionConfirmationBtnClose.click();
            } catch (Exception f) {
                System.out.println("gowild exception f");
            }
        }
    }

    public String getWildTitle() {
        return wildTitle.getText();
    }

    public boolean isWildTitleVisible() {
        try {
            return wildTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void drinkGreenPotion() {
        greenPotion.click();
        logger.info("Green potion used");
    }

    public void confirmPotionUsage() {
        potionConfirmationBtn.click();
        logger.info("Potion confirmed");
    }

    public void potionConfirmationWindowsClose() {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", potionConfirmationBtnClose);
            emptyActionBtn.click();
            logger.info("Potion confirmation window closed");
        } catch (Exception e) {
            logger.warn("potion window closing failed");
        }

    }

    public void isPotionConfirmBtnCloseVisible() {
        try {
            if (potionConfirmationBtnClose.isDisplayed()) {
                potionConfirmationBtnClose.click();
            }
        } catch (Exception e) {
            logger.info("no confirmation to close");
        }
    }

    public void potionLimitReached() {
        potionLimitReached.isDisplayed();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", potionConfirmationBtnClose);
        driver.close();
    }

    public void teleportToBreedingFarm() {
        if (teleportToBreedingFarmBtn.isDisplayed()) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", teleportToBreedingFarmBtn);
            sellPokemon();
        }
    }

    public void sellPokemon() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", sellBtn);
        logger.info("Sell btn clicked");
        confirmationInput.sendKeys("potwierdzam");
        confirmationInput.sendKeys(Keys.ENTER);
        logger.info("Pokemons sold");
    }

    public void emptyActionBtn() {
        emptyActionBtn.click();
    }

    public boolean fullStorageAlert() {
        boolean result = false;
        if (fullStorageAlert.isDisplayed()) {
            result = true;

        }
        return result;
    }
}