package PokeLifeBotByMetin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void loggedUser() {
        logOutBtn.isDisplayed();
    }

    public void PAcheck() {
        String str = PAlevel.getText();
        String currentPA = str.substring(0, str.indexOf("/"));
        String restPA = str.substring(str.indexOf("/") + 1);
        String maxPA = restPA.substring(0, 3);
        System.out.println("PA left: " + currentPA);
        System.out.println("Max PA: " + maxPA);

        intPA = Integer.parseInt(currentPA);
        intMaxPA = Integer.parseInt(maxPA);

        if (intPA >= 5) {
            System.out.println("Chcecking if PA >= 5 successful");
        } else {
            System.out.println("PA < 5, app is closing");
        }
    }

    public void notificationClose() {
        if (notificationBtnClose.isDisplayed()) {
            notificationBtnClose.click();
            System.out.println("Notification closed");
        }
    }
}