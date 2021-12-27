package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MailPage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@data-key='view=toolbar-button-delete&mid=177892185281134991&layout=message&id=delete']")
    public WebElement deleteMail;

    @FindBy(xpath = "//span[text()='Удалённые']")
    public WebElement folderDelete;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Переходим в папку Удалённые")
    public void clickDeleteFolder() {
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(folderDelete));
        folderDelete.click();
    }

    @Step("Удаляем письмо")
    public void clickDeleteMail() {
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(deleteMail));
        deleteMail.click();
    }
}
