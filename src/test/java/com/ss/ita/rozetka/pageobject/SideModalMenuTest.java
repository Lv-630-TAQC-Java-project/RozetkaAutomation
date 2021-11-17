package com.ss.ita.rozetka.pageobject;

import com.ss.ita.rozetka.pageobject.elements.Header;
import com.ss.ita.rozetka.pageobject.modals.HamburgerModal;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SideModalMenuTest extends TestRunner {

    @Test
    @Issue("LVTAQC630-28")
    public void verifyChangingTown() {
        String odessa = "Одеса";
        String lviv = "Львів";

        Header header = new HomePage()
                .open()
                .getHeader();
        HamburgerModal sideModalMenu = header.openHamburgerModal();
        sideModalMenu
                .startChangingTown()
                .selectTown(odessa)
                .approveChangingTownAndOpenHomePage();
        String currentTown = header
                .openHamburgerModal()
                .getTown();

        assertThat(currentTown).as("currentTown should be the same like odessa").isEqualTo(odessa);

        sideModalMenu
                .startChangingTown()
                .selectTown(lviv)
                .approveChangingTown(HomePage.class);
        String chosenTown = header
                .openHamburgerModal()
                .getTown();

        assertThat(chosenTown).as("chosenTown should be the same like lviv").isEqualTo(lviv);

        sideModalMenu
                .startChangingTown()
                .setTown(odessa)
                .approveChangingTownAndOpenHomePage();
        String revertedTown = header
                .openHamburgerModal()
                .getTown();

        assertThat(revertedTown).as("revertedTown should be the same like odessa").isEqualTo(odessa);
    }
}
           