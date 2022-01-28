package ru.leroymerlin.page_objects;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Baths extends BaseSeleniumPage {

    @FindBy(xpath = "//div[@class='phytpj4_plp largeCard']")
    List<WebElement> productCards;

    @FindBy(xpath = "//a[@data-testid='button' and contains(@href, 'basket')]")
    WebElement basketButton;

    By addToBasketButton = By.xpath(".//button[@data-qa='product-cart-button']");
    By article = By.xpath(".//span[contains(text(), 'Арт')]");

    String articleText;

    public Baths() {
        PageFactory.initElements(driver, this);
    }

    public Baths addToBasket() {

        if (productCards.size() >= 5) {
            productCards.get(4)
                    .findElement(addToBasketButton)
                    .click();
            articleText = productCards.get(4)
                    .findElement(article)
                    .getText();
        } else {
            productCards.get(productCards.size() - 1)
                    .findElement(addToBasketButton)
                    .click();
            articleText = productCards.get(productCards.size() - 1)
                    .findElement(article)
                    .getText();
        }

        return this;

    }

    public Basket goToBasket() {
        basketButton.click();
        return new Basket(articleText);
    }

}
