package com.ss.ita.rozetka.pageobject.modals;

import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ChangeCityModal {

    @Step("ChangeTownModal: choose town")
    public ChangeCityModal selectTown(String town) {
        $x(format("//ul[contains(@class, 'header-location__popular')]/descendant::a[contains(text(),'%s')]", town)).click();
        return this;
    }

    @Step("ChangeTownModal: set town")
    public ChangeCityModal setTown(String town) {
        SelenideElement selenideElement = $x("//input[contains(@class, 'autocomplete')]");
        selenideElement.sendKeys(town);
        selenideElement.pressEnter();
        return this;
    }

    @Step("ChangeTownModal: approve changing town and open home page")
    public HomePage approveChangingTownAndOpenHomePage() {
        $x("//a[contains(@class, 'button_color_gray')]").click();
        return new HomePage();
    }

    //method that open different PO's
    @Step("ChangeTownModal:approve changing town")
    public <PageObject> PageObject approveChangingTown(Class<PageObject> pageObjectClass) {
        $x("//button[contains(@class, 'button_size_medium button_color_green')]").click();
        return page(pageObjectClass);
    }
}
