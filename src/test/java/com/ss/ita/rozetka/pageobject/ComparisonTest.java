package com.ss.ita.rozetka.pageobject;

import com.ss.ita.rozetka.pageobject.elements.Header;
import com.ss.ita.rozetka.pageobject.pages.*;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.NOTEBOOKS;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
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