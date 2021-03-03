package com.OrangeHRM;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login {

	@Test
	public void Login_Successful_Scenario() {
		
		//Launch the Chrome Browser
		//WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		//driver.findElementById("txtUsername").sendKeys("Admin");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		//driver.close();//Close the Current Browser
		driver.quit();//Close All the browser opened by Selenium
		
	}

}
