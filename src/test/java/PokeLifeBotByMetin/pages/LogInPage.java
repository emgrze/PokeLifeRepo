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

    @FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
    private WebElement loginFailedAlert;

    private static WebDriver driver;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        LogInPage.driver = driver;
    }

        public void login(String username, String password) {
        loginInput.clear();
        loginInput.sendKeys(username);
        passInput.clear();
        passInput.sendKeys(password);
        logInButton.click();
    }
//    public void login(String username, String password) {
//        try {
//            loginInput.clear();
//            loginInput.sendKeys(username);
//            passInput.clear();
//            passInput.sendKeys(password);
//            logInButton.click();
//        } catch (Exception e) {
//            Assert.assertTrue(loginFailed());{
//                throw new SkipException("Login failed");
//            }
//        }
//    }

    public boolean loginFailed() {
        try {
            return loginFailedAlert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
