package com.ss.ita.google.ui.locators;

import org.openqa.selenium.By;

public enum SelectedPageLocator implements BaseLocator {
    ;

    private final By path;

    SelectedPageLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
