package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.Header;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import lombok.var;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class ComparisonTest extends TestRunner {

    private ProductTypePage productTypePage;
    private final int productCount = 5;

    @BeforeMethod
    public void addingProductsToComparison() {
        productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS_CATEGORY);
        productTypePage.addProductCountToComparison(productCount);
        assertThat(getCurrentUrl())
                .as("Notebooks subcategory page should be opened")
                .isEqualTo("https://rozetka.com.ua/notebooks/c80004/");
    }


    @Test
    @Description(value = "verifies that product count list size on ComparisonPage is equal to count added on productTypePage")
    @TmsLink(value = "LVTAQC630-11")
    public void verifyAddingProductToComparison() {
        int comparisonProductListSize = productTypePage
                .getHeader()
                .openComparisonModal()
                .openComparisonPage()
                .getComparisonListSize();
        assertThat(comparisonProductListSize)
                .as("List size should be equal to count we added at the ProductTypePage")
                .isEqualTo(productCount);
    }

    @Test
    @Description(value = "verifies add more products to comparison from comparison page")
    public void verifyAddingProductsFromComparisonPage() {
        int comparisonProductListSize = productTypePage
                .getHeader()
                .openComparisonModal()
                .openComparisonPage()
                .openProductTypePage()
                .addProductCountToComparison(3)
                .getHeader()
                .openComparisonModal()
                .openComparisonPage()
                .getComparisonListSize();
        assertThat(comparisonProductListSize)
                .as("List size shouldn't be equal to count we changed")
                .isNotEqualTo(productCount);
    }

}
