package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Shadow shadow;

    @BeforeEach
    public void setUo() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        shadow = new Shadow(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        try {
            shadow.setExplicitWait(6, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BaseSeleniumPage.setDriver(driver);
        BaseSeleniumPage.setWait(wait);
        BaseSeleniumPage.setShadow(shadow);

    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
