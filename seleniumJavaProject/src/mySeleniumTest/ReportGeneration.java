package mySeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportGeneration {

	public static void main(String[] args) {

		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Spark.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(extentSparkReporter);

		ExtentTest test = extent.createTest("My First Test", "This is a test description");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		test.pass("Navigated to google.com");

		driver.quit();

		extent.flush();
	}
}
