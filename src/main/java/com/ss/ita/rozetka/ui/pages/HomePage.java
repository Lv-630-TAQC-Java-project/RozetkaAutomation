package com.ss.ita.rozetka.ui.pages;

import java.util.ArrayList;
import java.util.List;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class HomePage extends Header{

    private static final String GENERAL_PRODUCT_CATEGORY_TEMPLATE = "//div[contains(@class,'menu-wrapper_state_static')]/descendant::a[contains(@href,'%s')]";

    public List<SelenideElement> getHomePageProductList(){
       return new ArrayList<>($$(".main-goods__cell.ng-star-inserted"));
    }

    public ProductCategoryPage openProductCategoryPage(String generalProductCategory){
      $x(format(GENERAL_PRODUCT_CATEGORY_TEMPLATE,generalProductCategory)).click();
       return new ProductCategoryPage();
    }
}
