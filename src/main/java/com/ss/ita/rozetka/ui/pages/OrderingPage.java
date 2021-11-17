package com.ss.ita.rozetka.ui.pages;

import static com.codeborne.selenide.Selenide.$x;

public class OrderingPage {

    public int getTotalProductsPrice(){
        return Integer.parseInt($x("//dd[@class = 'checkout-total__value checkout-total__value_size_large']").text());
    }

    public boolean isApproveOrderButtonDisplayed(){
        return $x("//input[@class = 'button button--green button--large checkout-total__submit ng-pristine ng-valid ng-touched']").isDisplayed();
    }
}
