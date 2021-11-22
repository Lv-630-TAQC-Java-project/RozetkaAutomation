package com.ss.ita.rozetka.pageobject.product;

import static java.lang.String.format;

public enum ProductCategoryAndSubCategory {
    NOTEBOOKS_CATEGORY("c80004"),
    GARDEN_TECH_CATEGORY("garden_tech"),
    GARDEN_EQUIP_CATEGORY("sadoviy-inventar"),
    BIG_HOUSEHOLD_APPLIANCES_CATEGORY("bigbt"),
    KITCHEN_APPLIANCES_CATEGORY("tehnika-dlya-kuhni"),
    TV_ACCESSORIES_CATEGORY("c80015"), //specific
    SPA_POOLS_CATEGORY("spa-basseyni"),

    TRIMMERS_SUBCATEGORY("trimmers");

    private final String name;

    ProductCategoryAndSubCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return format(this.name() + "(%s)", this.getName());//the same
    }
}