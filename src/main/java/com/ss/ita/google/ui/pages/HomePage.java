package com.ss.ita.google.ui.pages;


import static com.ss.ita.google.ui.pages.runner.TestRunner.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    public SearchResultPage doSearch(String searchText){
        return setSearchTerms(searchText).search();
    }

    public  HomePage setSearchTerms(String terms) {
    	WebElement input = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
    	input.clear();
    	input.sendKeys(terms);
    	return this;
    }
        
    public  SearchResultPage search() {
    	driver.findElement(By.xpath("//input[@class='gNO89b'][1]")).click();
    	return new SearchResultPage();
    }
    
    public HomePage changeLanguageToRu() {
        driver.findElement(By.xpath("//a[contains(text(),'русский')]")).click();
        return this;
    }

    public HomePage changeLanguageToUa() {
       driver.findElement((By.xpath("//a[contains(text(),'українська')]"))).click();
        return this;
    }
}
