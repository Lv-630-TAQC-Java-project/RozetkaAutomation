package com.ss.ita.rozetka.pageobject.elements.filters;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class FilterStack {
    private final By minPriceFieldXpath = By.xpath("//rz-filter-stack//input[@formcontrolname='min']");
    private final By maxPriceFieldXpath = By.xpath("//rz-filter-stack//input[@formcontrolname='max']");
    private final By priceOkButton = By.xpath("//rz-filter-slider//fieldset//button");

    @Step("FilterStack: get filter with name {filterName}")
    public Filter getFilter(String filterName) {
        String filterXpathTemplateForName = "//rz-filter-stack/div[@data-filter-name='%s']";
        String filterXpath = String.format(filterXpathTemplateForName, filterName);
        $x(filterXpath).should(exist);
        return new Filter(filterXpath);
    }

    public Filter getFilter(FilterName filterName) {
        return getFilter(filterName.getName());
    }

    @Step("FilterStack: get filter names")
    public List<String> getFilterNames() {
        return $$x("//rz-filter-stack/div[contains(@class,'sidebar-block')]")
                .stream()
                .map(element -> element.getAttribute("data-filter-name"))
                .collect(Collectors.toList());
    }

    @Step("FilterStack: get minimum price bound")
    public int getMinPrice() {
        String minPrice = $(minPriceFieldXpath).getAttribute("value");
        if (minPrice == null) {
            return 0;
        } else {
            return Integer.parseInt(minPrice);
        }
    }

    @Step("FilterStack: set minimum price bound to {minPrice}")
    public FilterStack setMinPrice(int minPrice) {
        SelenideElement minPriceField = $(minPriceFieldXpath);
        minPriceField.click();
        minPriceField.clear();
        minPriceField.sendKeys(String.valueOf(minPrice));
        return this;
    }

    @Step("FilterStack: get maximum price bound")
    public int getMaxPrice() {
        String maxPrice = $(maxPriceFieldXpath).getAttribute("value");
        if (maxPrice == null) {
            return 0;
        } else {
            return Integer.parseInt(maxPrice);
        }
    }

    @Step("FilterStack: set maximum price bound to {maxPrice}")
    public FilterStack setMaxPrice(int maxPrice) {
        SelenideElement minPriceField = $(maxPriceFieldXpath);
        minPriceField.click();
        minPriceField.clear();
        minPriceField.sendKeys(String.valueOf(maxPrice));
        return this;
    }

    @Step("FilterStack: get price correctness status")
    public boolean isPriceOK() {
        return $(priceOkButton).isEnabled();
    }

    @Step("FilterStack: submit price filter")
    public FilterStack doFilterByPrice() {
        $(priceOkButton).click();
        return this;
    }
}
