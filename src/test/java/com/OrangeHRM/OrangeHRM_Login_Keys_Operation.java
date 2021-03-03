package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_Keys_Operation {
	ChromeDriver driver;
	  @Test
	  public void Login() {

			// driver.findElementById("txtUsername").sendKeys("Admin");
			driver.findElement(By.name("txtUsername")).sendKeys("Admin",Keys.TAB,"admin123",Keys.ENTER);
			driver.findElement(By.linkText("Dashboard")).isDisplayed();
	  }
	  
	  @Test(priority=1)
	  public void Logout() throws InterruptedException {

		  driver.findElement(By.id("welcome")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Logout")).click();
	  }
	  @BeforeTest
	  public void beforeTest() {
		// Launch the Chrome Browser
				// WebDriverManager.firefoxdriver().setup();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				// WebDriver driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	  }

	  @AfterTest
	  public void afterTest() {
		// driver.close();//Close the Current Browser
				driver.quit();// Close All the browser opened by Selenium
	  }
}
