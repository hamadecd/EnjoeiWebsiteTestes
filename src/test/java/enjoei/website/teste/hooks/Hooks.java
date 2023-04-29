package enjoei.website.teste.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Collections;

public class Hooks {

    private static WebDriver driver;
    private ChromeOptions options;

    @Before
    public void setupTest() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("start-maximized");
//        options.addArguments("--headless=new");
        options.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        options.addArguments("--window-size=1024,768");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

    @AfterStep
    public void tirarScreenshots(Scenario scenario){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] src = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(src, "image/png", "" + scenario.getUri());
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
