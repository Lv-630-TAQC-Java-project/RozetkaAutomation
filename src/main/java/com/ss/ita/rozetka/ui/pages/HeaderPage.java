package com.ss.ita.rozetka.ui.pages;

import com.ss.ita.rozetka.ui.elements.Header;

public abstract class HeaderPage {
    protected Header header = new Header();

    public Header getHeader(){
        return header;
    }
}