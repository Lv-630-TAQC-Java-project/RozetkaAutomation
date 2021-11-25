package com.ss.ita.rozetka.pageobject.elements.filters;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class Filter {
    private final String filterName;
    private final String filterXpath;
    private final String searchFieldXpath = "//div[@class='sidebar-search']/input";

    protected Filter(String filterName, String filterXpath) {
        this.filterName = filterName;
        this.filterXpath = filterXpath;
    }

    @Step("Filter: get options visibility status")
    public boolean isOptionsBlockVisible() {
        return $x(filterXpath + "//rz-filter-checkbox").is(visible);
    }

    @Step("Filter: toggle filter block")
    public Filter toggleFilterBlock() {
        $x(filterXpath + "//button[contains(@class,'sidebar-block__toggle')]")
                .scrollIntoView(false)
                .click();
        return this;
    }

    @Step("Filter: get filter title")
    public String getTitle() {
        return $x(filterXpath + "//span[@class='sidebar-block__toggle-title']")
                .text()
                .replaceAll("\\d", "")
                .trim();
    }

    @Step("Filter: get filter options")
    public List<String> getOptionNames() {
        return $$x(filterXpath + "//input[@class='custom-checkbox']")
                .stream()
                .map(element -> element.getAttribute("id"))
                .collect(Collectors.toList());
    }

    @Step("Filter: check option with name {optionName}")
    public Filter selectOption(String optionName) {
        String optionXpath = format(filterXpath + "//input[@id='%s']/parent::a", optionName);
        $x(optionXpath).scrollIntoView(false).click();
        return this;
    }

    @Step("Filter: get quantity of options in filter")
    public int getOptionsQuantityInFilter() {
        return Integer.parseInt(
                $x(filterXpath + "//span[contains(@class, 'sidebar-block__toggle-quantity')]").text()
        );
    }

    @Step("Filter: get products quantity that corresponds to option with name {optionName}")
    public int getProductsQuantityOfOption(String optionName) {
        String optionQuantityXpath =
                format(filterXpath + "//label[@for='%s']/span", optionName);

        return Integer.parseInt(
                $x(optionQuantityXpath)
                        .text()
                        .replaceAll("\\D", "")
                        .trim()
        );
    }

    @Step("Filter: get search field presence status")
    public boolean hasSearchField() {
        return $x(filterXpath + searchFieldXpath).is(exist);
    }

    @Step("Filter: set search term to filter options")
    public Filter searchOptions(String optionName) {
        SelenideElement field = $x(filterXpath + searchFieldXpath);
        field.clear();
        field.sendKeys(optionName);
        return this;
    }

    @Step("Filter: clear search field")
    public Filter clearSearch() {
        $x(filterXpath + "//button[contains(@class='sidebar-search__clear')]").click();
        return this;
    }

    @Step("Filter: get all selected options")
    public List<String> getSelectedOptions() {
        String selectedOptionsCssLocator =
                format("rz-filter-stack > div[data-filter-name='%s'] input:checked[type='checkbox'] ~ label", filterName);
        return $$x(selectedOptionsCssLocator).texts();
    }
}
