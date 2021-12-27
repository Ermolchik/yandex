package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.PostPage;
import pages.StartPage;
import static tests.Const.LOGIN;
import static tests.Const.PASSWORD;

class ExitTest extends BaseTest{

    @DisplayName("Разлогин")
    @Test
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
        pp.clickIcon();
        pp.clickExit();
        Assertions.assertEquals(ap.helloMessage.getText(),"Войдите с Яндекс ID, чтобы перейти к Почте");

    }
}
