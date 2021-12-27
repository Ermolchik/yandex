package tests;

import org.junit.jupiter.api.*;
import pages.AuthPage;
import pages.PostPage;
import pages.StartPage;
import static tests.Const.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthTest extends BaseTest {

    @DisplayName("Авторизация с валидными данными")
    @Test
    @Order(1)
    void authTest() {

        StartPage sp = new StartPage(driver);
        AuthPage ap = new AuthPage(driver);
        PostPage pp = new PostPage(driver);

        sp.clickMailButton();
        sp.switchPage();
        ap.inputLogin(LOGIN);
        ap.clickButtonOne();
        ap.waitInputPass();
        ap.inputPass(PASSWORD);
        ap.clickButtonOne();
        pp.waitNameAcс();

        Assertions.assertEquals(pp.nameCheck.getText(), "belarus-911");

    }

    @DisplayName("Авторизация с невалидным паролем")
    @Test
    @Order(2)
    void authTestInCorrectPass() {
        StartPage sp = new StartPage(driver);
        AuthPage at = new AuthPage(driver);

        sp.clickMailButton();
        sp.switchPage();
        at.inputLogin(LOGIN);
        at.clickButtonOne();
        at.waitInputPass();
        at.inputPass(INCORRECT_PASSWORD);
        at.clickButtonOne();
        at.waitErrorMessage();

        Assertions.assertEquals("Неверный пароль",at.errorMessage.getText());
    }
}
