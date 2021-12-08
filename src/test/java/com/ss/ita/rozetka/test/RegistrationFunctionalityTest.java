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
        var registrationModal = new HomePage()
                .open()
                .getHeader()
                .openLoginModal()
                .openRegistrationModal();

        registrationModal
                .setName("Test Name")
                .setSurname("Test Surname")
                .setPhoneNumber("09312345")
                .setEmail("Test Email");

        assertThat(registrationModal.isNameErrorMessageDisplayed())
                .as("Error message should be displayed")
                .isTrue();

        assertThat(registrationModal.isSurnameErrorMessageDisplayed())
                .as("Error message should be displayed")
                .isTrue();

        assertThat(registrationModal.isPhoneNumberErrorMessageDisplayed())
                .as("Error message should be displayed")
                .isTrue();

        assertThat(registrationModal.isEmailErrorMessageDisplayed())
                .as("Error message should be displayed")
                .isTrue();

        registrationModal.confirmRegistration();

        assertThat(registrationModal.isRegistrationModalIsVisible())
                .as("Registration modal should be visible")
                .isTrue();
    }
}
