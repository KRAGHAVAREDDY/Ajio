package com.Ajiobase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest {
	public WebDriver driver;
	public SoftAssert softAssertion;

	@BeforeClass
	@Parameters({ "browser", "pageUrl" })
	public void Setup(String browser, String pageUrl) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\venka\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\venka\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\venka\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		}

		driver.get(pageUrl);

		softAssertion = new SoftAssert();
	}

	@AfterClass
	public void TearDown() {
		softAssertion.assertAll();
		driver.close();
	}

}
