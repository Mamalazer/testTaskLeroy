package ru.leroymerlin.page_objects;

import core.BaseSeleniumPage;
import org.openqa.selenium.support.PageFactory;

import static ru.leroymerlin.Urls.LEROYMERLIN;

public class MainPage extends BaseSeleniumPage {

    private final String catalogElementsXPath = "//uc-button[@class='item-name ']";
    private final String catalogButtonXpath = "//uc-catalog-button-v2";

    public MainPage() {
        driver.get(LEROYMERLIN);
        PageFactory.initElements(driver, this);
    }

        public Baths goToCatalog() {

        shadow.findElementByXPath(catalogButtonXpath).click();

        shadow.findElementsByXPath(catalogElementsXPath)
                .get(3)
                .click();

        shadow.findElementsByXPath(catalogElementsXPath)
                .get(0)
                .click();

        shadow.findElementsByXPath(catalogElementsXPath)
                .get(0)
                .click();

        return new Baths();

    }

}
