package com.ss.ita.rozetka.ui.modals;

import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.pages.HomePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ChangeTownModal {

    @Step("ChangeTownModal: choose town")
    public ChangeTownModal chooseTown(String town) {
        $x(format("//a[contains(text(),'%s')]", town)).click();
        return this;
    }

    @Step("ChangeTownModal: set town")
    public ChangeTownModal setTown(String town) {
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

    @Step("ChangeTownModal:approve changing town")
    public <PageObject> PageObject approveChangingTown(Class<PageObject> pageObjectClass) {
        $x("//button[contains(@class, 'button_size_medium button_color_green')]").click();
        return page(pageObjectClass);
    }
}
