package com.ss.ita.google;

import com.ss.ita.google.ui.pages.ExternalPage;
import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ResultLinkTest extends TestRunner {

    @DataProvider
    public static Object[][] dpOpenResultLink() {
        return new Object[][]{{"funny kitten", 5}};
    }

    @Test(dataProvider = "dpOpenResultLink")
    public void verifyOpenResultLink(String searchTerm, int numberResultLink) {
        ExternalPage externalPage = new HomePage().doSearch(searchTerm).goToResultLink(numberResultLink);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(externalPage.isPresentReloadButton());
        softAssert.assertAll();
    }
}
