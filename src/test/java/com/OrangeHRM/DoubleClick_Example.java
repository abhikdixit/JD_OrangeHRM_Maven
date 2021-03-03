package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClick_Example {
	ChromeDriver driver;
  @Test
  public void DragDrop() throws InterruptedException 
  {
	  	
		// Add 5 seconds wait
		Thread.sleep(3000);
		// Create object of actions class
		Actions act=new Actions(driver);
		// find element which we need to double click
		WebElement dblclick=driver.findElement(By.id("dblClkBtn"));
		// this will drag element to destination
		act.doubleClick(dblclick).build().perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
  }
  @BeforeTest
  public void beforeTest() 
  {
	  WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    //WebDriver driver = new ChromeDriver();
		// maximize browser
		driver.manage().window().maximize();
		// Open webpage
		//driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		//This will rememember you cookies and History
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
