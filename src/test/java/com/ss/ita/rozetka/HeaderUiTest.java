package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import static com.codeborne.selenide.WebDriverRunner.url;

import org.testng.Assert;
import  org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;

public class HeaderUiTest extends TestRunner {

    @Test
    public void verifyReturnToHomePage(){
        new HomePage().open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY)
                .header
                .openHomePage();
        Assert.assertEquals(url(), "https://rozetka.com.ua/");
    }
}
