package com.ss.ita.rozetka.pageobject.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HelpCenterSearchedPage {
    @Step("HelpCenterSearchedPage: get title text")
    public String getTitleText(){
        return $x("//h1").getText();
    }
}
