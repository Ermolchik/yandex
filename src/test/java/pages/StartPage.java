package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

public class StartPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@class='home-link desk-notif-card__login-new-item desk-notif-card__login-new-item_mail home-link_black_yes']")
    public WebElement mailButton;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Нажимаем кнопку входа в почту")
    public void clickMailButton() {
        mailButton.click();
    }

    @Step("Переключаемся на новою вкладку")
    public void switchPage() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

}

