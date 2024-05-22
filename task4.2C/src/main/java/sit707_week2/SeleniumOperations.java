package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumOperations {

    private WebDriver driver;
    private WebDriverWait wait;

    public SeleniumOperations() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/sanju/geckodriver-v0.34.0-win32/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void openLoginPage() {
        driver.get("https://www.bunnings.com.au/login");
    }

    public void enterCredentials(String email, String password) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_email")));
        emailField.sendKeys(email);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password")));
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login_button")));
        loginButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getErrorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errorMessage.getText();
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

	public static void bunningsLoginPage(String string, Object object, Object object2) {
		// TODO Auto-generated method stub
		
	}
}

