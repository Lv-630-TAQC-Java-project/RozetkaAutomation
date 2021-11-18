package com.ss.ita.rozetka.ui.ProductsEnum;

import static java.lang.String.format;

public enum ProductCategoryAndSubCategory {
    NOTEBOOKS("notebooks"),
    GARDEN_TECH_CATEGORY("garden_tech"),
    GARDEN_EQUIP_CATEGORY("sadoviy-inventar"),
    KITCHEN_APPLIANCES_CATEGORY("tehnika-dlya-kuhni"),


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