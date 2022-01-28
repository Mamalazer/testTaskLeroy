package core;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BaseSeleniumPage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Shadow shadow;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void setWait(WebDriverWait webDriverWait) {
        wait = webDriverWait;
    }

    public static void setShadow(Shadow shadowObj) {
        shadow = shadowObj;
    }
}
