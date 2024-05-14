package PokeLifeBotByMetin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static PokeLifeBotByMetin.utils.TestLogger.log;

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

    public GoWorkPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        GoWorkPage.driver = driver;
    }

    public void checkWorkStatus() {
        try {
            if (workNotification.isDisplayed()) {
                finishWork();
                log.info("Player at work, work finished");
            }
        } catch (Exception e) {
            log.info("Work status checked, test continues");
        }
    }

    public void goWork() {
        characterList.click();
        activityBtn.click();
        workBtn.click();
        log.info("Character started work successfully");
    }

    public void finishWork() {
        characterList.click();
        activityBtn.click();
        finishWorkBtn.click();
        log.info("Character finished work successfully");
    }
}
