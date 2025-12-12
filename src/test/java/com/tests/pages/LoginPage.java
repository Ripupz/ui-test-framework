package com.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(css= ".login-form > form:nth-child(2) > input:nth-child(2)")
    private WebElement usernameInput;

    @FindBy(css = ".login-form > form:nth-child(2) > input:nth-child(3)")
    private WebElement passwordInput;

    @FindBy(css = "button.btn:nth-child(4)")
    private WebElement loginButton;

    @FindBy(css = ".login-form > form:nth-child(2) > p:nth-child(4)")
    private WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }


    public String getErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMsg));
            return errorMsg.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }


}
