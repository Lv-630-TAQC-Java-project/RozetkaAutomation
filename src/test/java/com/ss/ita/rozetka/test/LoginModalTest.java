package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.modals.LoginModal;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginModalTest {
    @Test
    public void verifyLoginValidationTest() {
        LoginModal loginModal = new HomePage()
                .open()
                .getHeader()
                .openLoginModal()
                .setLogin("default")
                .setPassword(StringUtils.EMPTY);

        assertThat(loginModal.getVisibilityStatusOfInvalidLoginIcon())
                .as("visibility of invalid login icon should be equal true")
                .isEqualTo(true);

        assertThat(loginModal.getVisibilityStatusOfInvalidPasswordIcon())
                .as("visibility of invalid password icon should be equal true")
                .isEqualTo(true);

        loginModal.setLogin("test@gmail.com").setPassword("1111");
        assertThat(loginModal.getVisibilityStatusOfInvalidLoginIcon())
                .as("visibility of invalid login icon should be equal false")
                .isEqualTo(false);

        assertThat(loginModal.getVisibilityStatusOfInvalidPasswordIcon())
                .as("visibility of invalid password icon should be equal false")
                .isEqualTo(false);
    }
}
