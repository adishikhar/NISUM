package stepdefs;



import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver;

    @Given("the user is on the login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login"); // Replace with your actual login URL
    }

    @When("the user enters valid username and password")
    public void enter_valid_credentials() {
        driver.findElement(By.id("username")).sendKeys("validuser");
        driver.findElement(By.id("password")).sendKeys("validpass");
    }

    @When("the user enters username {string} and password {string}")
    public void enter_invalid_credentials(String username, String password) {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("clicks the login button")
    public void clicks_login_button() {
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void user_redirected_to_dashboard() {
        assertTrue(driver.getCurrentUrl().contains("/dashboard"));
        driver.quit();
    }

    @Then("an error message should be displayed")
    public void error_message_displayed() {
        boolean errorVisible = driver.findElement(By.id("errorMessage")).isDisplayed();
        assertTrue(errorVisible);
        driver.quit();
    }
}

