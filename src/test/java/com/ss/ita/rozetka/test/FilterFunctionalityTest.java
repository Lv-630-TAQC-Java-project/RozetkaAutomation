package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.*;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.MONITORS_CATEGORY;
import static org.assertj.core.api.Assertions.assertThat;

public class FilterFunctionalityTest extends TestRunner {

    @Test
    public void verifyUserCanFilterProducts() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(MONITORS_CATEGORY);

        assertThat(getCurrentUrl())
                .as("Url should contain 'Monitors'")
                .contains("monitors");

        String company = "Samsung";
        String resolution = "1920x1080";

        productTypePage
                .filterProductsByParameters(company)
                .filterProductsByParameters(resolution);

        assertThat(productTypePage.getProductTitle(1))
                .as("Title should be Samsung")
                .contains(company);

        assertThat(productTypePage
                .openProductPage(1)
                .getProductCharacteristics())
                .as("In characteristics should be 1920 x 1080 resolution")
                .contains("1920 x 1080");
    }
}