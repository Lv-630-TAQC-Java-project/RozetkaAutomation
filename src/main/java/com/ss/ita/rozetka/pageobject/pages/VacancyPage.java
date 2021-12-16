package com.ss.ita.rozetka.pageobject.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class VacancyPage {
    @Step("VacancyPage: vacancy catalog is displayed")
    public boolean isVacancyCatalogDisplayed(){
        return $x("//a[contains(@href,'catalog')]").isDisplayed();
    }
    @Step
    public VacancyCatalogPage openVacancyCatalogPage(){
        $x("//a[contains(@href,'catalog')]").click();
        return new VacancyCatalogPage();
    }

}
