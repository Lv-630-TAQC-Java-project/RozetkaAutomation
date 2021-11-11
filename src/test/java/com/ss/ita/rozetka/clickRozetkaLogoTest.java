package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.pages.HomePage;
import org.testng.Assert;
import  org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;

public class clickRozetkaLogoTest {

    @Test
    public void verifyClickOnRozetkaLogoRedirectsToHomePageLogo(){
        String actualUrl = new HomePage().open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE.getName())
                .openHomePage()
                .getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://rozetka.com.ua/");
    }
}
