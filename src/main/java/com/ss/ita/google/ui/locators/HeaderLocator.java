package com.ss.ita.google.ui.locators;

import org.openqa.selenium.By;

public enum HeaderLocator implements BaseLocator {

    ;
    private final By path;

    HeaderLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
