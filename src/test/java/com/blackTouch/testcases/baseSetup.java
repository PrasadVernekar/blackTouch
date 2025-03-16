package com.blackTouch.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.blackTouch.utilities.ExtentManager;
import com.blackTouch.utilities.readConfig;

public class baseSetup {

	readConfig readconfig = new readConfig();
	public String baseURL = readconfig.getApplicationURL();

	
	public static WebDriver driver;
	 public static ExtentReports extent;
	    public static ExtentTest test;

	@Parameters("browser")
	@BeforeClass
	public void setup(String brw) throws InterruptedException {

		if (brw.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");

			options.addArguments("--disable-gpu"); 
			options.addArguments("--window-size=1920,1080");

			WebDriver driver = new ChromeDriver(options);
		} else if (brw.equals("firefox")) {
			System.setProperty("webdriver.geckodriver.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (brw.equals("IE")) {
			System.setProperty("webdriver.IEdriver.driver", readconfig.getIEPath());
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(baseURL);
		driver.manage().window().maximize();
		extent = ExtentManager.getInstance();

	}

	@AfterClass
	public static String captureScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        
       
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "ScreenShot" + File.separator + "screenshot_" + timestamp + ".png";

        File target = new File(screenshotPath);
        FileUtils.copyFile(source, target);

        return screenshotPath;
    }
	
	public void sendEmailWithAttachment(String scenario) throws EmailException {
		String hostName = "smtp.gmail.com";
		int port = 587;

		String password = "ivuvgxhcdpyjxkou";
		String senderEmail = "xyz@gmail.com";
		String recipientEmail = "abc@gmail.com";

		String subject = "Something went wrong";

		MultiPartEmail email = new MultiPartEmail();

		email.setHostName(hostName);
		email.setSmtpPort(port);
		email.setAuthenticator(new DefaultAuthenticator(senderEmail, password));
		email.setStartTLSEnabled(true);
		email.setFrom(senderEmail);
		email.addTo(recipientEmail);

		switch (scenario) {
		case "scenario1":
			subject = "Something went wrong in scenario 1";
			email.setMsg(
					"Scenario failed for Signup, then Login with valid username and password, refer screenshot for more detail.");
			break;
		case "scenario2":
			subject = "Something went wrong in scenario 2";
			email.setMsg("Scenario failed for adding product to the cart, refer screenshot for more detail.");
			break;
		case "scenario3":
			subject = "Something went wrong in scenario 3";
			email.setMsg("Scenario failed for purcharsing order, refer screenshot for more detail.");
			break;

		default:
			subject = "Something went wrong";
			email.setMsg("Unknown scenario message or internal server error.");
		}
		email.setSubject(subject);

		System.out.println("Email sent for scenario: " + scenario);

		
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("C:\\Users\\prasa\\eclipse-workspace\\blackTouch\\ScreenShot");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Refer the screenshot for more detail");
		attachment.setName("attachment_filename.jpg");

	
		email.attach(attachment);

		
		email.send();

		System.out.println("Email with attachment sent successfully.");

	}
	
	  @AfterSuite
	    public void tearDownReport() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }

}
