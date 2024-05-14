package PokeLifeBotByMetin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static PokeLifeBotByMetin.utils.TestLogger.log;

public class LoggedInPage {
    private static WebDriver driver;

    public LoggedInPage(WebDriver driver) {
        LoggedInPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "wyloguj")
    private WebElement logOutBtn;

    @FindBy(xpath = "//*[contains(text(), 'PA')]")
    private WebElement PAlevel;

    @FindBy(xpath = "(//button[text()='Zamknij'])[1]")
    private WebElement notificationBtnClose;

    @FindBy(xpath = "//div[@data-original-title='Poziom naładowania Apteczki']")
    private WebElement AidLevel;

    private int intPA;
    private int intAid;


    public boolean isUserLoggedIn() {
        try {
            logOutBtn.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void PAcheck() {
        String str = PAlevel.getText();
        String currentPA = str.substring(0, str.indexOf("/"));
        String restPA = str.substring(str.indexOf("/") + 1);
        String maxPA = restPA.substring(0, 3);
        log.info("PA left: " + currentPA + "/" + maxPA);

        intPA = Integer.parseInt(currentPA);

        if (intPA >= 5) {
            log.info("Chcecking if PA >= 5 successful");
        } else {
            log.info("PA < 5, app is closing");
        }
    }

    public int getIntPA() {
        return intPA;
    }

    public void notificationClose() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            String script = "var xpath = '(//button[text()='Zamknij'])[2]';" +
                    "var element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "if (element) element.click();";
            js.executeScript(script);
            driver.navigate().refresh();
            log.info("Notification closed");

        } catch (Exception e) {
            log.info("No notification to close");

        }
    }

    public void aidKitLevelCheck() {
        String aid = AidLevel.getText();
        String strAid = aid.substring(0, aid.indexOf("."));
        intAid = Integer.parseInt(strAid);

        if (intAid >= 15) {
            log.info("Aid level correct: " + intAid);
        } else {
            log.info("Aid kit needs refilling, opening Pokemon Center");

        }
    }

    public int getIntAid() {
        return intAid;
    }
}