package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductCategoryPage;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;

import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;
import static com.ss.ita.rozetka.ui.util.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class NavigatingToHomePageTest extends TestRunner {

    @Test
    public void verifyReturnToHomePage() {
        ProductCategoryPage page = new HomePage()
                .open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE);
        assertThat(getCurrentUrl())
                .as("Products for house category page should be opened")
                .isEqualTo("https://bt.rozetka.com.ua/");
        page.openProductTypePage(KITCHEN_APPLIANCES_CATEGORY);
        assertThat(getCurrentUrl())
                .as("Kitchen appliances category page should be opened")
                .isEqualTo("https://bt.rozetka.com.ua/tehnika-dlya-kuhni/c435974/");
        page
                .getHeader()
                .openHomePage();
        assertThat(getCurrentUrl())
                .as("Home page should be opened")
                .isEqualTo("https://rozetka.com.ua/");
    }
}
