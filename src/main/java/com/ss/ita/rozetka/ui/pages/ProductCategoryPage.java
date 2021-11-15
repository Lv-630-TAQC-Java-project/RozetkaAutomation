package com.ss.ita.rozetka.ui.pages;

import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductCategoryPage extends HeaderPage {

    public ProductTypePage openProductTypePage(ProductCategoryAndSubCategory categoryOrSubCategory) {
        $x(format("//div[@class='tile-cats']/child::a[contains(@href,'%s')]", categoryOrSubCategory.getName())).click();
        return new ProductTypePage();
    }
}

