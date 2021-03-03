package com.OrangeHRM;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_Implicit_Explicit_Wait {
	ChromeDriver driver;
  @Test
  public void Login() {

	  	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// driver.findElementById("txtUsername").sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
  }
  
  @Test(priority=1)
  public void Logout() throws InterruptedException {

	  driver.findElement(By.partialLinkText("Welcome")).click();
	  //Thread.sleep(2000);
		//----------------ExplicitWait Example--------------
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
		String ActText=element.getText();
		System.out.println(ActText);
		element.click();
	  //driver.findElement(By.linkText("Logout")).click();
  }
  @SuppressWarnings("deprecation")
@BeforeTest
  public void beforeTest() {
	// Launch the Chrome Browser
			// WebDriverManager.firefoxdriver().setup();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			//-----------------ImplicitWait Example-------------
			//Thread.sleep(3000);
			
  }

  @AfterTest
  public void afterTest() {
	// driver.close();//Close the Current Browser
			driver.quit();// Close All the browser opened by Selenium
  }

}
