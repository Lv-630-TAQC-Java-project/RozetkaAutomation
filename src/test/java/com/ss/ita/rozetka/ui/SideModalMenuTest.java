package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.Modals.SideModalMenu;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SideModalMenuTest extends TestRunner {

    @Test
    public void verifySideModalMenuOpensAndCloses() {
        Header header = new HomePage()
                .open()
                .getHeader();
        SideModalMenu menu = header.openSideModalMenu();
        assertThat(header.isSideModalMenuOpened())
                .as("Side Menu should be opened")
                .isTrue();
        menu.closeSideModalMenu();
        assertThat(header.isSideModalMenuOpened())
                .as("Side Menu should be closed")
                .isFalse();
    }
}
