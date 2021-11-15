package com.ss.ita.rozetka.ui.ProductsEnum;

public enum ProductCategoryAndSubCategory {
    NOTEBOOKS("c80004"), //specific category
    GARDEN_TECH_CATEGORY("garden_tech"),
    GARDEN_EQUIP_CATEGORY("sadoviy-inventar"),
    TRIMMERS_SUBCATEGORY("trimmers");

    private final String name;

    ProductCategoryAndSubCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}