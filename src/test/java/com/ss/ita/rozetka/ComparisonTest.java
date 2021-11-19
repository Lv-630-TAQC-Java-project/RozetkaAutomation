package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.NOTEBOOKS;
import static com.ss.ita.rozetka.ui.util.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class ComparisonTest {
    @Test
    public void verifyAddingProductToComparison() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS);
        assertThat(getCurrentUrl())
                .as("Notebooks subcategory page should be opened")
                .isEqualTo("https://rozetka.com.ua/notebooks/c80004/");
        Header header = productTypePage
                .openProductPage(1)
                .addProductToComparison();

        assertThat(header.getProductsForComparisonCount())
                .as("Count of comparison products should be equal to 1")
                .isEqualTo(1);
    }
}