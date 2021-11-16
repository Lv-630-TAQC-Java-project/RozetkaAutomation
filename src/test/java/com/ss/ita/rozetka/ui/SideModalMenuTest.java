package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.modals.HamburgerModal;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.testUtils.TestRunner;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SideModalMenuTest extends TestRunner {

    @Test
    @Issue("LVTAQC630-28")
    public void verifyChangingTown() {
        String town1 = "Одеса";
        String town2 = "Львів";

        Header header = new HomePage()
                .open()
                .getHeader();
        HamburgerModal hamburgerModal = header.openHamburgerModal();
        hamburgerModal
                .openChangeTownModal()
                .chooseTown(town1)
                .approveChangingTownAndOpenHomePage();
        String currentTown = header
                .openHamburgerModal()
                .getTown();

        assertThat(currentTown == town1).as("currentTown should be the same like town1");

        hamburgerModal
                .openChangeTownModal()
                .chooseTown(town2)
                .approveChangingTown(HomePage.class);
        String chosenTown = header
                .openHamburgerModal()
                .getTown();

        assertThat(chosenTown == town2).as("chosenTown should be the same like town2");

        hamburgerModal
                .openChangeTownModal()
                .setTown(town1)
                .approveChangingTownAndOpenHomePage();
        String revertedTown = header
                .openHamburgerModal()
                .getTown();

        assertThat(revertedTown == town1).as("revertedTown should be the same like town1");
    }
}
           