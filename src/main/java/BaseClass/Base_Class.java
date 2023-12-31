package BaseClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Base_Class extends PropertyReader {
	
public static RequestSpecification httprequest;
	
	@BeforeMethod
	public void basic_Details()							
	{
		//Get Base URL from config.properties
		RestAssured.baseURI = getProperty("Base_URL");		
		httprequest = RestAssured.given();
	}
	//Extent Reports
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	@BeforeMethod
	public void startTest(Method name) 
	{
		String testname = name.getName();
		extentTest = extent.startTest(testname);
	}

	@AfterMethod
	public void endTest()
	{
		extent.endTest(extentTest);
	}

	@BeforeSuite
	public void setReports()
	{
		extent = new ExtentReports("./Reports/ExtentReport.html");
	}

	@AfterMethod
	public void atestCaseResult(ITestResult result) throws IOException
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{

			extentTest.log(LogStatus.FAIL, "Test Case Failed ");
		}
		else
		{
			if (result.getStatus() == ITestResult.SUCCESS) 
			{
				extentTest.log(LogStatus.PASS, "Test case passed successfully");

			}
		}
	}

	@AfterSuite
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
	
	
	static
	{

		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "./log4j2.xml";

		Configurator.initialize(null, log4jConfigFile);
	}

	//Create a object of logger to access its functions
	public static Logger log = LogManager.getLogger(Base_Class.class);
}
