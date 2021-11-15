package com.ss.ita.rozetka.ui.Modals;

import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.elements.Header;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfileModal {

    public Header closeProfileModal() {
        $x("//button[@class='modal__close ng-star-inserted']").click();
        return new Header();
    }

    public ProfileModal setLogin(String loginText) {
        SelenideElement input = $x("//input[@type='email']");
        input.clear();
        input.sendKeys(loginText);
        return this;
    }

    public ProfileModal setPassword(String passwordText) {
        SelenideElement input = $x("//input[@type='password']");
        input.clear();
        input.sendKeys(passwordText);
        return this;
    }

    public Header clickOnApproveLoginButton(){
        $("button button--large").click();
        return new Header();
    }

    public Header login(String loginText,String passwordText){
        return  setLogin(loginText)
                .setPassword(passwordText)
                .clickOnApproveLoginButton();
    }
}
