package mySeleniumTest;

import java.io.File;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) {
		// Initiate the Webdriver
	      WebDriver driver = new ChromeDriver();

	      // adding implicit wait of 12 secs
	      driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

	      // URL launch and get the browser title
	      driver.get("https://www.google.com");
	      System.out.println( "Browser title obtained : " + driver.getTitle());
	      File destination = new File("google_screenshot.png");
	      //FileUtils.copyFile(screenshot, destination);
	      
	     
	      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      System.out.println("Screenshot taken and saved ");
	      driver.navigate().forward();
	      driver.navigate().back();
	      
	      // close browser
	      driver.close();

	}

}
