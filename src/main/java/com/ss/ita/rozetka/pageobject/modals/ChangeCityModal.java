package com.ss.ita.rozetka.pageobject.modals;

import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ChangeCityModal {

    @Step("ChangeTownModal: choose city")
    public ChangeCityModal selectCity(String city) {
        $x(format("//ul[contains(@class, 'header-location__popular')]/descendant::a[contains(text(),'%s')]", city)).click();
        return this;
    }

    @Step("ChangeTownModal: set city")
    public ChangeCityModal setCity(String city) {
        SelenideElement selenideElement = $x("//input[contains(@class, 'autocomplete')]");
        selenideElement.sendKeys(city);
        selenideElement.pressEnter();
        return this;
    }

    @Step("ChangeTownModal: approve changing city and open home page")
    public HomePage approveChangingCityAndOpenHomePage() {
        $x("//a[contains(@class, 'button_color_gray')]").click();
        return new HomePage();
    }

    //method that open different PO's
    @Step("ChangeTownModal:approve changing city")
    public <PageObject> PageObject approveChangingCity(Class<PageObject> pageObjectClass) {
        $x("//button[contains(@class, 'button_size_medium button_color_green')]").click();
        return page(pageObjectClass);
    }
}
