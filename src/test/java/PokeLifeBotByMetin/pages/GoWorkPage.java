package PokeLifeBotByMetin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public GoWorkPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        GoWorkPage.driver = driver;
    }

    public void checkWorkStatus() {
        try {
            if (workNotification.isDisplayed()) {
                finishWork();
                System.out.println("Work finished");
            }
        } catch (Exception e) {
            System.out.println("Work status checked, test continues");
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
