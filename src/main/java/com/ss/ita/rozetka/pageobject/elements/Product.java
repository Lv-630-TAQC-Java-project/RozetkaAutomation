package com.ss.ita.rozetka.pageobject.elements;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.Color;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;


public class Product {
    @Getter
    private String promoLabelTitle;
    @Getter
    private String productTitle;
    @Getter
    private BigDecimal oldProductPrice;
    @Getter
    private BigDecimal productPrice;
    @Getter
    private List<String> availableColors;
    @Getter
    private String availability;
    @Getter
    private int amountReviews;
    @Getter
    private String productDescription;

    private void setProductTitle(String xPath) {
        productTitle = $x(String.format("%s%s", xPath, "//span[@class='goods-tile__title']")).text();
    }

    private void setPromoLabelTitle(String xPath) {
        try {
            promoLabelTitle = $x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__label')]")).text();
        } catch (AssertionError exception) {
            promoLabelTitle = StringUtils.EMPTY;
        }
    }

    private void setAvailableColors(String xPath) {
        try {
            availableColors = $$x(String.format("%s%s", xPath, "//span[@class='goods-tile__colors-content']"))
                    .stream()
                    .map(element -> Color.fromString(element.getCssValue("background-color")).asHex())
                    .collect(Collectors.toList());
        } catch (AssertionError exception) {
            availableColors = null;
        }
    }

    private void setOldProductPrice(String xPath) {
        try {
            String oldPriceString = $x(String.format("%s%s", xPath, "//div[contains(@class,'goods-tile__price--old')]"))
                    .text()
                    .replaceAll("\\D", StringUtils.EMPTY);
            oldProductPrice = new BigDecimal(oldPriceString);
        } catch (AssertionError exception) {
            oldProductPrice = BigDecimal.ZERO;
        }
    }

    private void setProductPrice(String xPath){
        try {
            String price = $x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__price-value')]"))
                    .text()
                    .replaceAll("\\D", StringUtils.EMPTY);
            productPrice = new BigDecimal(price);
        } catch (AssertionError exception) {
            productPrice = BigDecimal.ZERO;
        }
    }

    private void setAvailability(String xPath) {
        try {
            this.availability = $x(String.format("%s%s", xPath, "//div[contains(@class,'goods-tile__availability')]")).text();
        } catch (AssertionError exception) {
            this.availability = StringUtils.EMPTY;
        }
    }

    private void setAmountReviews(String xPath) {
        try {
            amountReviews = Integer.parseInt($x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__reviews-link')]"))
                    .text()
                    .replaceAll("\\D", StringUtils.EMPTY));
        } catch (AssertionError exception) {
            amountReviews = 0;
        }
    }

    private void setProductDescription(String xPath){
        try{
            actions().moveToElement($x(xPath)).perform();
            productDescription = $x(String.format("%s%s", xPath, "//p[contains(@class,'goods-tile__description')]")).text();
        }catch(AssertionError exception){
            productDescription = StringUtils.EMPTY;
        }
    }

    public Product(String xPath) {
        setProductTitle(xPath);
        setPromoLabelTitle(xPath);
        setOldProductPrice(xPath);
        setProductPrice(xPath);
        setAmountReviews(xPath);
        setAvailability(xPath);
        setAvailableColors(xPath);
        setProductDescription(xPath);
   }
}
