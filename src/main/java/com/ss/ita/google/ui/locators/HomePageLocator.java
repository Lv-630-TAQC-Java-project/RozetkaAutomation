package com.ss.ita.google.ui.locators;

import org.openqa.selenium.By;

public enum HomePageLocator implements BaseLocator {
    SEARCH_BUTTON(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='gNO89b']")),
    I_AM_LUCKY_BUTTON(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='RNmpXc']")),
    SEARCH_TEXT_AREA(By.xpath("//input[@class='gLFyf gsfi']"));


    private final By path;

    HomePageLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
