package com.zohoAutomation.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.zohoAutomation.wrapper.CommonWrapper;

public class BaseTest {
	
	static WebDriver driver;
	static ExtentHtmlReporter report;
	static ExtentReports extent;
	static ExtentTest test;
	
	@BeforeSuite
	public void suiteSetup() {
		
		driverSetup();
		report=new ExtentHtmlReporter("extentReports.html");
		  
		extent=new ExtentReports();
		extent.attachReporter(report);
		  
		report.config().setTheme(Theme.DARK);			
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
		driver.close();
		driver=null;
	}
	
	@AfterMethod
	public void report(ITestResult result) throws Exception {
		CommonWrapper common=new CommonWrapper();
		String screenShotPath = common.takeScreenshot(driver,result.getName());
				
		if(result.getStatus()==ITestResult.SUCCESS) {
			  test.log(Status.PASS, "Test Case: "+result.getName()+" Passed");
			  test.log(Status.PASS, "Screenshot below: " + test.addScreenCaptureFromPath(screenShotPath));
		  }
		  else {
			  test.log(Status.FAIL, "Test Case "+result.getName()+" Failed");
			  test.log(Status.FAIL, "Screenshot below: " + test.addScreenCaptureFromPath(screenShotPath));
			  
		  }
	}
	
	public void Login() {
		WebElement id= driver.findElement(By.id("login_id"));
		  id.sendKeys("venkatraman01010@gmail.com");
		  
		  WebElement nxtBtn= driver.findElement(By.id("nextbtn"));
		  nxtBtn.click();
		  
		  WebElement pswd= driver.findElement(By.xpath("//input[@id='password']"));
		  pswd.click();
		  pswd.sendKeys("venkatraman54");
		  
		  WebElement signinBtn= driver.findElement(By.xpath("//button[@id='nextbtn']"));
		  signinBtn.click();
	}
	
	public void openFirstPresentation() {
		WebElement firstPresentation=driver.findElement(By.xpath("(//div[@id='zs_imgCont'])[1]"));
		firstPresentation.click();
	}
	
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		
		//driver.get("https://show.zoho.in/home/presentations/owned/name/ascending/grid");
		
		driver.get("https://www.zoho.com/show/");
		WebElement login= driver.findElement(By.linkText("LOGIN"));
		login.click();
		
		Login();
		
	}
	

}
