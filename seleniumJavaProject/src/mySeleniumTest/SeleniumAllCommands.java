package mySeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class SeleniumAllCommands {

	public static void main(String[] args) {		        
		        
		        WebDriver driver = new ChromeDriver();
		        
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        
		        driver.get("https://demoqa.com/");
		        
		        driver.manage().window().maximize();		        
		        
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        WebElement elementsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-body'][contains(text(),'Elements')]")));
		        elementsMenu.click();
		        
		        WebElement checkboxOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Checkbox']")));
		        checkboxOption.click();

		        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='rct-checkbox']")));
		        checkbox.click();		        
		        
		        WebElement radioButtonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Radio Button']")));
		        radioButtonOption.click();

		        WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='yesRadio']")));
		        radioButton.click();		       
		        
		        WebElement droppableOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Droppable']")));
		        droppableOption.click();

		        WebElement draggable = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("draggable")));
		        WebElement droppable = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("droppable")));
		        
		        Actions actions = new Actions(driver);
		        actions.dragAndDrop(draggable, droppable).perform();		        
		        
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		        
		        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        Path path = Paths.get("screenshot.png");
		        try {
					Files.copy(screenshot.toPath(), path);
				} catch (IOException e) {
					
					e.printStackTrace();
					}
		        System.out.println("Screenshot saved to: " + path.toString());
		        
		        driver.quit();
		    }
		


	}


