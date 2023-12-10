package PokeLifeBotByMetin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

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

    private int intPA;
    private int intMaxPA;

    public int getIntPA() {
        return intPA;
    }
    private static Logger LogManager;
    private static final Logger logger = LogManager.getLogger(LoggedInPage.class);


    public boolean isUserLoggedIn() {
        try {
            logOutBtn.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//    public void loggedUser() {
//        try {
//        logOutBtn.isDisplayed();
//        } catch (Exception e) {
//            return;
//        }
//    }

    public void PAcheck() {
        String str = PAlevel.getText();
        String currentPA = str.substring(0, str.indexOf("/"));
        String restPA = str.substring(str.indexOf("/") + 1);
        String maxPA = restPA.substring(0, 3);
        logger.info("PA left: " + currentPA + "/" + maxPA);
//        System.out.println("PA left: " + currentPA + "/" + maxPA);

        intPA = Integer.parseInt(currentPA);
        intMaxPA = Integer.parseInt(maxPA);

        if (intPA >= 5) {
            logger.info("Chcecking if PA >= 5 successful");
        } else {
            logger.info("PA < 5, app is closing");
            driver.quit();
        }
    }

    public void notificationClose() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            String script = "var xpath = '(//button[text()='Zamknij'])[2]';" +
                    "var element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "if (element) element.click();";
            js.executeScript(script);
            logger.info("Notification closed");
//            System.out.println("Notification closed");
        } catch (Exception e) {
            logger.info("No notification to close");
//            System.out.println("No notification to close");
        }
    }
}

//    public void notificationClose() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click", notificationBtnClose);
//        notificationBtnClose.click();
//        System.out.println("Notification closed");
//    }

//    var xpath = "(//button[text()='Zamknij'])[1]";
//    var element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
//if (element) element.click();
//        else console.log('Element nie został znaleziony');

//    public int checkPA() throws InterruptedException {
//        Thread.sleep(1000);
//        String counterPA = numberPA.getText();
//        String[] splitPA = counterPA.split("/");
//        System.out.println("Number of PA: " + numberPA.getText());
//        return Integer.parseInt(splitPA[0]);
//    }