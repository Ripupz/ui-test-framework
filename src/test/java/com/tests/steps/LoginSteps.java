package com.tests.steps;

import com.tests.pages.LoginPage;
import com.tests.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private final String BASE_URL = "https://automationexercise.com/login";

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("I open the login page")
    public void i_open_the_login_page() {
        loginPage.open(BASE_URL);
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }


    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        String msg = loginPage.getErrorMessage();
        System.out.println("DEBUG ERROR MESSAGE = [" + msg + "]");
        Assert.assertFalse("ERROR MESSAGE WAS EMPTY!", msg.isEmpty());

    }

    @Then("I should see an error message or validation message")
    public void i_should_see_an_error_message_or_validation_message() {
        String msg = loginPage.getErrorMessage();
        System.out.println("DEBUG ERROR MESSAGE = [" + msg + "]");
        Assert.assertFalse("ERROR MESSAGE WAS EMPTY!", msg.isEmpty());

    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }


    @Then("I should see the home page")
    public void iShouldSeeTheHomePage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.startsWith("https://automationexercise.com"));
    }
}
