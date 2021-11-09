package com.ss.ita.rozetka.ui.pages;

import java.util.ArrayList;
import java.util.List;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends Header{
    public ComputersNotebooksPage getComputersNotebooksPage(){
         $x("(//a[@href = 'https://rozetka.com.ua/computers-notebooks/c80253/'])[2]").click();
         return new ComputersNotebooksPage();
    }

    public List<SelenideElement> getHomePageProductList(){
       return new ArrayList<>($$(".main-goods__cell.ng-star-inserted"));
    }
}
