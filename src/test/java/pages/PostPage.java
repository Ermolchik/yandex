package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PostPage {
    private final WebDriver driver;

    @FindBy(xpath = "//span[@class='user-account__name']")
    public WebElement nameCheck;

    @FindBy(xpath = "//span[@class='mail-NestedList-Item-Info-Extras'][1]")
    public WebElement extractMail;

    @FindBy(xpath = "//span[@class='mail-NestedList-Item-Info-Link-Text']")
    public WebElement enterMail;

    @FindBy(xpath = "//label[@data-nb='checkbox']")
    public List<WebElement> checkBoxMail;

    @FindBy(xpath = "//span[@class='mail-Toolbar-Item-Text js-toolbar-item-title js-toolbar-item-title-delete']")
    public WebElement deleteButton;

//    @FindBy(xpath = "//span[@class='mail-NestedList-Item-Name']")

    @FindBy(xpath = "//img[@class='user-pic__image']")
    private WebElement iconLogin;

    @FindBy(xpath = "//span[text()='Выйти из сервисов Яндекса']")
    private WebElement exitButton;

    @FindBy(xpath = "//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_sender js-message-snippet-sender']")
    public List<WebElement>mails;

    private List<WebElement> folders;

    public PostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Кликаем на письмо")
    public void clickMail(){
        mails.get(2).click();
    }

    @Step("Выходим из аккаунта")
    public void clickExit() {
        exitButton.click();
    }

    @Step("Нажимаем на иконку профиля")
    public void clickIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(iconLogin));
        iconLogin.click();
    }

    @Step("Переходим в папку Удалённые")
    public void deleteFolder() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(folders.get(2)));
        folders.get(2).click();
    }

    @Step("Кликаем на кнопку удалить")
    public void clickDeleteButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
    }

    @Step("Кликаем по чек-боксу письма")
    public void clickCheckBox() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(checkBoxMail.get(5)));
        checkBoxMail.get(5).click();
    }

    @Step("Ожидаем появления имени аккаунта")
    public void waitNameAcс() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(nameCheck));
    }

    @Step("Ожидаем отображения входящих писем")
    public void waitExtractMail() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(extractMail));
    }

    @Step("Ожидаем отображения непрочитанных сообщений")
    public void waitEnterMail() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(enterMail));
    }


}
