package testcases;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.trackdfect.teaboardbase.BaseClassTea;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddInvoice extends BaseClassTea{
	
	@Test(priority = 2)
	public void addingInvoice() throws Throwable {
		
		
		Actions builder = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath("(//i[@class='mdi mdi-vector-arrange-above'])[2]"));
		builder.moveToElement(findElement).perform();
		driver.findElement(By.xpath("//span[text()='Inventory']")).click();
		driver.findElement(By.linkText("Add Bulk Garden Invoice")).click();
		WebElement findElement2 = driver.findElement(By.id("invoiceBranchTypeId"));
		Select dropdown = new Select(findElement2);
		dropdown.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\RBT\\Downloads\\new_invoice1.xlsx");
		
		
		
		driver.findElement(By.id("bulkGI-btn-upload")).click();
		File file = new File("C:\\\\Users\\\\RBT\\\\Downloads\\\\new_invoice1.xlsx");
		
		
		
		
		
		driver.findElement(By.id("bulkInvoice-btn-confirmupload")).click();
		String text = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		if (text.equalsIgnoreCase("Bulk Garden Invoice saved successfully")) {
			System.out.println("Invoice is added to the list");
		}else {
			System.out.println("Invoice is not added to the list");
		}
		WebElement findElement4 = driver.findElement(By.xpath("//i[@class='mdi mdi-view-dashboard']"));
		builder.moveToElement(findElement4).perform();
		driver.findElement(By.xpath("//span[text()='Inventory']")).click();
		driver.findElement(By.linkText("Manage Garden Invoice")).click();
		WebElement findElement5 = driver.findElement(By.id("invoiceBranchTypeId"));
		Select dropdown3 = new Select(findElement5);
		dropdown3.selectByIndex(1);
		driver.findElement(By.id("giNoId")).sendKeys("inv19");
		driver.findElement(By.id("searchInvoiceProceedButton")).click();
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-success')])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("close")).click();
		 
		

	}

}
