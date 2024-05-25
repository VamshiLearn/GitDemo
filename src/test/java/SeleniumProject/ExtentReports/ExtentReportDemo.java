package SeleniumProject.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent;
	
	@BeforeTest 			//Extent Reporter class will do the config for Reports
	public void config()
	{
		//Extent Reports, ExtentSparkReporter know these classes
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		//Extent Reports class is the main class which drives all execution
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vamshi");
		
	}
	
	
	@Test
	public void initialDemo()
	{
		ExtentTest test=extent.createTest("Initial Demo");  //testcaseName
		System.setProperty("webdriver.chrome.driver", "C:/Users/VAMSHI/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Launching the browser
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		test.fail("Results do not match");
		driver.close();
		extent.flush();  //Report will generate with this method else it will still wait for listeners
		
		
	}
	
}
