package com.ss.ita.rozetka.pageobject.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FilterStack {
    private static final String DATA_FILTER_TEMPLATE_FOR_NAME = "//rz-filter-stack/div[@data-filter-name='%s']";
    private static final By MIN_PRICE_FIELD_LOCATOR = By.xpath("//rz-filter-stack//input[@formcontrolname='min']");
    private static final By MAX_PRICE_FIELD_LOCATOR = By.xpath("//rz-filter-stack//input[@formcontrolname='max']");
    private static final By PRICE_OK_BUTTON = By.xpath("//rz-filter-slider//fieldset//button");

    public Filter getFilter(String dataFilterName) {
        String dataFilterXpath = String.format(DATA_FILTER_TEMPLATE_FOR_NAME, dataFilterName);
        $x(dataFilterXpath).should(exist);
        return new Filter(dataFilterXpath);
    }

    public Filter getFilter(FilterName filterName) {
        return getFilter(filterName.getName());
    }

    public List<String> getFilterNames() {
        return $$x("//rz-filter-stack/div[contains(@class,'sidebar-block')]")
                .stream()
                .map(element -> element.getAttribute("data-filter-name"))
                .collect(Collectors.toList());
    }

    public int getMinPrice() {
        return Integer.parseInt(
                $(MIN_PRICE_FIELD_LOCATOR).getAttribute("value")
        );
    }

    public int getMaxPrice() {
        return Integer.parseInt(
                $(MAX_PRICE_FIELD_LOCATOR).getAttribute("value")
        );
    }

    public FilterStack setMinPrice(int minPrice) {
        SelenideElement minPriceField = $(MIN_PRICE_FIELD_LOCATOR);
        minPriceField.click();
        minPriceField.clear();
        minPriceField.sendKeys(String.valueOf(minPrice));
        return this;
    }

    public FilterStack setMaxPrice(int maxPrice) {
        SelenideElement minPriceField = $(MAX_PRICE_FIELD_LOCATOR);
        minPriceField.click();
        minPriceField.clear();
        minPriceField.sendKeys(String.valueOf(maxPrice));
        return this;
    }

    public boolean isPriceOK(){
        return $(PRICE_OK_BUTTON).isEnabled();
    }

    public FilterStack doFilterByPrice(){
        $(PRICE_OK_BUTTON).click();
        return this;
    }

    // TODO price bounds methods

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

    private static class Filter {
        private final String dataFilterXpath;

        public Filter(String dataFilterXpath) {
            this.dataFilterXpath = dataFilterXpath;
        }

        public boolean isOpened() {
            return $x(dataFilterXpath + "//rz-filter-checkbox").is(visible);
        }

        public Filter toggleBlock() {
            $x(dataFilterXpath + "//button[contains(@class,'sidebar-block__toggle')]").click();
            return this;
        }

        public String getTitle() {
            return $x(dataFilterXpath + "//span[@class='sidebar-block__toggle-title']")
                    .text()
                    .replaceAll("\\d", "")
                    .trim();
        }

        public List<String> getOptionNames() {

            return null;
        }

        public Filter selectOption(String optionName) {
            String optionXpath = String.format(dataFilterXpath + "//input[@id='%s']/parent::a", optionName);
            $x(optionXpath).click();
            return this;
        }

        public int getOptionQuantity(String optionName) {
            String optionQuantityXpath =
                    String.format(dataFilterXpath + "//label[@for='%s']/span)", optionName);

            return Integer.parseInt(
                    $x(optionQuantityXpath)
                            .text()
                            .replaceAll("\\D", "")
            );
        }
    }
}
