package mySeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration; 

public class SauceDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            
            driver.get("https://www.saucedemo.com/");
            
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-name']")));
            WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));

            
            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            loginButton.click();
            
            
            wait.until(ExpectedConditions.titleContains("Swag Labs"));
            String pageTitle = driver.getTitle();
            System.out.println("After login page title: " + pageTitle);
            
           
            driver.navigate().back();
            wait.until(ExpectedConditions.titleContains("Sauce Demo"));
            System.out.println("After navigating back, page title: " + driver.getTitle());
            
            
            driver.navigate().forward();
            wait.until(ExpectedConditions.titleContains("Swag Labs"));
            System.out.println("After navigating forward, page title: " + driver.getTitle());

        } catch (TimeoutException e) {
            System.out.println("Timeout exception occurred: " + e.getMessage());
            takeScreenshot(driver); 
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            takeScreenshot(driver); 
        } finally {
            
            driver.quit();
        }
    }

    
    public static void takeScreenshot(WebDriver driver) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destinationPath = Path.of("screenshot.png"); 
            Files.copy(screenshot.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);  
            System.out.println("Screenshot taken: screenshot.png");
        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
        }
    }
}
