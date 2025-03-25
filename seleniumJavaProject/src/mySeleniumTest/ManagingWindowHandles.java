package mySeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManagingWindowHandles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
				
		String mainWH = driver.getWindowHandle();
		System.out.println("mainWH: "+mainWH);
		
		//WebElement newTabButton = driver.findElement(By.xpath("//a[@target='_blank']"));
		//newTabButton.click();	

	}

}
