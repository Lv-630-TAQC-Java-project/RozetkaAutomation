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
    @Test
    public void verifyXiaomiWillBeInSearchResult() {
        new HomePage().open().header.doSearch("Xiaomi");

        Assert.assertTrue(new ProductTypePage().getProductTitle(1).contains("Xiaomi"));
    }
}
