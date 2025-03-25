package mySeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.time.Duration;

public class HandleMultipleWindows {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {

			driver.get("https://www.linkedin.com/jobs/");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.open('https://www.naukri.com/mnjuser/homepage', '_blank');");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));

			Set<String> windowHandles = driver.getWindowHandles();

			Iterator<String> iterator = windowHandles.iterator();

			String mainWindowHandle = iterator.next();
			driver.switchTo().window(mainWindowHandle);

			System.out.println("Main Window Title: " + driver.getTitle());

			String secondWindowHandle = iterator.next();
			driver.switchTo().window(secondWindowHandle);

			System.out.println("Second Window Title: " + driver.getTitle());

			try {
				driver.switchTo().frame(0);
				System.out.println("Switched to iframe");

				WebElement iframeElement = driver.findElement(By.id("hfcr"));
				iframeElement.click();

				driver.switchTo().defaultContent();
				System.out.println("Switched back to the main page");

			} catch (Exception e) {
				System.out.println("No iframe found or could not interact with iframe: " + e.getMessage());
			}

			driver.switchTo().window(mainWindowHandle);

			System.out.println("Back to Main Window Title: " + driver.getTitle());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			driver.quit();
		}
	}
}
