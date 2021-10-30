package com.ss.ita.google;

import org.testng.annotations.Test;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;

public class verifyChangeNumberResultPage extends TestRunner {
	
	@Test
	public void goToResultPageByNumber() {
		SearchResultPage googleHomePage = new HomePage().doSearch("funny kitten");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
