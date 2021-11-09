package com.ss.ita.rozetka.ui.pages;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductCategoryPage extends Header {

    private static final String PRODUCT_CATEGORY_OR_SUBCATEGORY_TEMPLATE = "//a[contains(@href,'%s')]";

    public ProductTypePage openProductTypePage(String productCategoryOrSubCategory) {
        $x(format(PRODUCT_CATEGORY_OR_SUBCATEGORY_TEMPLATE, productCategoryOrSubCategory)).click();
        return new ProductTypePage();
    }
}

