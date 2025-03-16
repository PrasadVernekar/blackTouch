package com.blackTouch.testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.blackTouch.identities.ids;
import com.blackTouch.utilities.ExtentManager;

//Test Case 1:  Verify user sign-up, log-in, and welcome message displaying the correct email ID after successful login.
//public class newTabs extends baseSetup {	

//@Test(enabled = true, priority = 1, dataProvider = "loginData") //
/*public void Login(String username, String password, String loginuser, String loginpwd) throws InterruptedException, IOException, EmailException {
baseSetup bs = new baseSetup();
	ids id = new ids(driver);
	
	id.signUp();

	id.userName(username);

	id.passWord(password);

	id.signButton();
	Thread.sleep(5000);
	org.openqa.selenium.Alert alert = driver.switchTo().alert();
	alert.accept();

	id.Close();

	id.login();

	id.loginUsername(loginuser);

	id.loginPassword(loginpwd);

	id.loginButton();
	Thread.sleep(5000);
	try {

		Assert.assertEquals(id.loginverify(), (id.loginVerify()));

		id.logOut();

	} catch (Exception e) {
		bs.captureScreenshot();
		bs.sendEmailWithAttachment("scenario1");
	}
}
@DataProvider(name = "loginData")
public Object[][] getData() {
    return new Object[][]{
    	{"qwerty1@mailinator.com", "Casio@27", "qwerty1@mailinator.com", "Casio@27"},
        
       
    };
}



// Test Case 2: Verify by adding product to the cart
@Test(dataProvider = "loginData1",enabled = true, priority = 2) //
public void addCart(String loginuser, String loginpwd) throws InterruptedException, IOException, StaleElementReferenceException, EmailException {

	ids id = new ids(driver);
	baseSetup bs = new baseSetup();

	id.login();

	id.loginUsername(loginuser);

	id.loginPassword(loginpwd);

	id.loginButton();
	Thread.sleep(5000);
	id.addCart();

	id.addToCart();
	Thread.sleep(5000);
	org.openqa.selenium.Alert alert = driver.switchTo().alert();
	alert.accept();
	id.cart();

	try {

		Assert.assertEquals(id.vCart(), (id.cVerify()));

		id.logOut();

	} catch (Exception e) {
		bs.captureScreenshot();
		bs.sendEmailWithAttachment("scenario2");
	}
}
	@DataProvider(name = "loginData1")
    public Object[][] getDataa() {
        return new Object[][]{
            {"qwerty1@mailinator.com", "Casio@27"}
           
        };

}

// Test Case 3: Verify by adding product to the cart
@Test(dataProvider = "loginData3", enabled = true, priority = 3) //
public void amountAdd(String loginuser, String loginpwd, String name, String country, String city, String card, String month, String year) throws InterruptedException, IOException, EmailException {

	ids id = new ids(driver);
	baseSetup bs = new baseSetup();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	id.login();

	id.loginUsername(loginuser);
	
	id.loginPassword(loginpwd);
	
	id.loginButton();
	

	Thread.sleep(5000);
	id.addCart();

	id.addToCart();
	Thread.sleep(5000);
	org.openqa.selenium.Alert alert = driver.switchTo().alert();
	alert.accept();
	Thread.sleep(5000);
	id.cart();

	id.placeOrder();

	id.name(name);

	id.country(country);

	id.city(city);

	id.card(card);

	id.month(month);

	id.year(year);

	id.purchase();

	try {

		Assert.assertEquals(id.thankyou(), (id.thankYou()));

		

	} catch (Exception e) {
		bs.captureScreenshot();
		bs.sendEmailWithAttachment("scenario3");
	}

}

@DataProvider(name = "loginData3")
public Object[][] getData3() {
    return new Object[][]{
        {"qwerty1@mailinator.com", "Casio@27", "Michael Scott", "USA", "California", "1234 4321 6789 9876", "March", "2025"}
       
    };*/

//}

//}
public class newTabs extends baseSetup {
	@Test(enabled = true, priority = 1, dataProvider = "loginData")
	public void Login(String username, String password, String loginuser, String loginpwd)
			throws InterruptedException, IOException, EmailException {
		ids id = new ids(driver);
		test = ExtentManager.getInstance().createTest("Login Test");

		try {
			test.log(Status.INFO, "Starting User Signup");
			id.signUp();
			id.userName(username);
			id.passWord(password);
			id.signButton();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			test.log(Status.PASS, "User Signed Up Successfully");

			id.Close();
			id.login();
			id.loginUsername(loginuser);
			id.loginPassword(loginpwd);
			id.loginButton();
			Thread.sleep(5000);

			Assert.assertEquals(id.loginverify(), id.loginVerify());
			test.log(Status.PASS, "Login Successful: " + loginuser);
			id.logOut();
		} catch (Exception e) {
			String screenshotPath = captureScreenshot();
			test.log(Status.FAIL, "Login Test Failed: " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
			throw e;
		}
	}

	@Test(dataProvider = "loginData1", enabled = true, priority = 2)
	public void addCart(String loginuser, String loginpwd) throws InterruptedException, IOException, EmailException {
		ids id = new ids(driver);
		test = ExtentManager.getInstance().createTest("Add to Cart Test");

		try {
			id.login();
			id.loginUsername(loginuser);
			id.loginPassword(loginpwd);
			id.loginButton();
			Thread.sleep(5000);

			test.log(Status.INFO, "Adding Product to Cart");
			id.addCart();
			id.addToCart();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			id.cart();

			Assert.assertEquals(id.vCart(), id.cVerify());
			test.log(Status.PASS, "Product Added to Cart Successfully");
			id.logOut();
		} catch (Exception e) {
			String screenshotPath = captureScreenshot();
			test.log(Status.FAIL, "Add to Cart Test Failed: " + e.getMessage())
					.addScreenCaptureFromPath(screenshotPath);
			throw e;
		}
	}

	@Test(dataProvider = "loginData3", enabled = true, priority = 3)
	public void amountAdd(String loginuser, String loginpwd, String name, String country, String city, String card,
			String month, String year) throws InterruptedException, IOException, EmailException {
		ids id = new ids(driver);
		test = ExtentManager.getInstance().createTest("Payment Process Test");

		try {
			id.login();
			id.loginUsername(loginuser);
			id.loginPassword(loginpwd);
			id.loginButton();
			Thread.sleep(5000);

			test.log(Status.INFO, "Adding Product for Payment");
			id.addCart();
			id.addToCart();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			id.cart();

			id.placeOrder();
			id.name(name);
			id.country(country);
			id.city(city);
			id.card(card);
			id.month(month);
			id.year(year);
			id.purchase();

			Assert.assertEquals(id.thankyou(), id.thankYou());
			test.log(Status.PASS, "Payment Process Successful");
		} catch (Exception e) {
			String screenshotPath = captureScreenshot();
			test.log(Status.FAIL, "Payment Process Test Failed: " + e.getMessage())
					.addScreenCaptureFromPath(screenshotPath);
			throw e;
		}
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		return new Object[][] { { "qwerty1@mailinator.com", "Casio@27", "qwerty1@mailinator.com", "Casio@27" } };
	}

	@DataProvider(name = "loginData1")
	public Object[][] getDataa() {
		return new Object[][] { { "qwerty1@mailinator.com", "Casio@27" } };
	}

@DataProvider(name = "loginData3")
public Object[][] getData3() {
    return new Object[][]{
        {"qwerty1@mailinator.com", "Casio@27", "Michael Scott", "USA", "California", "1234 4321 6789 9876", "March", "2025"}
    };
}
}
