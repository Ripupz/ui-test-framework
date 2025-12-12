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
            WebDriverManager.firefoxdriver().setup();

            // firefox options
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--width=1280");
            options.addArguments("--height=720");


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
