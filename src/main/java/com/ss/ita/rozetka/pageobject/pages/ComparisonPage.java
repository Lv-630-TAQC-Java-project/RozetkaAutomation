package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ComparisonPage {

    @Step("ComparisonPage: get product comparison list size")
    public int getComparisonListSize() {
        return $$x("//a[@class='product__heading']")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .size();
    }

    @Step("ComparisonModal: get add more products button")
    public ProductTypePage openProductTypePage(){
        $x("(//span[@class='comparison-settings__label'])[1]").click();
        return new ProductTypePage();
    }
}
