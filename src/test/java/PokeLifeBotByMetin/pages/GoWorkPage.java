package PokeLifeBotByMetin.pages;

import PokeLifeBotByMetin.tests.GoToWildTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import java.time.Duration;

public class GoWorkPage {
    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    private WebElement characterList;

    @FindBy(xpath = "//a[@href='gra/aktywnosc.php']")
    private WebElement activityBtn;

    @FindBy(xpath = "(//button[text()='Pracuj'])[1]")
    private WebElement workBtn;

    @FindBy(xpath = "//button[text()='Zakończ']")
    private WebElement finishWorkBtn;

    @FindBy(xpath = "(//div[contains(.,'Jesteś w trakcie Pracy.Przejdź do Aktywności')])[4]")
    private WebElement workNotification;

    private static WebDriver driver;

    private static Logger LogManager;
    private static final Logger logger = LogManager.getLogger(GoToWildTest.class);

    public GoWorkPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        GoWorkPage.driver = driver;
    }

    public void checkWorkStatus() {
        try {
            if (workNotification.isDisplayed()) {
                finishWork();
                logger.info("Work finished");
            }
        } catch (Exception e) {
            logger.info("Work status checked, test continues");
        }
    }

    public void goWork() {
        characterList.click();
        activityBtn.click();
        workBtn.click();
    }

    public void finishWork() {
        characterList.click();
        activityBtn.click();
        finishWorkBtn.click();
    }
}
