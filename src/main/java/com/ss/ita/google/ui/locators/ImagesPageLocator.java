package com.ss.ita.google.ui.locators;

import org.openqa.selenium.By;

public enum ImagesPageLocator implements BaseLocator{
    ALL_TAB(By.xpath("//a[@data-hveid='CAEQAA']")),
    LINKS_UNDER_IMAGES(By.xpath("//a[contains(@class,'VFACy')]"));
    private final By path;

   ImagesPageLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
