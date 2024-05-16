package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver bunningsLoginPage(String url, String email, String password) throws IOException {
        System.setProperty("webdriver.gecko.driver", "C:/Users/sanju/geckodriver-v0.34.0-win32/geckodriver.exe");

        System.out.println("Fire up Firefox browser.");
        WebDriver driver = new FirefoxDriver();

        System.out.println("Driver info: " + driver);
        sleep(2);
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_email")));
            emailInput.sendKeys(email);

            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password")));
            passwordInput.sendKeys(password);

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login_button")));
            loginButton.click();

            // Take a screenshot after attempting login
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("./screenshot/screen.png"));

            // Return the driver for further verification in the test
            return driver;

        } catch (Exception e) {
            // Take a screenshot if there is an error
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("./screenshot/error.png"));
            driver.quit();
            throw e;
        }
    }
}

