package com.ss.ita.rozetka.ui.ProductsEnum;

public enum GeneralProductCategories {

    NOTEBOOKS_AND_COMPUTERS("computers-notebooks']"),
    PRODUCTS_FOR_HOUSE("bt"),
    COTTAGE_GARDEN_BACKYARD("dacha-sad-ogorod");

    private final String name;

    GeneralProductCategories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
