package com.ss.ita.google.ui.pages;

//import com.ss.ita.google.ui.elements.Button;
//import com.ss.ita.google.ui.elements.Label;
//import com.ss.ita.google.ui.elements.Link;
//import com.ss.ita.google.ui.elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import static com.ss.ita.google.ui.locators.HomePageLocator.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public  HomePage setSearchTerms(String terms) {
    	WebElement input = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
    	input.click();
    	input.clear();
    	input.sendKeys(terms);
    	return this;
    }
        
    public  SearchResultPage doSearchTerms() {
    	driver.findElement(By.xpath("//center//input[@class='gNO89b'][1]")).click();
    	return new SearchResultPage(driver);
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
