package com.ss.ita.rozetka.ui.pages;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ProductCategoryPage extends Header {

    public ProductTypePage openProductTypePage(String productCategoryOrSubCategory) {
        $x(format("//a[contains(@href,'%s')]", productCategoryOrSubCategory)).click();
        return new ProductTypePage();
    }
}

