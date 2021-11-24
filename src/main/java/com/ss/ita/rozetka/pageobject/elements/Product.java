package com.ss.ita.rozetka.pageobject.elements;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.Color;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

@RequiredArgsConstructor
public class Product {

    @NonNull
    private final String xPath;
    private String promoLabelTitle;
    private String productTitle;
    private BigDecimal oldProductPrice;
    private BigDecimal productPrice;
    private List<String> availableColors;
    private String availability;
    private int amountReviews;
    private String productDescription;


    public String getProductTitle() {
        productTitle = $x(String.format("%s%s", xPath, "//span[@class='goods-tile__title']")).text();
        return productTitle;
    }

    public String getPromoLabelTitle() {
        try {
            promoLabelTitle = $x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__label')]")).text();
        } catch (AssertionError exception) {
            promoLabelTitle = StringUtils.EMPTY;
        }
        return promoLabelTitle;
    }

    public List<String> getAvailableColors() {
        try {
            availableColors = $$x(String.format("%s%s", xPath, "//span[@class='goods-tile__colors-content']"))
                    .stream()
                    .map(element -> Color.fromString(element.getCssValue("background-color")).asHex())
                    .collect(Collectors.toList());
        } catch (AssertionError exception) {
            availableColors = null;
        }
        return availableColors;
    }

    public BigDecimal getOldProductPrice() {
        try {
            String oldPriceString = $x(String.format("%s%s", xPath, "//div[contains(@class,'goods-tile__price--old')]"))
                    .text()
                    .replaceAll("\\D", StringUtils.EMPTY);
            oldProductPrice = new BigDecimal(oldPriceString);
        } catch (AssertionError exception) {
            oldProductPrice = BigDecimal.ZERO;
        }
        return oldProductPrice;
    }

    public BigDecimal getProductPrice() {
        try {
            String price = $x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__price-value')]"))
                    .text()
                    .replaceAll("\\D", StringUtils.EMPTY);
            productPrice = new BigDecimal(price);
        } catch (AssertionError exception) {
            productPrice = BigDecimal.ZERO;
        }
        return productPrice;
    }

    public String getAvailability() {
        try {
            availability = $x(String.format("%s%s", xPath, "//div[contains(@class,'goods-tile__availability')]")).text();
        } catch (AssertionError exception) {
            availability = StringUtils.EMPTY;
        }
        return availability;
    }

    public int getAmountReviews() {
        try {
            amountReviews = Integer.parseInt($x(String.format("%s%s", xPath, "//span[contains(@class,'goods-tile__reviews-link')]"))
                    .text()
                    .replaceAll("\\D", StringUtils.EMPTY));
        } catch (AssertionError exception) {
            amountReviews = 0;
        }
        return amountReviews;
    }

    public String getProductDescription() {
        try {
            actions().moveToElement($x(xPath)).perform();
            productDescription = $x(String.format("%s%s", xPath, "//*[contains(@class,'goods-tile__description')]")).text();
        } catch (AssertionError exception) {
            productDescription = StringUtils.EMPTY;
        }
        return productDescription;
    }
}
