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
        Header header = new HomePage()
                .open()
                .getHeader();
        HamburgerModal sideModalMenu = header.openHamburgerModal();

        String odesa = "Одеса";

        sideModalMenu
                .startChangingCity()
                .selectCity(odesa)
                .approveChangingCityAndOpenHomePage();
        String currentCity = header
                .openHamburgerModal()
                .getCity();

        assertThat(currentCity)
                .as("currentTown should be the same like odesa")
                .isEqualTo(odesa);

        String lviv = "Львів";

        sideModalMenu
                .startChangingCity()
                .selectCity(lviv)
                .approveChangingCity(HomePage.class);
        String chosenCity = header
                .openHamburgerModal()
                .getCity();

        assertThat(chosenCity)
                .as("chosenCity should be the same like lviv")
                .isEqualTo(lviv);

        sideModalMenu
                .startChangingCity()
                .setCity(odesa)
                .approveChangingCityAndOpenHomePage();
        String revertedCity = header
                .openHamburgerModal()
                .getCity();

        assertThat(revertedCity)
                .as("revertedCity should be the same like odesa")
                .isEqualTo(odesa);
    }
}
           