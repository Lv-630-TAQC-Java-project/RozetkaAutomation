package com.ss.ita.rozetka.pageobject.elements.filters;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class FilterStack {
    private static final String FILTER_TEMPLATE_FOR_NAME = "//rz-filter-stack/div[@data-filter-name='%s']";
    private static final By MIN_PRICE_FIELD = By.xpath("//rz-filter-stack//input[@formcontrolname='min']");
    private static final By MAX_PRICE_FIELD = By.xpath("//rz-filter-stack//input[@formcontrolname='max']");
    private static final By PRICE_OK_BUTTON = By.xpath("//rz-filter-slider//fieldset//button");

    @Step("FilterStack: get filter with name {filterName}")
    public Filter getFilter(String filterName) {
        String filterXpath = String.format(FILTER_TEMPLATE_FOR_NAME, filterName);
        $x(filterXpath).should(exist);
        return new Filter(filterName, filterXpath);
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
        String minPrice = $(MIN_PRICE_FIELD).getAttribute("value");
        if (minPrice == null) {
            return 0;
        } else {
            return Integer.parseInt(minPrice);
        }
    }

    @Step("FilterStack: set minimum price bound to {minPrice}")
    public FilterStack setMinPrice(int minPrice) {
        SelenideElement minPriceField = $(MIN_PRICE_FIELD);
        minPriceField.click();
        minPriceField.clear();
        minPriceField.sendKeys(String.valueOf(minPrice));
        return this;
    }

    @Step("FilterStack: get maximum price bound")
    public int getMaxPrice() {
        String maxPrice = $(MAX_PRICE_FIELD).getAttribute("value");
        if (maxPrice == null) {
            return 0;
        } else {
            return Integer.parseInt(maxPrice);
        }
    }

    @Step("FilterStack: set maximum price bound to {maxPrice}")
    public FilterStack setMaxPrice(int maxPrice) {
        SelenideElement minPriceField = $(MAX_PRICE_FIELD);
        minPriceField.click();
        minPriceField.clear();
        minPriceField.sendKeys(String.valueOf(maxPrice));
        return this;
    }

    @Step("FilterStack: get price correctness status")
    public boolean isPriceOK() {
        return $(PRICE_OK_BUTTON).isEnabled();
    }

    @Step("FilterStack: submit price filter")
    public FilterStack doFilterByPrice() {
        $(PRICE_OK_BUTTON).click();
        return this;
    }

    @ToString
    @RequiredArgsConstructor
    public enum FilterName {
        SELLER("seller"),
        READY_TO_DELIVER("gotovo-k-otpravke"),
        PRODUCER("producer"),
        PRODUCING_COUNTRY("strana-proizvoditelj-tovara-90098"),
        COUNTRY_OF_BRAND_REGISTRATION("strana-registracii-brenda-87790"),
        SELL_STATUS("sell_status");

        @Getter
        private final String name;
    }
}
