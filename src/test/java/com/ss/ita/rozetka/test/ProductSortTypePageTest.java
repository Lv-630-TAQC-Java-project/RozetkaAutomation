package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.utils.ProductsListSortType;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.STATIONERY_AND_BOOKS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.BOOKS_CATEGORY;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductSortTypePageTest extends TestRunner {
    @Test
    @Description(value = "Opening a home page, choosing a product category and opening it, sorting the classification type ")
    @TmsLink(value = "https://jira.softserve.academy/projects/LVTAQC630/issues/LVTAQC630-31?filter=allopenissues")
    public void verifyThatProductsArePresentedInBooksCategory() {
        var productTypePage = new HomePage()
                .open()
                .openGeneralProductCategory(STATIONERY_AND_BOOKS)
                .openProductCategoryAndSubCategory(BOOKS_CATEGORY)
                .sortProductsListBy(ProductsListSortType.ACTION);


        String labelClassAction = "goods-tile__label promo-label promo-label_type_action ng-star-inserted";

        assertThat(productTypePage
                .getProduct(1)
                .getPromoLabelTitle())
                .as("Product must have tile label 'action'")
                .isEqualTo(labelClassAction);

    }
}
