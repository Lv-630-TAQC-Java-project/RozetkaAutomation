package com.ss.ita.rozetka.pageobject.pages;

import com.ss.ita.rozetka.pageobject.elements.Header;

public abstract class HeaderPage {
    protected Header header = new Header();

    public Header getHeader(){
        return header;
    }
}
