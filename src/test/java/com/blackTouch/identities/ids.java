package com.blackTouch.identities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ids {
	private WebDriver driver;

	public ids(WebDriver driver) {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//
	// signInModalLabel
	@FindBy(xpath = "//*[@id='signin2']")
	WebElement signup;

	public void signUp() {
		signup.click();
	}

	@FindBy(xpath = "//*[@id='sign-username']")
	WebElement username;

	public void userName(String user) {
		username.sendKeys(user);
	}

	@FindBy(xpath = "//*[@id='sign-password']")
	WebElement password;

	public void passWord(String pwd) {
		password.sendKeys(pwd);
	}

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signbutton;

	public void signButton() {
		signbutton.click();
	}

	@FindBy(xpath = "//div[@id='signInModal']//span[@aria-hidden='true'][normalize-space()='×']")
	WebElement close;

	public void Close() {
		close.click();
	}

	@FindBy(id = "login2")
	WebElement login;

	public void login() {
		login.click();
	}

	@FindBy(id = "loginusername")
	WebElement Loginusername;

	public void loginUsername(String login) {
		Loginusername.sendKeys(login);
	}

	@FindBy(id = "loginpassword")
	WebElement Loginpassword;

	public void loginPassword(String pwd) {
		Loginpassword.sendKeys(pwd);
	}

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginbutton;

	public void loginButton() {
		loginbutton.click();
	}

	@FindBy(xpath = "//a[@id='nameofuser']")
	WebElement welcome;

	public String loginverify() {
		return welcome.getText();
	}

	public Object loginVerify() {
		String login = "Welcome qwerty1@mailinator.com";//
		return login;
	}

	@FindBy(xpath = "//*[@id='logout2']")
	WebElement logout;

	public void logOut() {
		logout.click();
	}

	@FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
	WebElement item;

	public void addCart() {
		item.click();
	}

	@FindBy(xpath = "//*[text()='Add to cart']")
	WebElement addtocart;

	public void addToCart() {
		addtocart.click();
	}

	@FindBy(xpath = "//*[text()='Cart']")
	WebElement cart;

	public void cart() {
		cart.click();
	}

	@FindBy(xpath = "//*[text()='Samsung galaxy s6']")
	WebElement vitem;

	public String vCart() {
		return vitem.getText();
	}

	public Object cVerify() {
		String login = "Samsung galaxy s6";//
		return login;
	}

	@FindBy(xpath = "//*[text()='Place Order']")
	WebElement placeorder;

	public void placeOrder() {
		placeorder.click();
	}

	// Name
	@FindBy(xpath = "//*[@id='name']")
	WebElement Name;

	public void name(String name) {
		Name.sendKeys(name);
	}
	

	// Country
	@FindBy(xpath = "//*[@id='country']")
	WebElement Country;

	public void country(String country) {
		Country.sendKeys(country);
	}

	// city
	@FindBy(xpath = "//*[@id='city']")
	WebElement City;

	public void city(String city) {
		City.sendKeys(city);
	}

	// card
	@FindBy(xpath = "//*[@id='card']")
	WebElement Card;

	public void card(String card) {
		Card.sendKeys(card);
	}

	// month
	@FindBy(xpath = "//*[@id='month']")
	WebElement Month;

	public void month(String month) {
		Month.sendKeys(month);
	}

	// year
	@FindBy(xpath = "//*[@id='year']")
	WebElement Year;

	public void year(String year) {
		Year.sendKeys(year);
	}

	@FindBy(xpath = "//*[text()='Purchase']")
	WebElement purchase;

	public void purchase() {
		purchase.click();
	}
	
	@FindBy(xpath = "//*[text()='Thank you for your purchase!']")
	WebElement thankyou;

	public String thankyou() {
		return thankyou.getText();
	}

	public Object thankYou() {
		String ty = "Thank you for your purchase!";//
		return ty;
	}
	
	
	public void waitForElement() {
		
		WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait10.until(ExpectedConditions.elementToBeClickable(signup));
		wait10.until(ExpectedConditions.elementToBeClickable(username));
		wait10.until(ExpectedConditions.elementToBeClickable(password));
		wait10.until(ExpectedConditions.elementToBeClickable(signbutton));
		wait10.until(ExpectedConditions.elementToBeClickable(close));
		wait10.until(ExpectedConditions.elementToBeClickable(logout));
		wait10.until(ExpectedConditions.elementToBeClickable(login));
		wait10.until(ExpectedConditions.elementToBeClickable(Loginusername));
		wait10.until(ExpectedConditions.elementToBeClickable(Loginpassword));
		wait10.until(ExpectedConditions.elementToBeClickable(welcome));
		wait10.until(ExpectedConditions.elementToBeClickable(cart));
		wait10.until(ExpectedConditions.elementToBeClickable(vitem));
		wait10.until(ExpectedConditions.elementToBeClickable(loginbutton));
		wait10.until(ExpectedConditions.elementToBeClickable(addtocart));
		wait10.until(ExpectedConditions.elementToBeClickable(item));

		wait10.until(ExpectedConditions.elementToBeClickable(Name));
		wait10.until(ExpectedConditions.elementToBeClickable(Country));
		wait10.until(ExpectedConditions.elementToBeClickable(City));
		wait10.until(ExpectedConditions.elementToBeClickable(Card));
		wait10.until(ExpectedConditions.elementToBeClickable(Month));
		wait10.until(ExpectedConditions.elementToBeClickable(Year));
		wait10.until(ExpectedConditions.elementToBeClickable(purchase));

	}

}
