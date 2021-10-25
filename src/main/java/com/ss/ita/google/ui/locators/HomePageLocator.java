package com.ss.ita.google.ui.locators;

import org.openqa.selenium.By;

public enum HomePageLocator implements BaseLocator {
    SEARCH_BUTTON(By.xpath("//center//input[@class='gNO89b'][1]")),
    DEFAULT_SEARCH_BUTTON(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='gNO89b']")),
    I_AM_LUCKY_BUTTON(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='RNmpXc']")),
    SEARCH_TEXT_AREA(By.xpath("//input[@class='gLFyf gsfi']")),
    UA_LANGUAGE(By.xpath("//a[contains(text(),'українська')]")),
    RU_LANGUAGE(By.xpath("//a[contains(text(),'русский')]")),
    LANGUAGE_TEXT_AREA(By.cssSelector("#SIvCob")),
    GOOGLE_TITLE_IMAGE(By.xpath("/html/body/div[1]/div[2]/div/img"));


    private final By path;

    HomePageLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
