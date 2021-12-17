package com.ss.ita.rozetka.pageobject.pages;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

import static com.codeborne.selenide.Selenide.*;

public class VacancyCatalogPage {

    @Step("VacancyCatalogPage: get vacancy count")
    public int getVacancyCount(){
        return Integer.parseInt($x("//span[@class='catalog__vacancies-heading--green']")
                .getText()
                .replaceAll("\\s+", StringUtils.EMPTY));
    }

    @Step("VacancyCatalogPage: select remote work filter")
    public VacancyCatalogPage selectRemoteWorkFilter(){
        $x("//label[text()]").click();
        return this;
    }

}
