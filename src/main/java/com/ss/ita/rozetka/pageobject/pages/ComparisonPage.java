package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class ComparisonPage {
    public List<SelenideElement> getProductList() {
        return $$x("//a[@class='product__heading']")
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    public int getProductListSize() {
        return getProductList().size();
    }
}
