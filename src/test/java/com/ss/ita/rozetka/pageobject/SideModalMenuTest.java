package com.ss.ita.rozetka.pageobject;

import com.ss.ita.rozetka.pageobject.modals.SideMenuModal;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import com.ss.ita.rozetka.pageobject.elements.Header;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SideModalMenuTest extends TestRunner {

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
