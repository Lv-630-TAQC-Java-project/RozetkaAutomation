package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RegistrationFunctionalityTest extends TestRunner {

    @Test
    @Description("Verify that system does not allow to register new user with invalid data")
    @TmsLink(value = "LVTAQC630-46")
    public void verifyUserCantRegisterWithInvalidData() {
        var header = new HomePage()
                .open()
                .getHeader()
                .openLoginModal()
                .openRegistrationModal();

        header
                .setName("Test Name")
                .setSurname("Test Surname")
                .setPhoneNumber("09312345")
                .setEmail("Test Email")
                .confirmRegistration();

        assertThat(header.isNameErrorMessageDisplayed())
                .as("Error message should be displayed")
                .isTrue();

        assertThat(header.isSurnameErrorMessageDisplayed())
                .as("Error message should be displayed")
                .isTrue();

        assertThat(header.isPhoneNumberErrorMessageDisplayed())
                .as("Error message should be displayed")
                .isTrue();

        assertThat(header.isEmailErrorMessageDisplayed())
                .as("Error message should be displayed")
                .isTrue();
    }
}
