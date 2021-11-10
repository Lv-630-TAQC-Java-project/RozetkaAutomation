package com.ss.ita.rozetka.rozetka;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import org.testng.Assert;
import  org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.GARDEN_TECH_CATEGORY;

public class clickRozetkaLogoTest {

    @Test
    public void verifyClickRozetkaLogo(){
        String actualUrl = new HomePage().open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE.getName())
                .openHomePage()
                .getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://rozetka.com.ua/");
    }
}
