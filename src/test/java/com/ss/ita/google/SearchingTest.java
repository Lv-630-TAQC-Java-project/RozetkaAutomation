package com.ss.ita.google;

import org.testng.annotations.Test;
import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.runner.TestRunner;

public class SearchingTest extends TestRunner  {
	@Test
	public void searchTest() {
		SearchResultPage searchResults = new HomePage(driver).setSearchTerms("funny kitten").doSearchTerms(); 

	}
}
