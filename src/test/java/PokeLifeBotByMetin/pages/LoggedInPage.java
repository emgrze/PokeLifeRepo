package PokeLifeBotByMetin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInPage {

    @FindBy(id = "wyloguj")
    private WebElement logOutBtn;

    @FindBy(xpath = "//*[contains(text(), 'PA')]")
    private WebElement PAlevel;

    private WebDriver driver;

    public LoggedInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
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

        int intPA = Integer.parseInt(currentPA);
        int intMaxPA = Integer.parseInt(maxPA);
        System.out.println("PA jako int: " + intPA);

        if (intPA >= 5) {
            System.out.println("Chcecking if PA >= 5 successful");
        } else {
            System.out.println("PA < 5");
        }
        System.out.println("int max PA readed: " + intMaxPA);
    }
}
