package com.ss.ita.google.ui.locators;

import org.openqa.selenium.By;

public enum SearchResultPageLocator implements BaseLocator{
    SEARCH_TEXT_FIELD(By.xpath("//input[contains(@class,'gLFyf gsfi')]")),
    SEARCH_BUTTON(By.xpath("//button[@class='Tg7LZd']")),
    LINKS_LIST(By.xpath("//div[@id='rso']//h3[contains(@class,'LC20lb')]")),
    IMAGES_TAB(By.xpath("//a[@data-hveid='CAEQAw']")),
    PAGE_NINE_LINK(By.xpath("//a[@aria-label = 'Page 9']"));


    private final By path;

    SearchResultPageLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
