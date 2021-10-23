package com.ss.ita.google.ui.locators;

import org.openqa.selenium.By;

public enum ImagesPageLocator implements BaseLocator{
    ;
    private final By path;

   ImagesPageLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
