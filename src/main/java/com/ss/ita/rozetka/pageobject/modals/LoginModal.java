package com.ss.ita.rozetka.pageobject.modals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.pageobject.elements.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginModal {

    @Step("LoginModal: close login modal")
    public Header close() {
        $x("//button[@class='modal__close ng-star-inserted']").click();
        return new Header();
    }

    @Step("LoginModal: get password visibility toogle")
    private SelenideElement getPasswordVisibilityToogle() {
        return $x("//button[@class='button_type_link form__toggle-password']");
    }

    @Step("LoginModal: set login {login}")
    public LoginModal setEmail(String login) {
        SelenideElement emailField = $x("//input[@type='email']");
        emailField.clear();
        emailField.sendKeys(login);
        getPasswordVisibilityToogle().click();
        return this;
    }

    @Step("LoginModal: set password {password}")
    public LoginModal setPassword(String password) {
        SelenideElement passwordField = $("#auth_pass");
        passwordField.clear();
        passwordField.sendKeys(password);
        getPasswordVisibilityToogle().click();
        return this;
    }

    @Step("LoginModal: check invalid login icon visibility")
    public boolean isInvalidLoginIconVisible() {
        return $x("//p[@class='error-message ng-star-inserted']").is(Condition.visible);
    }

    @Step("LoginModal: check invalid password icon visibility")
    public boolean isInvalidPasswordIconVisible() {
        return $x("(//div[@class='form__row_with_button']//input[contains(@class,'ng-invalid')])[last()]")
                .is(Condition.visible);
    }
}
