package com.OrangeHRM;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_GetText_GetTitle_GetCurrentURL {
	ChromeDriver driver;
  @Test
  public void Login() {

		// driver.findElementById("txtUsername").sendKeys("Admin");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
  }
  
  @Test(priority=1)
  public void Logout() throws InterruptedException {

	  driver.findElement(By.id("welcome")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Logout")).click();
	  //To get the Text and verify
	  String ActText=driver.findElement(By.id("logInPanelHeading")).getText();
	  String ExpText="LOGIN Panel";
	  Assert.assertEquals(ExpText, ActText);
	  //To get the currentURL and Verify
	  String ActURL=driver.getCurrentUrl();
	  String ExpURL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	  Assert.assertEquals(ExpURL, ActURL);
	  //To Verify the Title
	  String ActTitle=driver.getTitle();
	  String ExpTitle="OrangeHRM";
	  Assert.assertEquals(ExpTitle, ActTitle);
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
