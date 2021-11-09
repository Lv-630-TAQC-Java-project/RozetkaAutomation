package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.pages.*;
import com.ss.ita.rozetka.ui.runner.TestRunnerForRozetka;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategories.*;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoriesAndSubCategories.*;

public class verifyOpeningProductPage extends TestRunnerForRozetka {

    @Test
    public void verifyOpenProductPage() {

        new HomePage()
                .openProductCategoryPage(COTTAGE_GARDEN_BACKYARD.getName())
                .openProductTypePage(GARDEN_TECH_CATEGORY.getName())
                .openProductPage(1);
    }
}
