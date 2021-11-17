package com.ss.ita.rozetka.ui.util;

public enum ProductsListSortType {
    FROM_CHEAP_TO_EXPENSIVE("From cheap to expensive", "1: cheap"),
    FROM_EXPENSIVE_TO_CHEAP("From expensive to cheap", "2: expensive"),
    BY_POPULARITY("By popularity", "3: popularity"),
    BY_NOVELTY("BY novelty", "4: novelty"),
    ACTION("Action", "5: action"),
    BY_RANK("BY rank", "6: rank");

    private String name;
    private String value;

    ProductsListSortType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
