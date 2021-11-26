package com.ss.ita.rozetka.pageobject.elements.filters;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class Filter {
    private final String filterContainerXpath;
    private final String searchFieldXpathPostfix = "//div[@class='sidebar-search']/input";
    private final String optionXpathPostfixTemplate = "//input[@id='%s']/parent::a";

    protected Filter(String filterContainerXpath) {
        this.filterContainerXpath = filterContainerXpath;
    }

    @Step("Filter: get options visibility status")
    public boolean isOptionsBlockVisible() {
        return $x(filterContainerXpath + "//rz-filter-checkbox").is(visible);
    }

    @Step("Filter: toggle filter block")
    public Filter toggleFilterBlock() {
        $x(filterContainerXpath + "//button[contains(@class,'sidebar-block__toggle')]")
                .scrollIntoView(false)
                .click();
        return this;
    }

    @Step("Filter: get filter title")
    public String getTitle() {
        return $x(filterContainerXpath + "//span[@class='sidebar-block__toggle-title']")
                .text()
                .replaceAll("\\d", "")
                .trim();
    }

    @Step("Filter: get filter options")
    public List<String> getOptionNames() {
        return $$x(filterContainerXpath + "//input[@class='custom-checkbox']/following-sibling::label")
                .texts()
                .stream()
                .map(name -> name.replaceAll("[\\(]\\d+[\\)]", ""))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Step("Filter: select option with name {optionName}")
    public Filter selectOption(String optionName) {
        String optionXpath = format(filterContainerXpath + optionXpathPostfixTemplate, optionName);
        SelenideElement optionCheckBox = getOptionInputCheckBox(optionName);

        optionCheckBox.shouldNotBe(checked);
        $x(optionXpath)
                .scrollIntoView(false)
                .click();

        optionCheckBox.shouldBe(checked);
        return this;
    }

    @Step("Filter: unselect option with name {optionName}")
    public Filter unselectOption(String optionName) {
        String optionXpath = format(filterContainerXpath + optionXpathPostfixTemplate, optionName);
        SelenideElement optionCheckBox = getOptionInputCheckBox(optionName);

        optionCheckBox.shouldBe(checked);
        $x(optionXpath)
                .scrollIntoView(false)
                .click();

        optionCheckBox.shouldNotBe(checked);
        return this;
    }

    private SelenideElement getOptionInputCheckBox(String optionName) {
        return $x(format("//input[@id='%s']", optionName));
    }

    @Step("Filter: get quantity of options in filter")
    public int getOptionsQuantityInFilter() {
        return Integer.parseInt(
                $x(filterContainerXpath + "//span[contains(@class, 'sidebar-block__toggle-quantity')]").text()
        );
    }

    @Step("Filter: get products quantity that corresponds to option with name {optionName}")
    public int getProductsQuantityOfOption(String optionName) {
        String optionQuantityXpath =
                format(filterContainerXpath + "//label[@for='%s']/span", optionName);

        return Integer.parseInt(
                $x(optionQuantityXpath)
                        .text()
                        .replaceAll("\\D|\\s", "")
        );
    }

    @Step("Filter: get search field presence status")
    public boolean hasSearchField() {
        return $x(filterContainerXpath + searchFieldXpathPostfix).is(exist);
    }

    @Step("Filter: set search term to filter options")
    public Filter searchOptions(String optionName) {
        int optionsQuantityBeforeSearch = getAllOptions().size();
        System.out.println("optionsQuantityBeforeSearch" + optionsQuantityBeforeSearch);

        SelenideElement searchInput = $x(filterContainerXpath + searchFieldXpathPostfix);
        searchInput.sendKeys(optionName);
        searchInput.pressEnter();

        getAllOptions().shouldHave(sizeLessThan(optionsQuantityBeforeSearch));
        return this;
    }

    private ElementsCollection getAllOptions() {
        return $$x(filterContainerXpath + "//li[contains(@class, 'checkbox-filter__item')]/a");
    }

    @Step("Filter: clear search field")
    public Filter clearSearch() {
        int optionsQuantityBeforeClearing = getAllOptions().size();

        $x(filterContainerXpath + "//button[contains(@class,'sidebar-search__clear')]").click();

        getAllOptions().shouldHave(sizeGreaterThan(optionsQuantityBeforeClearing));
        return this;
    }

    @Step("Filter: get all selected options")
    public List<String> getNamesOfSelectedOptions() {
        String selectedOptionsXpath = filterContainerXpath + "//input[@type='checkbox']";
        return $$x(selectedOptionsXpath)
                .filter(checked)
                .stream()
                .map(element -> element.getAttribute("id"))
                .collect(Collectors.toList());
    }
}
