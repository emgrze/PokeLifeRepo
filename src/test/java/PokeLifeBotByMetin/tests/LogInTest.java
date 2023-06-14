package PokeLifeBotByMetin.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @FindBy(name = "login")
    private WebElement loginInput;

    @FindBy(name = "haslo")
    private WebElement passInput;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement logInButton;

    @Test
    public void logInTest()  {
        PageFactory.initElements(driver,this);
        loginInput.sendKeys("lol");
        passInput.sendKeys("lol123");
        logInButton.click();
    }
}
//branch2