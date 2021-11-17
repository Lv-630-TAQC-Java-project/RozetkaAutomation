package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductCategoryPage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchFunctionalityTests extends TestRunner {

    @Test
    public void verifyXiaomiWillBeInSearchResult() {
        String searchProduct = "Xiaomi";

        ProductTypePage productTypePage = new HomePage()
                .open()
                .getHeader()
                .doSearch(searchProduct);

        assertThat(productTypePage.getProductTitle(1))
                .as("Product should have Xiaomi in title").contains(searchProduct);
    }
}
