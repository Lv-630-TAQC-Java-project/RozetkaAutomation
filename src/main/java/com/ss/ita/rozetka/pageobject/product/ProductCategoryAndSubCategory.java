package com.ss.ita.rozetka.pageobject.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.lang.String.format;

@RequiredArgsConstructor
public enum ProductCategoryAndSubCategory {

    NOTEBOOKS_CATEGORY("c80004"),
    GARDEN_TECH_CATEGORY("garden_tech"),
    GARDEN_EQUIP_CATEGORY("sadoviy-inventar"),
    BIG_HOUSEHOLD_APPLIANCES_CATEGORY("bigbt"),
    KITCHEN_APPLIANCES_CATEGORY("tehnika-dlya-kuhni"),
    TRIMMERS_SUBCATEGORY("trimmers"),
    BOOKS_CATEGORY("komiksi");

    @Getter
    private final String name;

    public String toString() {
        return format(this.name() + "(%s)", this.getName());//the same
    }
}