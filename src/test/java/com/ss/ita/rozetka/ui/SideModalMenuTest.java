package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.Modals.SideMenuModal;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SideMenuModalTest extends TestRunner {

    @Test
    public void verifySideMenuModalOpensAndCloses() {
        Header header = new HomePage()
                .open()
                .getHeader();
        SideMenuModal menu = header.openSideMenuModal();
        assertThat(header.isSideMenuModalOpened())
                .as("Side Menu should be opened")
                .isTrue();
        menu.closeSideMenuModal();
        assertThat(header.isSideMenuModalOpened())
                .as("Side Menu should be closed")
                .isFalse();
    }
}
