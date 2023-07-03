package PokeLifeBotByMetin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    @FindBy(name = "login")
    private WebElement loginInput;

    @FindBy(name = "haslo")
    private WebElement passInput;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement logInButton;

    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void login(String username, String password) {
        loginInput.sendKeys(username);
        passInput.sendKeys(password);
        logInButton.click();
    }
}
