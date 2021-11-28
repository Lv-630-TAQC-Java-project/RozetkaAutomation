package com.ss.ita.rozetka.pageobject.elements.filters;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

/**
 * Represents a general filter stack on product type page.
 * Can create Filter instances and work with price filter
 */
public class FilterStack {
    private final By minPriceFieldLocator = By.xpath("//rz-filter-stack//input[@formcontrolname='min']");
    private final By maxPriceFieldLocator = By.xpath("//rz-filter-stack//input[@formcontrolname='max']");
    private final By priceOkButtonLocator = By.xpath("//rz-filter-slider//fieldset//button");

    @Step("FilterStack: get filter with name {filterName}")
    public Filter getFilter(String filterName) {
        String filterXpath = String.format("//rz-filter-stack/div[@data-filter-name='%s']", filterName);
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
        String minPrice = $(minPriceFieldLocator).getAttribute("value");
        return Integer.parseInt(minPrice);
    }

    @Step("FilterStack: set minimum price bound to {minPrice}")
    public FilterStack setMinPrice(int minPrice) {
        SelenideElement minPriceField = $(minPriceFieldLocator);
        minPriceField.click();
        minPriceField.clear();
        minPriceField.sendKeys(String.valueOf(minPrice));
        return this;
    }

    @Step("FilterStack: get maximum price bound")
    public int getMaxPrice() {
        String maxPrice = $(maxPriceFieldLocator).getAttribute("value");
        return Integer.parseInt(maxPrice);
    }

    @Step("FilterStack: set maximum price bound to {maxPrice}")
    public FilterStack setMaxPrice(int maxPrice) {
        SelenideElement minPriceField = $(maxPriceFieldLocator);
        minPriceField.click();
        minPriceField.clear();
        minPriceField.sendKeys(String.valueOf(maxPrice));
        return this;
    }

    @Step("FilterStack: get price correctness status")
    public boolean isPriceRangeCorrect() {
        return $(priceOkButtonLocator).isEnabled();
    }

    @Step("FilterStack: submit price filter")
    public FilterStack doFilterByPrice() {
        $(priceOkButtonLocator).click();
        return this;
    }
}
