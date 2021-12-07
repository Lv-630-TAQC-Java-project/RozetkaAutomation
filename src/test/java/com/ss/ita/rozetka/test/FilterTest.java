package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.filters.FilterName;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest extends TestRunner {
    @Test
    @Description("Verify that after selecting one filter option the amount of products that corresponds to filter is equal to quantity in filter")
    @TmsLink("LVTAQC630-50")
    public void verifyFilteredProductsAmountIsCorrect() {
        var productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY);
        var filter = productTypePage
                .getFilterSideBar()
                .getFilter(FilterName.SELLER);

        var optionName = "Rozetka";
        int expectedProductsAmount = filter.getProductsQuantityOfOption(optionName);

        filter.selectOption(optionName);
        int actualProductsAmount = productTypePage.getSelectedProductsAmount();

        assertThat(actualProductsAmount)
                .as("The amount of products that corresponds to option should be equal to selected products on page")
                .isEqualTo(expectedProductsAmount);
    }
}
