package mySeleniumTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllCommandsFlipkart {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("iphone 15 pro max");
		searchBox.submit();
		
		//driver.switchTo().frame(")

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String mainPage = driver.getWindowHandle();
		System.out.println("Main page=" + mainPage);

		driver.findElement(By.xpath("//a[contains(@href, 'iphone-15-pro-max')]")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Set<String> allPages = driver.getWindowHandles();
		for (String page : allPages) {
			if (!page.equals(mainPage)) {
				driver.switchTo().window(page);
				break;

			}
		}
		System.out.println(driver.getCurrentUrl());
		List<WebElement> products = driver.findElements(By.className("_7eSDEz"));
		System.out.println(products.size());
     String screenshotDir = "C:\\Users\\Teja\\Desktop\\Scrennshots\\";
        
        
        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs();  
        }
        
        for (WebElement product : products) {
            System.out.println(product.getText());

            
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            
            File destinationFile = new File(screenshotDir + "Scrennshot_" + System.currentTimeMillis() + ".png");
            try {
                
                Files.copy(screenShot.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		}
		 //driver.quit();

	}


