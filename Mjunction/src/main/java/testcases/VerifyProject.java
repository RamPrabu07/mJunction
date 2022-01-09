package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyProject {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		driver.get("https://tsit.mjunction.in/tauc/security/getLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20 ,TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		WebElement findElement11 = driver.findElement(By.xpath("//p[text()='Sign In']"));
		builder.moveToElement(findElement11).perform();
		driver.findElement(By.xpath("//p[text()='Sign In']")).click();
		driver.findElement(By.id("userName")).sendKeys("tealife@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("Qwerty@123");
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("acceptTermBtn")).click();
		WebElement findElement = driver.findElement(By.xpath("(//i[@class='mdi mdi-vector-arrange-above'])[2]"));
		builder.moveToElement(findElement).perform();
		driver.findElement(By.xpath("//span[text()='Inventory']")).click();
		driver.findElement(By.linkText("Manage Garden Invoice")).click();
		WebElement findElement5 = driver.findElement(By.id("invoiceBranchTypeId"));
		Select dropdown3 = new Select(findElement5);
		dropdown3.selectByIndex(1);
		driver.findElement(By.id("giNoId")).sendKeys("inv19");
		driver.findElement(By.id("searchInvoiceProceedButton")).click();
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-success')])[2]")).click();
		Thread.sleep(3000);
		WebElement webTable = driver.findElement(By.id("manageInvoiceItemTable"));
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		
		System.out.println(" Number of rows in the table:" + tableRows.size());
		for (WebElement eachRowElement : tableRows) {
			System.out.println(eachRowElement.getText());
		}
		
		

		/*
		 * FileInputStream fis = new
		 * FileInputStream("‪C:\\Users\\RBT\\Downloads\\inv19Copy.xlsx"); XSSFWorkbook
		 * workbook = new XSSFWorkbook(fis); XSSFSheet sheet = workbook.getSheetAt(0);
		 * int lastRowNum = sheet.getLastRowNum(); int lastCellNum =
		 * sheet.getRow(0).getLastCellNum(); for (int i = 1; i <=lastRowNum; i++) { for
		 * (int j = 0; j < lastCellNum; j++) { String stringCellValue =
		 * sheet.getRow(i).getCell(j).getStringCellValue();
		 * System.out.println(stringCellValue);
		 * 
		 * } }
		 */
		
		
		
		
		
		
		
	
		 
		
		
		

	}

}
