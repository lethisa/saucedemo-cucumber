package saucedemo;

// Import log4j classes.
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class logout {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("user is on saucedemo login page to login")
    public void user_is_on_saucedemo_login_page_to_login() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions opt = new FirefoxOptions();
        opt.addArguments("--headless");

        driver = new FirefoxDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String loginPage = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPage, "Swag Labs");
    }

    @When("user input a username")
    public void user_input_a_username(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input a password")
    public void user_input_a_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user is on saucedemo product page")
    public void user_is_on_product_page_saucedemo() {
        driver.findElement(By.xpath("//*[contains(text(), 'Products')]"));
    }

    @When("user click burger button")
    public void user_click_burger_button() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("user click logout button")
    public void user_click_logout_button() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("user is on login page at saucedemo")
    public void user_is_on_login_page_saucedemo() {
        driver.findElement(By.className("login_logo"));
    }

    @When("user click add to cart button")
    public void user_click_add_to_cart_button() {
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    }

    @When("user click checkout button")
    public void user_click_checkout_button() {
        driver.findElement(By.id("checkout")).click();
    }


    @And("user click cart icon")
    public void user_click_cart_icon() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("user click continue")
    public void user_click_continue() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("product show at cart list")
    public void product_show_at_cart_list() {
        driver.findElement(By.className("inventory_item_name"));
    }

    @Then("checkout page displayed")
    public void checkout_page_displayed() {
        driver.findElement(By.id("finish"));
    }

    @Then("cart page displayed")
    public void cart_page_displayed() {
        driver.findElement(By.id("checkout"));
    }

    @Then("product not show at cart list")
    public void product_not_show_at_cart_list() {
        driver.findElement(By.className("inventory_item_name"));
    }

    @And("user input postal")
    public void user_input_postal(){
        driver.findElement(By.id("postal-code")).sendKeys("123456");
    }

    @And("user input Lastname")
    public void user_input_Lastname(){
        driver.findElement(By.id("first-name")).sendKeys("Rajawali");
    }

    @And("user input Firstname")
    public void user_input_Firstname(){
        driver.findElement(By.id("last-name")).sendKeys("Kembar");
    }
}
