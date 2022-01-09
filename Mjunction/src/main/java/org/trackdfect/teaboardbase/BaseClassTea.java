package org.trackdfect.teaboardbase;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.trackdfect.utils.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTea {
	public static ChromeDriver driver;
	
	
	 
	
	@Parameters({"username","password"})
	@BeforeMethod()
	public void preCondition(String uName,String pwd) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tsit.mjunction.in/tauc/security/getLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20 ,TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		WebElement findElement11 = driver.findElement(By.xpath("//p[text()='Sign In']"));
		builder.moveToElement(findElement11).perform();
		driver.findElement(By.xpath("//p[text()='Sign In']")).click();
		driver.findElement(By.id("userName")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("acceptTermBtn")).click();
		
		

	}
	
	@AfterMethod()
	public void postCondition() throws Exception {
		 driver.findElement(By.xpath("//img[@class='profile-img img-fluid']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[@headerlink='/security/logout']")).click();
		 driver.quit();	
	}
}
