package com.ss.ita.rozetka.pageobject.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class VacancyPage {
    @Step("VacancyPage: vacancies is displayed")
    public boolean isVacancyCatalogDisplayed(){
        return $x("//a[contains(@href,'catalog')]").isDisplayed();
    }
}
