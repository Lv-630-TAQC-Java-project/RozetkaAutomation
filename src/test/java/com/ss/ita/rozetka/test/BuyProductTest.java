package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.OrderingPage;
import com.ss.ita.rozetka.pageobject.pages.ProductCategoryPage;
import com.ss.ita.rozetka.pageobject.pages.ProductPage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyProductTest extends TestRunner {

    @Test
    @Description("Verify that system does not allow user to buy product with invalid data")
    @TmsLink(value = "LVTAQC630-38")
    public void verifyUserCantBuyProductWithInvalidData() {
        HomePage homePage = new HomePage()
                .open()
                .getHeader()
                .changeLanguage("UA")
                .openHomePage();

        assertThat(getCurrentUrl())
                .as("Url should contain '/ua/'")
                .contains("/ua/");

        ProductCategoryPage productCategoryPage = homePage.openGeneralProductCategory(NOTEBOOKS_AND_COMPUTERS);

        ProductPage productPage = productCategoryPage
                .openProductCategoryAndSubCategory(NOTEBOOKS_CATEGORY)
                .openProductPage(1);

        OrderingPage orderingPage = productPage
                .addProductToBasket()
                .openOrderingPage();

        orderingPage.setRequiredFields("TestUserSurname", "TestUserPhone", "093123456");

        assertThat(orderingPage.isSurnameErrorMessageDisplayed())
                .as("Error message should be visible")
                .isTrue();
        assertThat(orderingPage.isNameErrorMessageDisplayed())
                .as("Error message should be visible")
                .isTrue();
        assertThat(orderingPage.isPhoneNumberErrorMessageDisplayed())
                .as("Error message should be visible")
                .isTrue();

        String urlBeforeConfirmingOrder = getCurrentUrl();

        orderingPage.confirmOrdering();

        String urlAfterConfirmingOrder = getCurrentUrl();

        assertThat(urlBeforeConfirmingOrder)
                .as("Url should not be different")
                .isEqualTo(urlAfterConfirmingOrder);
    }
}
