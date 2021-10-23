package com.ss.ita.google.ui.locators;

import org.openqa.selenium.By;

public enum SearchResultPageLocator implements BaseLocator{
    ;
    private final By path;

    SearchResultPageLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
