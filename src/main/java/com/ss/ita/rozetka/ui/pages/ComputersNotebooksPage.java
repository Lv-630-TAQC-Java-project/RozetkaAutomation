package com.ss.ita.rozetka.ui.pages;

import static com.codeborne.selenide.Selenide.$x;

public class ComputersNotebooksPage {

    public NotebooksPage getNotebooksPage(){
        $x("//a[@href='https://rozetka.com.ua/notebooks/c80004/']").click();
        return new NotebooksPage();
    }
}
