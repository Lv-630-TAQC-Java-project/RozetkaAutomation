package com.ss.ita.rozetka.pageobject.product;

import static java.lang.String.format;

public enum GeneralProductCategory {

    NOTEBOOKS_AND_COMPUTERS("computers-notebooks"),
    PRODUCTS_FOR_HOUSE("tovary-dlya-doma"),
    HOUSEHOLD_APPLIANCES("bt"),
    COTTAGE_GARDEN_BACKYARD("dacha-sad-ogorod"),
    PHONES_AND_TV_CATEGORY("telefony-tv-i-ehlektronika"),
    PLUMBING_AND_REPAIR_CATEGORY("santekhnika-i-remont");

    private final String name;

    GeneralProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return format(this.name() + "(%s)", this.getName());//method to see elements of enum with value in allure report
    }
}
