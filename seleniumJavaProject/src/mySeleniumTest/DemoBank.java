package mySeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBank {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://demo.guru99.com/V4/manager/addcustomerpage.php");
		
		
		WebElement username = driver.findElement(By.name("UserID"));
		WebElement password = driver.findElement(By.name("Password"));
		WebElement login = driver.findElement(By.name("LOGIN"));
		WebElement reset = driver.findElement(By.name("RESET"));
		
		
        Thread.sleep(2000); 
		

	}

}