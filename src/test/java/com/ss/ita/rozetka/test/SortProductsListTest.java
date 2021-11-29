package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.Product;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.ProductsListSortType;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortProductsListTest extends TestRunner {

    @Test
    @Description("Verify that sort by Action products list contains products which have higher old price" +
            " than price with discount and price text color is grey for old price, red for price with discount")
    @Issue("LVTAQC630-33")
    public void verifyActionSorting() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.SMARTPHONE_TV_ELECTRONICS)
                .openProductTypePage(ProductCategoryAndSubCategory.MOBILE_PHONES_CATEGORY)
                .sortProductsListBy(ProductsListSortType.ACTION);
        List<Product> promoPriceProductsList = productTypePage.getActionPriceProductsList();
        for (Product promoPriceProduct : promoPriceProductsList) {
            assertThat(promoPriceProduct.isProductDiscountPriceValid())
                    .as("Price with discount must be less than price without discount")
                    .isTrue();
            assertThat(promoPriceProduct.getOldPriceTextColor())
                    .as("Price color text must be grey: #797878")
                    .isEqualTo("#797878");
            assertThat(promoPriceProduct.getPriceTextColor())
                    .as("Price color text must be red: #f84147")
                    .isEqualTo("#f84147");
        }
    }
}


