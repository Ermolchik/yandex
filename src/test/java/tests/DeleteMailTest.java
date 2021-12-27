package tests;

import org.junit.jupiter.api.*;
import pages.AuthPage;
import pages.MailPage;
import pages.PostPage;
import pages.StartPage;
import static tests.Const.*;

class DeleteMailTest extends BaseTest {

    @DisplayName("Удаляем письмо")
    @Test
    void checkEnterPost() {
        StartPage sp = new StartPage(driver);
        AuthPage ap = new AuthPage(driver);
        PostPage pp = new PostPage(driver);
        MailPage mp = new MailPage(driver);

        sp.clickMailButton();
        sp.switchPage();
        ap.inputLogin(LOGIN);
        ap.clickButtonOne();
        ap.waitInputPass();
        ap.inputPass(PASSWORD);
        ap.clickButtonOne();
        pp.waitNameAcс();
        Assertions.assertEquals(pp.nameCheck.getText(), "belarus-911");
        pp.clickMail();
        mp.clickDeleteMail();
        mp.clickDeleteFolder();
        Assertions.assertEquals(pp.checkBoxMail.size(), 1);
    }
}