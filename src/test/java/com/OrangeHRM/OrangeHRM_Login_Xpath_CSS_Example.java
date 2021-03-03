package com.OrangeHRM;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_Xpath_CSS_Example {
	ChromeDriver driver;
  @Test
  public void Login() {

		// driver.findElementById("txtUsername").sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
  }
  
  @Test(priority=1)
  public void Logout() throws InterruptedException {

	  driver.findElement(By.partialLinkText("Welcome")).click();
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
