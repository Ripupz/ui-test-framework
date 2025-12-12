package com.tests.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {

            // setup Geckodriver automatically
            WebDriverManager.firefoxdriver().browserVersion("latest").setup();

            // firefox options
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");


            driver = new FirefoxDriver(options);

        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
