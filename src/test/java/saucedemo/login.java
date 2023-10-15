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

public class login {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("user is on saucedemo login page")
    public void user_is_on_saucedemo_login_page() {
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

    @When("user input X as username")
    public void user_input_username_X(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input X as password")
    public void user_input_password_X(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user input Y as username")
    public void user_input_username_Y(){
        driver.findElement(By.id("user-name")).sendKeys("none");
    }

    @And("user input Y as password")
    public void user_input_password_Y(){
        driver.findElement(By.id("password")).sendKeys("none");
    }

    @And("click login button")
    public void click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user is on product page")
    public void user_is_on_product_page() {
        driver.findElement(By.xpath("//*[contains(text(), 'Products')]"));
    }

    @And("user input X as invalid password")
    public void user_input_as_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauces");
    }

    @Then("user get error messages")
    public void user_get_error_messages() {
        driver.findElement(By.xpath("//*[contains(text(), 'Username and password do not match')]"));
    }

}
