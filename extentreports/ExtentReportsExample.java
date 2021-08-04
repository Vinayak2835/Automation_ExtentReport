package com.salenium.extentreports;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsExample {
	static WebDriverManager driver;
	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Google Search test"," Google Search test Description");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		test.log(Status.INFO, "Starting test case");
		driver.get("https://www.google.com/");
		test.pass("Navigate to the google");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test.pass("Entered text in search box");
		driver.findElement(By.name("btnK")).click();
		test.pass("pressed click button");
		driver.close();
		driver.quit();
		test.pass("close the browser");
		test.info("Test Completed");
		
		extent.flush();
		
	}

}
