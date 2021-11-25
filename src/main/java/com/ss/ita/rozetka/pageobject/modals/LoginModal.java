package com.ss.ita.rozetka.pageobject.modals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.pageobject.elements.Header;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginModal {

    public Header closeLoginModal() {
        $x("//button[@class='modal__close ng-star-inserted']").click();
        return new Header();
    }

    public LoginModal setLogin(String loginText) {
        SelenideElement input = $x("//input[@type='email']");
        input.clear();
        input.sendKeys(loginText);
        return this;
    }

    public LoginModal setPassword(String passwordText) {
        SelenideElement input = $x("//input[@type='password']");
        input.clear();
        input.sendKeys(passwordText);
        return this;
    }

    private SelenideElement getApproveLoginButton(){
        return $("button button--large");
    }

    public Header login(String loginText, String passwordText){
           setLogin(loginText)
                  .setPassword(passwordText)
                  .getApproveLoginButton()
                  .click();
           return new Header();
    }

    public boolean isInvalidLoginIconVisible(){
        return $(".ng-pristine ng-invalid ng-touched").is(Condition.visible);
    }

    public boolean isInvalidPasswordIconVisible(){
        return $("ng-dirty ng-touched ng-invalid").is(Condition.visible);
    }

}
