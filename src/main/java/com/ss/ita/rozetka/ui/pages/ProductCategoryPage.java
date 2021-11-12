package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.Condition;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductCategoryPage extends HeaderPage {

    public ProductTypePage openProductTypePage(ProductCategoryAndSubCategory categoryOrSubCategory) {
        $x(format("//a[contains(@href,'%s')]", categoryOrSubCategory.getName())).shouldBe(Condition.visible).click();
      
        return new ProductTypePage();
    }
}

