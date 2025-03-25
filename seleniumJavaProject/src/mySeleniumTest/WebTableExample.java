package mySeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

	public class WebTableExample {
	    public static void main(String[] args) {
	        
	        WebDriver driver = new ChromeDriver();        
	        
	        driver.get("https://the-internet.herokuapp.com/tables");
	        
	        WebElement table = driver.findElement(By.id("table1"));
	        	        
	        List<WebElement> rows = table.findElements(By.tagName("tr"));	        
	        
	        WebElement firstRow = rows.get(1);	        
	        
	        List<WebElement> columns = firstRow.findElements(By.tagName("td"));	        
	        
	        String name = columns.get(0).getText();
	        String email = columns.get(1).getText();
	        String due = columns.get(2).getText();
	        String action = columns.get(3).getText();

	        System.out.println("First Row Data:");
	        System.out.println("Name: " + name);
	        System.out.println("Email: " + email);
	        System.out.println("Due: " + due);
	        System.out.println("Action: " + action);	        
	        
	        driver.quit();
	    }
	}



