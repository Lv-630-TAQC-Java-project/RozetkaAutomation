package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.OrderingPage;
import com.ss.ita.rozetka.pageobject.pages.ProductCategoryPage;
import com.ss.ita.rozetka.pageobject.pages.ProductPage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyProductTest extends TestRunner {

    @Test
    public void verifyUserCantBuyProductWithInvalidData() {
        HomePage homePage = new HomePage()
                .open()
                .getHeader()
                .changeLanguage("UA")
                .openHomePage();

        assertThat(getCurrentUrl())
                .as("Url should contain '/ua/'")
                .contains("/ua/");

        ProductCategoryPage productCategoryPage = homePage.openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS);

        ProductPage productPage = productCategoryPage
                .openProductTypePage(NOTEBOOKS_CATEGORY)
                .openProductPage(1);

        OrderingPage orderingPage = productPage
                .addProductToBasket()
                .openOrderingPage();

        orderingPage.setRequiredFields("TestUserSurname", "TestUserPhone", "093123456");

        assertThat(orderingPage.getSurnameErrorMessage())
                .as("You set valid data! Should be invalid!")
                .isTrue();
        assertThat(orderingPage.getNameErrorMessage())
                .as("You set valid data! Should be invalid!")
                .isTrue();
        assertThat(orderingPage.getPhoneNumberErrorMessage())
                .as("You set valid data! Should be invalid!")
                .isTrue();

        String urlBeforeConfirmingOrder = getCurrentUrl();

        orderingPage.confirmTheOrder();

        String urlAfterConfirmingOrder = getCurrentUrl();

        assertThat(urlBeforeConfirmingOrder)
                .as("Url should be different")
                .isEqualTo(urlAfterConfirmingOrder);
    }
}
