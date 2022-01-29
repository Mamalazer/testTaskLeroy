package ru.leroymerlin.page_objects;

import core.BaseSeleniumPage;
import org.openqa.selenium.support.PageFactory;

public class Basket extends BaseSeleniumPage {

    private final String expectedArticle;
    private String articleInBasket;
    private final String articleXPath = "//layout-basket-card//span[@class='description__article']";

    public Basket(String article) {
        PageFactory.initElements(driver, this);
        expectedArticle = article;
    }

    public String getExpectedArticle() {
        return expectedArticle;
    }

    public String getArticleInBasket() {
        return articleInBasket;
    }

    public Basket compareProducts() {

        articleInBasket = shadow.findElementByXPath(articleXPath).getText();

        return this;
    }


}
