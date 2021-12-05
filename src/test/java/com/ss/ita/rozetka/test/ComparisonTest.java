package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class ComparisonTest extends TestRunner {

    @Test
    @Description(value = "verifies that product count list size on ComparisonPage is equal to count added on productTypePage")
    @TmsLink(value = "LVTAQC630-11")
    public void verifyAddingProductToComparison() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS_CATEGORY);
        int productCount = 5;
        productTypePage.addProductCountToComparison(productCount);
        assertThat(getCurrentUrl())
                .as("Notebooks subcategory page should be opened")
                .isEqualTo("https://rozetka.com.ua/notebooks/c80004/");

        int comparisonProductListSize = productTypePage
                .getHeader()
                .openComparisonModal()
                .openComparisonPage()
                .getComparisonListSize();
        assertThat(comparisonProductListSize)
                .as("List size should be equal to count we added at the ProductTypePage")
                .isEqualTo(productCount);
    }

}
