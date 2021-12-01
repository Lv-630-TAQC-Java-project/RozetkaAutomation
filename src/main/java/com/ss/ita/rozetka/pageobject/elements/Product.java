package com.ss.ita.rozetka.pageobject.elements;

import io.qameta.allure.Step;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.Color;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

@RequiredArgsConstructor
public class Product {

    @NonNull
    private final String xPath;
    private String promoLabelTitle;
    private String productTitle;
    private BigDecimal productOldPrice;
    private BigDecimal productPrice;
    private List<String> availableColors;
    private String availability;
    private int amountReviews;
    private String productDescription;

    @Step("Product: get product title")
    public String getTitle() {
        productTitle = $x(String.format("%s%s", xPath, "//span[@class='goods-tile__title']")).text();
        return productTitle;
    }

    @Step("Product: get promo label title")
    public String getPromoLabelTitle() {
        if($x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__label')]")).exists()){
            promoLabelTitle = $x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__label')]")).text();
        }else{
            promoLabelTitle = StringUtils.EMPTY;
        }
        return promoLabelTitle;
    }

    @Step("Product: get available colors")
    public List<String> getAvailableColors() {
        if ($$x(String.format("%s%s", xPath, "//span[@class='goods-tile__colors-content']")).first().exists()) {
            availableColors = $$x(String.format("%s%s", xPath, "//span[@class='goods-tile__colors-content']"))
                    .stream()
                    .map(element -> Color.fromString(element.getCssValue("background-color")).asHex())
                    .collect(Collectors.toList());
        } else {
            availableColors = null;
        }
        return availableColors;
    }

    @Step("Product: get product old price")
    public BigDecimal getOldPrice() {
        if($x(String.format("%s%s", xPath, "//div[contains(@class,'goods-tile__price--old')]")).exists()){
            String oldPriceString = $x(String.format("%s%s", xPath, "//div[contains(@class,'goods-tile__price--old')]"))
                    .text()
                    .replaceAll("\\D", StringUtils.EMPTY);
            productOldPrice = new BigDecimal(oldPriceString);
        }else{
            productOldPrice = BigDecimal.ZERO;
        }
        return productOldPrice;
    }

    @Step("Product: get product price")
    public BigDecimal getPrice() {
        if ($x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__price-value')]")).exists()) {
            String price = $x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__price-value')]"))
                    .text()
                    .replaceAll("\\D", StringUtils.EMPTY);
            productPrice = new BigDecimal(price);
        } else {
            productPrice = BigDecimal.ZERO;
        }
        return productPrice;
    }

    @Step("Product: get product availability")
    public String getAvailability() {
        if($x(String.format("%s%s", xPath, "//div[contains(@class,'goods-tile__availability')]")).exists()){
            availability = $x(String.format("%s%s", xPath, "//div[contains(@class,'goods-tile__availability')]")).text();
        }else{
            availability = StringUtils.EMPTY;
        }
        return availability;
    }

    @Step("Product: get amount reviews")
    public int getReviewAmount() {
        if ($x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__reviews-link')]")).exists()) {
            amountReviews = Integer.parseInt($x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__reviews-link')]"))
                    .text()
                    .replaceAll("\\D", StringUtils.EMPTY));
        } else {
            amountReviews = 0;
        }
        return amountReviews;
    }

    @Step("Product: get product description")
    public String getDescription() {
        actions().moveToElement($x(xPath)).perform();
        if ($x(String.format("%s%s", xPath, "//*[contains(@class,'goods-tile__description')]")).exists()) {
            productDescription = $x(String.format("%s%s", xPath, "//*[contains(@class,'goods-tile__description')]")).text();
        } else {
            productDescription = StringUtils.EMPTY;
        }
        return productDescription;
    }

    @Step("ProductTypePage: get status product discount price")
    public boolean isProductDiscountPriceValid() {
        return ((productOldPrice).subtract(productPrice)).compareTo(BigDecimal.valueOf(0.01)) >= 0;
    }

    @Step("ProductTypePage: get old price text color")
    public String getOldPriceTextColor() {
        return Color.fromString($x(String.format("%s%s", xPath, "//div[contains(@class,'goods-tile__price--old')]"))
                        .getCssValue("color"))
                .asHex();
    }

    @Step("ProductTypePage: get price text color")
    public String getPriceTextColor(){
        return Color.fromString($x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__price-value')]"))
                        .getCssValue("color"))
                .asHex();
    }
}
