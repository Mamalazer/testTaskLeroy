package ru.leroymerlin;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.leroymerlin.page_objects.Basket;
import ru.leroymerlin.page_objects.MainPage;

public class Tests extends BaseSeleniumTest {

    @Test
    @DisplayName("Товар в корзине соответствует добавленному")
    public void turnIntoCase() {

        Basket basket = new MainPage()
                .goToCatalog()
                .addToBasket()
                .goToBasket()
                .comparisonOfProducts();

        Assertions.assertEquals(basket.getExpectedArticle(), basket.getArticleInBasket(),
                "Артикул добавленого товара и товара в корзине отличается");
    }

}
