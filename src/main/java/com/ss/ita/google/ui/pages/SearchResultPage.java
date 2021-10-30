package com.ss.ita.google.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.*;

import java.util.List;

public class SearchResultPage {

    public SearchResultPage doSearch(String searchText) {
        setSearchTerms(searchText).search();
        return this;
    }

    public SearchResultPage search() {
        driver.findElement(By.xpath("//button[@class = 'Tg7LZd']")).click();
        return this;
    }

    public SearchResultPage setSearchTerms(String searchText) {
        WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchField.clear();
        searchField.sendKeys(searchText);
        return this;
    }

    public String getLinkText(int numberOfLink) {
        return getSearchedLink(numberOfLink).getText();
    }

    public SearchResultPage changeFirstLinkColor(String color){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.g>div>div>div>a>h3').style.color =" + color +";");
        return this;
    }

    public String getLinkColor(int numberOfLink) {
        return getSearchedLink(numberOfLink).getCssValue("color");
    }

    public WebElement getSearchedLink(int numberOfLink) {
        return driver.findElements(By.xpath("//div[@id='rso']//h3[contains(@class,'LC20lb')]")).get(numberOfLink);
    }

    public SearchResultPage returnHomePage() {
        driver.findElement(By.xpath("//a/img")).click();
        return this;
    }
    
	public SearchResultPage goToSearchResultPage(int numberSearchResultPage) {
		
		List<WebElement> serchResultPages = driver.findElements(By.xpath("//td")).subList(1,
				driver.findElements(By.xpath("//td")).size() - 1);
		int indexLastPage = Integer.parseInt(serchResultPages.get(serchResultPages.size() - 1).getText()) - 1;
		if (numberSearchResultPage - 1 <= indexLastPage) {
			serchResultPages.get(numberSearchResultPage - 1).click();
		}
		if (numberSearchResultPage - 1 > indexLastPage) {
			while (true) {
				String PrevLastPageText = serchResultPages.get(serchResultPages.size() - 1).getText() ;
				serchResultPages.get(indexLastPage).click();
				serchResultPages = driver.findElements(By.xpath("//td")).subList(1,
						driver.findElements(By.xpath("//td")).size() - 1);
				if (numberSearchResultPage - 1 <= indexLastPage) {
					serchResultPages.get(numberSearchResultPage - 1).click();
					break;
				}
				if(PrevLastPageText.equals(serchResultPages.get(serchResultPages.size() - 1).getText()) ) {
					break;
				}
			}
		}
		return new SearchResultPage();
	}
}
