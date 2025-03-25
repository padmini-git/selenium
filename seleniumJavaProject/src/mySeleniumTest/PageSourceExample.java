package mySeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageSourceExample {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.linkedin.com/feed/");

		String pageSource = driver.getPageSource();

		System.out.println(pageSource);

		driver.quit();
	}

}
