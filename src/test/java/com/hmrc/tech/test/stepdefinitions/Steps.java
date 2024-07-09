package com.hmrc.tech.test.stepdefinitions;

import com.hmrc.tech.test.pages.LoginPage;
import com.hmrc.tech.test.pages.ProductsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseStep {
    LoginPage loginPage;
    ProductsPage productsPage;

    @Before
    public void initializeWebDriver() {
        super.initializeWebDriver();
    }

    @After
    public void closeWebDriver() {
        super.closeWebDriver();
    }

    @Given("I navigate to the SauceDemo website")
    public void iNavigateToTheSauceDemoWebsite() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I login with valid credentials")
    public void iLoginWithValidCredentials() {
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @And("I add the highest priced item to the cart")
    public void iAddTheHighestPricedItemToTheCart() {
        productsPage = new ProductsPage(driver);
        productsPage.addHighestPricedItemToCart();
    }

    @Then("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }
}
