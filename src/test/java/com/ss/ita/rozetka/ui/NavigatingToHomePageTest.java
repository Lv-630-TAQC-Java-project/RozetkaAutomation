package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;

public class NavigatingToHomePageTest extends TestRunner {

    @Test
    @Description("Verify return home page")
    @Issue("LVTAQC630-7")
    public void verifyReturnToHomePage() {
        String actualUrl = new HomePage().open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY)
                .header
                .openHomePage()
                .header
                .getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://rozetka.com.ua/");
    }
}
