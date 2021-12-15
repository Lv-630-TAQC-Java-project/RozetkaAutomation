package com.ss.ita.rozetka.pageobject.pages;

import com.ss.ita.rozetka.pageobject.elements.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class VacancyPage {
    @Step("VacancyPage: vacancies is displayed")
    public boolean isVacanciesCatalogDisplayed(){
        return $x("//a[contains(@href,'catalog')]").isDisplayed();
    }
}
