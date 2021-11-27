package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.modals.LoginModal;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginModalTest {
    @Test
    public void checkLoginValidationTest(){
        LoginModal loginModal = new HomePage()
                .open()
                .getHeader()
                .openLoginModal()
                .setLogin("default")
                .setPassword("");

        assertThat(loginModal.isInvalidLoginIconVisible())
                .as("as invalid login")
                .isEqualTo(true);

        assertThat(loginModal.isInvalidPasswordIconVisible())
                .as("as invalid password")
                .isEqualTo(true);

        loginModal.setLogin("test@gmail.com").setPassword("1111");
        assertThat(loginModal.isInvalidLoginIconVisible())
                .as("as valid login")
                .isEqualTo(false);

        assertThat(loginModal.isInvalidPasswordIconVisible())
                .as("as valid password")
                .isEqualTo(false);
    }
}
