package redbus;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class redbusAutomaton {
	
	public static ChromeDriver driver;
	
public static void main(String[] args) throws Throwable {
	//Extent reports
	ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/extentfile/redbus.html");
	spark.config().setDocumentTitle("Red Bus!!");
	spark.config().setReportName("Book your bus using redbus");
	spark.config().setTheme(Theme.STANDARD);
	spark.config().setTimeStampFormat("dd/mm/yy HH:mm:ss");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(spark);
	
	String className = new Exception().getStackTrace()[0].getClassName();
	
	ExtentTest test = extent.createTest(className,"Inside redbus automation");
	test.assignCategory("Smoke Test");
	
	
	//Chrome launching
	test.log(Status.INFO, "Opening chrome browser!!");
	driver = new ChromeDriver();
	
	test.log(Status.INFO, "Enlarging the chrome browser");
	driver.manage().window().maximize();
	
	test.log(Status.INFO,"Intiating implicite wait");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//Navigating to Redbus application
	test.log(Status.INFO, "Navigating to Reb bud application.");
	driver.get("https://www.redbus.in/");
	
	//Instance of pom page
	bookingPom bookings = new bookingPom();
	
	test.log(Status.INFO, "Entering from location");
	bookings.getFrom("Hyderabad");
	Assert.assertTrue(bookings.hyd.isEnabled(),"Hyderabad city not selected");
	bookings.hyd.click();
	
	Thread.sleep(1000);
	
	test.log(Status.INFO, "Entering to location");
	try {
		test.log(Status.INFO, "Into try block");
		bookings.getFrom("Bengalore");
		Assert.assertTrue(bookings.ban.isEnabled(),"Bangalore city not selected");
		bookings.ban.click();
	}catch (AssertionError e) {
		test.log(Status.INFO, "Caught by catch block");
		bookings.toAddress.sendKeys("Bangalore");
		Assert.assertTrue(bookings.ban.isEnabled(),"Bangalore city not selected");
		bookings.ban.click();
	}
	
	try {
		test.log(Status.INFO, "Entered try block for date selection");
		test.log(Status.INFO, "Selecting the date of travel");
		date.date();
	} catch (AssertionError e) {
		test.log(Status.INFO, "Caught by catch block for date selection");
		test.log(Status.WARNING, "Selcting the date of travel");
		bookings.calender.click();
		date.date();
	}
	
	//Clicking on search
	test.log(Status.INFO, "Clicked on search");
	bookings.search.click();
	
	
	String expectedResult = "Hyderabad to Bangalore Bus";
	
	
	//Validating the result
	try {
	Assert.assertEquals(expectedResult, bookings.actualResult.getText());
	test.log(Status.PASS, "Test case passed");
	}catch (AssertionError e) {
		test.log(Status.FAIL, "Test case failed");
	}
	
	
	extent.flush();
	
}
}
