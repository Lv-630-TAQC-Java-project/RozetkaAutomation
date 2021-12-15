package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.Selenide;
import com.ss.ita.rozetka.pageobject.elements.Header;
import lombok.Getter;

public abstract class HeaderPage {
    @Getter
    protected Header header = new Header();
}
