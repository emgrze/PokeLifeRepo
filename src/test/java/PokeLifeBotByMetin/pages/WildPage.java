package PokeLifeBotByMetin.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

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

    @FindBy(id = "$0")
    private WebElement pokeballQuantity;

    @FindBy(xpath = "//img[@src='images/ikony/zielony_napoj.png']")
    private WebElement greenPotion;

    @FindBy(xpath = "(//button[text()=' Potwierdź '])[1]")
    private WebElement potionConfirmationBtn;

    @FindBy(xpath = "(//span[text()='×'])[4]")
    private WebElement potionConfirmationBtnClose;

    @FindBy(xpath = "(//button[text()='Zamknij'])[2]")
    private WebElement potionLimitReached;

    @FindBy(xpath = "//div[@class='col-xs-12']//div[1]")
    private WebElement fullStorageAlert;

    @FindBy(xpath = "//button[@href='hodowla.php']")
    private WebElement teleportToBreedingFarmBtn;

    @FindBy(xpath = "//body")
    private WebElement emptyActionBtn;

    @FindBy(xpath = "//button[text()='Sprzedaj Wszystkie']")
    private WebElement sellBtn;

    @FindBy(name = "tekst")
    private WebElement confirmationInput;


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
            if (wildTitle.isDisplayed() && pokemonToFight.isDisplayed()) {
                pokemonToFight.isDisplayed();
                pokemonToFight.click();
                logger.info("Pokemon chosen");
//                System.out.println("Pokemon chosen");
//                checkPokeballQuantity();
                pokeBall.click();
                logger.info("Pokeball thrown if");
//                System.out.println("Pokeball thrown if");
            } else {
                goWild();
            }

        } catch (Exception e) {
            try {
                if (continueButton.isDisplayed()) {
                    continueButton.click();
                    logger.info("Continue button clicked");
//                    System.out.println("Continue button clicked");
                } else {
                    confirmPotionUsage();
                }
            } catch (Exception f) {
                f.printStackTrace();
                logger.warn("Exception in startexp");
//                System.out.println("Exception in startexp");
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

    public void checkPokeballQuantity() {
        System.out.println("liczba kulek: " + pokeballQuantity.getText());
    }

    public void drinkGreenPotion() {
        try {
            greenPotion.click();
            logger.info("Green potion used");
//            System.out.println("Green potion used");
        } catch (Exception e) {
            logger.warn("Potion error");
//            System.out.println("potion error");
        }
    }

    public void confirmPotionUsage() {
        potionConfirmationBtn.click();
        logger.info("Potion confirmed");
//        System.out.println("Potion confirmed");
    }

    public void potionConfirmationWindowsClose() {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", potionConfirmationBtnClose);
        } catch (Exception e) {
            System.out.println("potion window closing failed");
        }

    }

    public void isPotionConfirmBtnCloseVisible() {
        try {
            if (potionConfirmationBtnClose.isDisplayed()) {
                potionConfirmationBtnClose.click();
            }
        } catch (Exception e) {
            System.out.println("no confirmation to close");
        }
    }

    public void potionLimitReached() {
        potionLimitReached.isDisplayed();
        potionConfirmationBtnClose.click();
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
        System.out.println("Sell btn clicked");
        confirmationInput.sendKeys("potwierdzam");
        confirmationInput.sendKeys(Keys.ENTER);
        System.out.println("Pokemons sold");
    }

    public void emptyActionBtn() {
        emptyActionBtn.click();
    }

    public boolean fullStorageAlert() {
        try {
            return fullStorageAlert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}