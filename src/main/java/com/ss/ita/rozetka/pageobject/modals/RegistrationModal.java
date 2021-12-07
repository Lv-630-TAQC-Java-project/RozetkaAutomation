package com.ss.ita.rozetka.pageobject.modals;

import com.ss.ita.rozetka.pageobject.elements.Header;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationModal {
    public Header close() {
        $("button.modal__close > svg").click();
        return new Header();
    }

    public RegistrationModal setName(String name) {
        $("input#registerUserName").sendKeys(name);
        return this;
    }

    public RegistrationModal setSurname(String surname) {
        $("input#registerUserSurname").sendKeys(surname);
        return this;
    }

    public RegistrationModal setPhoneNumber(String phoneNumber) {
        $("input#registerUserPhone").sendKeys(phoneNumber);
        return this;
    }

    public RegistrationModal setEmail(String email) {
        $("input#registerUserEmail").sendKeys(email);
        return this;
    }

    public RegistrationModal setPassword(String password) {
        $("input#registerUserPassword").sendKeys(password);
        return this;
    }

    public boolean isNameErrorMessageDisplayed() {
        return $("div.form__row:nth-child(1)>form-error>p").isDisplayed();
    }

    public boolean isSurnameErrorMessageDisplayed() {
        return $("div.form__row.js-surname>form-error>p").isDisplayed();
    }

    public boolean isPhoneNumberErrorMessageDisplayed() {
        return $("div.form__row:nth-child(3)>form-error>p").isDisplayed();
    }

    public boolean isEmailErrorMessageDisplayed() {
        return $("div.form__row:nth-child(4)>form-error>p").isDisplayed();
    }

    public RegistrationModal confirmRegistration() {
        $("button--large button").click();
        return this;
    }
}
