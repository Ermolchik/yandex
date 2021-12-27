package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static tests.Const.LOGIN;
import static tests.Const.PASSWORD;

public class AuthPage {
    private final WebDriver driver;

    @FindBy(xpath = ("//input[@data-t='field:input-login']"))
    private WebElement inputLogin;

    @FindBy(xpath = ("//input[@data-t='field:input-passwd']"))
    private WebElement inputPass;

    @FindBy(xpath = ("//img[@class='user-pic__image'][1]"))
    private WebElement inPost;

    @FindBy(xpath = "//button[@data-t='button:action:passp:sign-in']")
    private WebElement buttonOne;

    @FindBy(xpath = "//div[@id='field:input-passwd:hint']")
    public WebElement errorMessage;

    @FindBy(xpath = "//h1[@class='passp-title ']")
    public WebElement helloMessage;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Вводим логин")
    public void inputLogin(String login) {
        inputLogin.sendKeys(login);

    }

    @Step("Вводим пароль")
    public void inputPass(String pass) {
        inputPass.sendKeys(pass);

    }

    @Step("Нажимаем кнопку Войти")
    public void clickButtonOne() {
        buttonOne.click();
    }

    @Step("Ожидаем появления поля ввода пароля")
    public void waitInputPass() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(inputPass));
    }

    @Step("Авторизация на яндексе")
    public void authorisation(){
        inputLogin(LOGIN);
        clickButtonOne();
        waitInputPass();
        inputPass(PASSWORD);
        clickButtonOne();
    }

    @Step("Ожидаем errorMassage")
    public void waitErrorMessage(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(errorMessage));
    }

}
