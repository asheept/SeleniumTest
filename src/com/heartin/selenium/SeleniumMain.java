package com.heartin.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumMain
{

	public static void main(String[] args) throws InterruptedException
	{
		SeleniumMain main = new SeleniumMain();
		main.crawl();
	}

	private WebDriver driver;
	private WebElement webElement;

	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\Users\\heartin\\Desktop\\Selenium\\chromedriver.exe";

	private String base_url;

	public SeleniumMain()
	{
		super();

		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options);

		base_url = "http://naver.com";
	}

	public void crawl() throws InterruptedException
	{

		driver.get(base_url);

		Thread.sleep(500);
		
		driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");


		webElement = driver.findElement(By.id("id"));
		webElement.clear();
		webElement.sendKeys("yourid");

		webElement = driver.findElement(By.id("pw"));
		webElement.clear();
		webElement.sendKeys("yourpw");

		webElement = driver.findElement(By.id("log.login"));
		webElement.click();

	}

}
