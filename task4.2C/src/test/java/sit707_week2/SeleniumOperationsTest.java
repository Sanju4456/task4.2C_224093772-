package sit707_week2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

class BunningsLoginTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/sanju/geckodriver-v0.34.0-win32/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testValidLogin() {
        try {
            // Navigate to the login page
            driver.get("https://www.bunnings.com.au/login");

            // Find the email and password fields and enter valid credentials
            WebElement emailField = driver.findElement(By.id("login_email"));
            emailField.sendKeys("validemail@example.com");

            WebElement passwordField = driver.findElement(By.id("login_password"));
            passwordField.sendKeys("validpassword");

            // Find and click the login button
            WebElement loginButton = driver.findElement(By.id("login_button"));
            loginButton.click();

            // Wait for the next page to load (e.g., user dashboard)
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("dashboard"));

            // Verify that the login was successful
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("dashboard"), "Login was not successful");

        } catch (Exception e) {
           
        }
    }

    @Test
    void testInvalidEmail() {
        try {
            // Navigate to the login page
            driver.get("https://www.bunnings.com.au/login");

            // Find the email and password fields and enter invalid email
            WebElement emailField = driver.findElement(By.id("login_email"));
            emailField.sendKeys("invalidemail");

            WebElement passwordField = driver.findElement(By.id("login_password"));
            passwordField.sendKeys("validpassword");

            // Find and click the login button
            WebElement loginButton = driver.findElement(By.id("login_button"));
            loginButton.click();

            // Verify error message for invalid email
            WebElement errorMessage = driver.findElement(By.className("error-message"));
            assertEquals("Invalid email error message not displayed", "Invalid email", errorMessage.getText());

        } catch (Exception e) {
           
        }
    }

    @Test
    void testInvalidPassword() {
        try {
            // Navigate to the login page
            driver.get("https://www.bunnings.com.au/login");

            // Find the email and password fields and enter valid email and invalid password
            WebElement emailField = driver.findElement(By.id("login_email"));
            emailField.sendKeys("validemail@example.com");

            WebElement passwordField = driver.findElement(By.id("login_password"));
            passwordField.sendKeys("invalidpassword");

            // Find and click the login button
            WebElement loginButton = driver.findElement(By.id("login_button"));
            loginButton.click();

            // Verify error message for invalid password
            WebElement errorMessage = driver.findElement(By.className("error-message"));
            assertEquals("Invalid password error message not displayed", "Invalid password", errorMessage.getText());

        } catch (Exception e) {
           
        }
    }

    @Test
    void testEmptyFields() {
        try {
            // Navigate to the login page
            driver.get("https://www.bunnings.com.au/login");

            // Find the email and password fields and leave them empty
            WebElement emailField = driver.findElement(By.id("login_email"));
            emailField.sendKeys("");

            WebElement passwordField = driver.findElement(By.id("login_password"));
            passwordField.sendKeys("");

            // Find and click the login button
            WebElement loginButton = driver.findElement(By.id("login_button"));
            loginButton.click();

            // Verify error message for empty fields
            WebElement errorMessage = driver.findElement(By.className("error-message"));
            assertEquals("Empty fields error message not displayed", "Please enter credentials", errorMessage.getText());

        } catch (Exception e) {
            
        }
    }
}


