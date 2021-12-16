package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.utils.Language.UA;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class VacancyTest extends TestRunner {

    @Test
    @Description("Verify vacancy catalog is displayed on VacancyPage")
    @TmsLink(value = "LVTAQC630-69")
    public void verifyVacancyCatalogDisplaying(){
        var vacancyPage = new HomePage()
                .open()
                .getHeader()
                .changeLanguage(UA)
                .openSideMenuModal()
                .openVacancyPage();

        assertThat(getCurrentUrl())
                .as("PartnershipPage should be opened")
                .isEqualTo("https://rozetka.com.ua/ua/careers/");

        assertThat(vacancyPage.isVacancyCatalogDisplayed())
                .as("Vacancy catalog should be displayed")
                .isTrue();
    }

    @Test
    @Description("Verify vacancy count decreasing after filtration")
    @TmsLink(value = "LVTAQC630-73")
    public void verifyVacancyDecreasingAfterFiltration(){
        var vacancyPage = new HomePage()
                .open()
                .getHeader()
                .changeLanguage(UA)
                .openSideMenuModal()
                .openVacancyPage();

        assertThat(getCurrentUrl())
                .as("PartnershipPage should be opened")
                .isEqualTo("https://rozetka.com.ua/ua/careers/");

        assertThat(vacancyPage.isVacancyCatalogDisplayed())
                .as("Vacancy catalog should be displayed")
                .isTrue();

        var vacancyCatalogPage = vacancyPage.openVacancyCatalogPage();

        int sizeBeforeFiltration = vacancyCatalogPage.getVacancyCount();

        vacancyCatalogPage.selectRemoteWorkFilter();

        assertThat(vacancyCatalogPage.getVacancyCount())
                .as("Vacancy list size should not be equal to size before filtration ")
                .isNotEqualTo(sizeBeforeFiltration);
    }

}
