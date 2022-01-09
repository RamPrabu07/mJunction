package testcases;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.trackdfect.teaboardbase.BaseClassTea;

import com.aventstack.extentreports.gson.GsonExtentTypeAdapterBuilder.Builder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProduct extends BaseClassTea {
	
	
	@Test(priority = 1)
	public void adddProduct() throws InterruptedException {
		
		
		Actions builder = new Actions(driver);
		
		WebElement findElement = driver.findElement(By.xpath("//i[@class='mdi mdi-vector-arrange-above']"));
		Thread.sleep(3000);
		builder.moveToElement(findElement).perform();
		driver.findElement(By.xpath("//span[text()='Manage Product']")).click();
		driver.findElement(By.linkText("Add/ View Product")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		WebElement findElement2 = driver.findElement(By.id("product_dropbranch"));
		Select dropdown = new Select(findElement2);
		dropdown.selectByIndex(1);
		WebElement findElement3 = driver.findElement(By.id("product_dropfactory"));
		Select dropdown1 = new Select(findElement3);
		dropdown1.selectByIndex(1);
		
		driver.findElement(By.id("product_mark")).sendKeys("test33");
		WebElement findElement4 = driver.findElement(By.id("product_dropdownmake"));
		Select dropdown2 = new Select(findElement4);
		dropdown2.selectByIndex(1);
		WebElement findElement5 = driver.findElement(By.id("product_dropproducttype"));
		Select dropdown3 = new Select(findElement5);
		dropdown3.selectByIndex(1);
		WebElement findElement6 = driver.findElement(By.id("product_dropgrade"));
		Select dropdown4 = new Select(findElement6);
		dropdown4.selectByIndex(1);
		WebElement findElement7 = driver.findElement(By.id("product_dropsubgrade"));
		Select dropdown5 = new Select(findElement7);
		dropdown5.selectByIndex(9);
		WebElement findElement8 = driver.findElement(By.id("product_dropmanutype"));
		Select dropdown6 = new Select(findElement8);
		dropdown6.selectByIndex(1);
		WebElement findElement9 = driver.findElement(By.id("product_dropgitag"));
		Select dropdown7 = new Select(findElement9);
		dropdown7.selectByIndex(1);
		driver.findElement(By.id("product_submit")).click();
		String text = driver.findElement(By.id("msgId")).getText();
		if (text.equalsIgnoreCase("Product saved Successfully")) {
			System.out.println("Product added to the list");
			
		}else {
			System.out.println("Product not added to the list");
		}
		driver.findElement(By.id("product_close")).click();
		WebElement findElement10 = driver.findElement(By.xpath("(//span[@class='icon-holder']//i)[3]"));
		builder.moveToElement(findElement10).perform();
		driver.findElement(By.xpath("//span[text()='Manage Product']")).click();
		driver.findElement(By.linkText("Add/ View Product")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("test33");
		 String text2 = driver.findElement(By.xpath("//td[text()='test33']")).getText();
		 if (text2.equalsIgnoreCase("test33")) {
			 System.out.println("Product is shown in the list");
			
		}else {
			System.out.println("Product is not shown in the list");
		}
		
		
		
		

	}

}
