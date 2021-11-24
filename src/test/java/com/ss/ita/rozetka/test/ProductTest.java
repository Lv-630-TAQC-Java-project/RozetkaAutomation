package com.ss.ita.rozetka.test;

import com.codeborne.selenide.WebDriverRunner;
import com.ss.ita.rozetka.pageobject.elements.Product;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;

import java.util.List;

public class ProductTest extends TestRunner {

    @Test
    public void verifyProductClass() {
        Product productItem = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.SMARTPHONE_TV_ELECTRONICS)
                .openProductTypePage(ProductCategoryAndSubCategory.MOBILE_PHONES_CATEGORY)
                .getProduct(7);
        System.out.println("product title - " + productItem.getProductTitle());
        System.out.println("product promo label title - " + productItem.getPromoLabelTitle());
        System.out.println("product old price - " + productItem.getOldProductPrice());
        System.out.println("product price - " + productItem.getProductPrice());
        System.out.println("product availability - " + productItem.getAvailability());
        System.out.println("product reviews - " + productItem.getAmountReviews());
        List<String> colors = productItem.getAvailableColors();
        System.out.println("Available colors : ");
        for(String color : colors){
            System.out.println("\t" + color);
        }
        System.out.println("product description - " + productItem.getProductDescription());

    }
    public void quit(){
        WebDriverRunner.closeWebDriver();
    }
}
