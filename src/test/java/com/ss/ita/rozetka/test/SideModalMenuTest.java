package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.Header;
import com.ss.ita.rozetka.pageobject.modals.SideMenuModal;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Issue;
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

    @Test
    @Issue("LVTAQC630-28")
    public void verifyChangingTown() {
        Header header = new HomePage()
                .open()
                .getHeader();
        SideMenuModal sideModalMenu = header.openSideMenuModal();

        String odessa = "Одеса";

        sideModalMenu
                .startChangingCity()
                .selectCity(odessa)
                .approveChangingCityAndOpenHomePage();
        String currentCity = header
                .openSideMenuModal()
                .getCity();

        assertThat(currentCity)
                .as("currentCity should be the same like odesa")
                .isEqualTo(odessa);

        String lviv = "Львів";

        sideModalMenu
                .startChangingCity()
                .selectCity(lviv)
                .approveChangingCity(HomePage.class);
        String selectedCity = header
                .openSideMenuModal()
                .getCity();

        assertThat(selectedCity)
                .as("selectedCity should be the same like lviv")
                .isEqualTo(lviv);

        sideModalMenu
                .startChangingCity()
                .setCity(odessa)
                .approveChangingCityAndOpenHomePage();
        String revertedCity = header
                .openSideMenuModal()
                .getCity();

        assertThat(revertedCity)
                .as("revertedCity should be the same like odesa")
                .isEqualTo(odessa);
    }
}
