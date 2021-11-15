package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductCategoryPage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XiaomiSearchTest extends TestRunner {

    String searchProduct = "Xiaomi";

    @Test
    public void verifyXiaomiWillBeInSearchResult() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .getHeader()
                .doSearch(searchProduct);

        Assert.assertTrue(productTypePage.getFirstProductTitle().contains(searchProduct));
    }
}
