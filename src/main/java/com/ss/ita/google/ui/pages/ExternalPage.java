package com.ss.ita.google.ui.pages;

import org.openqa.selenium.By;
import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.driver;

public class ExternalPage {

    public boolean isPresentReloadButton() {
        return driver.findElements(By.xpath("//button[@id='reload-button']")).size() == 1 ? true : false;
    }
}
