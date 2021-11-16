package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;


public class OpeningAngClosingCatalogTest extends TestRunner {

    @Test
    public void verifyThatCatalogOpensAndCloses(){
        Header header = new HomePage()
                .open()
                .getHeader();

        header.openCatalogModal();

        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion
                .assertThat(header
                        .isCatalogModalVisible())
                .as("Catalog modal should be visible")
                .isTrue();

        header.closeCatalogModal();
        softAssertion
                .assertThat(header
                        .isCatalogModalVisible())
                .as("Catalog modal shouldn't be visible")
                .isFalse();
        softAssertion.assertAll();
    }
}
