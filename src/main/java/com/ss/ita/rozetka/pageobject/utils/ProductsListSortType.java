package com.ss.ita.rozetka.pageobject.utils;

public enum ProductsListSortType {
    CHEAP_TO_EXPENSIVE("cheap to expensive", "1: cheap"),
    EXPENSIVE_TO_CHEAP("expensive to cheap", "2: expensive"),
    BY_POPULARITY("by popularity", "3: popularity"),
    BY_NOVELTY("by novelty", "4: novelty"),
    ACTION("Action", "5: action"),
    BY_RANK("by rank", "6: rank");

    private String nameForReport;
    private String xPathValue;

    ProductsListSortType(String nameForReport, String xPathValue) {
        this.nameForReport = nameForReport;
        this.xPathValue = xPathValue;
    }

    public String getXPathValue() {
        return xPathValue;
    }

    @Override
    public String toString() {
        return nameForReport;
    }
}
