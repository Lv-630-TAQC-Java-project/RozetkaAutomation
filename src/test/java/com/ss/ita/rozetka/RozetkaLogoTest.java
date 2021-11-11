package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import static com.codeborne.selenide.WebDriverRunner.url;

import org.testng.Assert;
import  org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;

public class RozetkaLogoTest extends TestRunner {

    @Test
    public void verifyClickOnRozetkaLogoOpensHomePageLogo(){
        String actualUrl = new HomePage().open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE)
                .header
                .openHomePage()
                .header
                .getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://rozetka.com.ua/2");
    }
}
