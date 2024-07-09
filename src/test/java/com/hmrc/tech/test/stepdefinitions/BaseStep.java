package com.hmrc.tech.test.stepdefinitions;

import com.hmrc.tech.test.util.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.hmrc.tech.test.util.Constants.CHROME_DRIVER_PATH_KEY;

public class BaseStep {
    protected WebDriver driver;

    public void initializeWebDriver() {
        // Set the path to the specific ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", CommonUtil.getConfigValue(CHROME_DRIVER_PATH_KEY));

        // Setup Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options); // Initialize ChromeDriver with options
    }

    public void closeWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
