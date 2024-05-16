package sit707_week2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SeleniumOperationsTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/sanju/geckodriver-v0.34.0-win32/geckodriver.exe");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testStudentIdentity() {
        String studentID = "224093772";
        assertEquals("Student ID is incorrect", "224093772", studentID);
    }

    @Test
    void testStudentName() {
        String studentName = "Sanju";
        assertNotNull("Student name is null", studentName);
    }

    @Test
    void testBunningsLoginPage() {
        try {
            driver = SeleniumOperations.bunningsLoginPage("https://www.bunnings.com.au/login", 
                    "sanjunimesha40@gmail.com", "Sans44563870@#");

            // Add a wait to ensure the next page loads completely
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("account"));

            // Check if URL indicates a successful login (you need to replace this with actual post-login URL part)
            String currentUrl = driver.getCurrentUrl();
            assertEquals("Login was not successful", true, currentUrl.contains("account"));

        } catch (Exception e) {
            fail("Exception occurred during test: " + e.getMessage());
        }
    }
}


