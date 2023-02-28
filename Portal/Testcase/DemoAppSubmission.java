//This code is written to test flow of portal app submission.
package PortalAppSubmissions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoAppSubmission {

	private static By elementBy;
	private static String fileName;

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		String emailaddress="rgudi@appliedenergygroup.com";
		String password="chase1986R@";
		String premiseid="12221";
		String meterid="12221";
		String accountnumber="12223551";
		//String phone="122123111";
		String cell="732552222";
		String fax="7433443333";
		String taxid="12221234";
		String filePath = System.getProperty("user.dir")+"/testData/AEG Group Assignment Report_Parent Program.xlsx";
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgudi\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Entering the Portal url
		driver.get("https://npateltest.customerapplication.com/");
		driver.manage().window().maximize();//maximizing the window
		Thread.sleep(3000);
		//Clicking on Apply now link
		driver.findElement(By.xpath("//span[contains(text(),'Apply Now')]")).click();
		//Scrolling on the page
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		//Clicking on Begin Application button
		driver.findElement(By.cssSelector("a[role='button']")).click();
		//Entering email addresses, submit, password and submit.
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(emailaddress);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='root_password']")).sendKeys(password);
		Thread.sleep(3000);
		//Clicking on submit button
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();	
		Thread.sleep(10000);
		//Click on the contact entry dropdown, select text and enter the required fields on the form
		Select dropdown=new Select(driver.findElement(By.xpath("//select[@id='premise-contact_storedContactNumber']")));
		Thread.sleep(10000);
		dropdown.selectByVisibleText("Test Rahul Rahul test AEG");
		driver.findElement(By.xpath("//input[@id='premise-contact_section_column1_premiseId']")).sendKeys(premiseid);
		driver.findElement(By.xpath("//input[@id='premise-contact_section_column1_meterId']")).sendKeys(meterid);
		driver.findElement(By.xpath("//input[@id='premise-contact_section_column1_acct_number']")).sendKeys(accountnumber);
		driver.findElement(By.xpath("//input[@id='premise-contact_section_column2_phone']")).clear();
		driver.findElement(By.xpath("//input[@id='premise-contact_section_column2_phone']")).sendKeys("122222222");
		driver.findElement(By.xpath("//input[@id='premise-contact_section_column2_cell']")).sendKeys(cell);
		driver.findElement(By.xpath("//input[@id='premise-contact_section_column2_fax']")).sendKeys(fax);
		driver.findElement(By.xpath("//input[@id='premise-contact_section_column2_taxId']")).sendKeys(taxid);

		//checking Same as home/business information checkbox by scrolling down
		WebElement element=driver.findElement(By.xpath("//label[contains(text(),'Same as home/business information')]"));
		jse.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[contains(text(),'Same as home/business information')]")).click();
		Thread.sleep(1000);

		try{
			WebElement element1=driver.findElement(By.xpath("//select[@id='contractor-contact_storedContactNumber']"));
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;		
			jse1.executeScript("arguments[0].scrollIntoView()", element1);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
			System.out.println(".... Inside exception.... \n");
			WebElement element2=driver.findElement(By.xpath("//select[@id='contractor-contact_storedContactNumber']"));
			element2.click();			
		}
		//Choosing existing contact dropdown options and entering the required fields.
		Select dropdown2 =new Select(driver.findElement(By.xpath("//select[@id='contractor-contact_storedContactNumber']")));
		dropdown2.selectByVisibleText("Test Rahul Rahul test AEG");
		System.out.println(".... 6.... \n");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='contractor-contact_section_column1_premiseId']")).sendKeys(premiseid);
		driver.findElement(By.xpath("//input[@id='contractor-contact_section_column1_meterId']")).sendKeys(meterid);
		driver.findElement(By.xpath("//input[@id='contractor-contact_section_column1_acct_number']")).sendKeys(accountnumber);
		driver.findElement(By.xpath("//input[@id='primary-contact_section_column2_phone']")).clear();
		driver.findElement(By.xpath("//input[@id='primary-contact_section_column2_phone']")).sendKeys("122222222");
		driver.findElement(By.xpath("//input[@id='contractor-contact_section_column2_cell']")).sendKeys(cell);
		driver.findElement(By.xpath("//input[@id='contractor-contact_section_column2_fax']")).sendKeys(fax);
		driver.findElement(By.xpath("//input[@id='contractor-contact_section_column2_taxId']")).sendKeys(taxid);
		driver.findElement(By.xpath("//input[@id='contractor-contact_section_column2_taxId']")).sendKeys(Keys.TAB);

		driver.findElement(By.xpath("//input[@id='contractor-contact_section_column2_phone']")).clear();
		driver.findElement(By.xpath("//input[@id='contractor-contact_section_column2_phone']")).sendKeys("122222222");

		//Clicking on continue button on Contact Entry page
		WebElement continueButton=driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;	
		jse2.executeScript("arguments[0].scrollIntoView();",continueButton);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		Thread.sleep(3000);/////////////

		//Selecting No option to Does the new equipment include electric technology? field on project information page on the portal
		Thread.sleep(5000);
		WebElement drop1=driver.findElement(By.xpath("//label[contains(text(),'Does the new equipment include electric technology')]/following-sibling::select"));
		Select sel1=new Select(drop1);
		sel1.selectByVisibleText("No");
		Thread.sleep(5000);

		//Selecting Replacement option on Is this new unit replacing an existing unit or is this an expansion to your fleet? field
		Thread.sleep(5000);
		WebElement drop2=driver.findElement(By.xpath("//label[contains(text(),'Is this new unit replacing an existing unit or is this an expansion to your fleet')]/following-sibling::select"));
		Select sel2=new Select(drop2);
		sel2.selectByVisibleText("Replacement");
		Thread.sleep(3000);

		//Selecting No option to If the new unit is replacing an existing unit, is the current fuel technology Diesel? (only required for replacement units) field on project information on the portal
		Thread.sleep(5000);
		WebElement drop3=driver.findElement(By.xpath("//label[contains(text(),'new unit is replacing an existing unit, is the current fuel technology Diesel')]/following-sibling::select"));
		Select sel3=new Select(drop3);
		sel3.selectByVisibleText("No");
		Thread.sleep(5000);

		//Selecting Preferred method of payment as Check payment to Customer
		Thread.sleep(5000);
		WebElement drop4=driver.findElement(By.xpath("//label[contains(text(),'Preferred method of payment')]/following-sibling::select"));
		Select sel4=new Select(drop4);
		sel4.selectByVisibleText("Check payment to Customer");
		Thread.sleep(5000);

		//Hitting continue button
		continueButton=driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		JavascriptExecutor jse3 = (JavascriptExecutor)driver;	
		jse3.executeScript("arguments[0].click();",continueButton);

		//hitting back button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Back']")).click();
		Thread.sleep(5000);

		//Selecting Yes option to Does the new equipment include electric technology? field on project information page on the portal
		drop1=driver.findElement(By.xpath("//label[contains(text(),'Does the new equipment include electric technology')]/following-sibling::select"));
		sel1=new Select(drop1);
		sel1.selectByVisibleText("Yes");

		//Selecting Yes option to If the new unit is replacing an existing unit, is the current fuel technology Diesel? (only required for replacement units) field on project information on the portal
		drop3=driver.findElement(By.xpath("//label[contains(text(),'new unit is replacing an existing unit, is the current fuel technology Diesel')]/following-sibling::select"));
		sel3=new Select(drop3);
		sel3.selectByVisibleText("Yes");

		WebElement drop5=driver.findElement(By.xpath("//label[contains(text(),'Is this new unit replacing an existing unit or is this an expansion to your fleet')]/following-sibling::select"));
		Select sel5=new Select(drop5);
		sel5.selectByVisibleText("Expansion");

		//Hitting Continue button
		continueButton=driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		jse3.executeScript("arguments[0].click();",continueButton);
		Thread.sleep(3000);

		//Hitting Continue button on the equipment entry portal page
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		Thread.sleep(7000);

		//Hitting Continue button on the estimated project incentive page
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		Thread.sleep(5000);
		
		//Clicking on the document upload on the portal
		driver.findElement(By.xpath("//div[contains(text(),'Document Upload')]")).click();
		
		//Clicking on Choose File button and selecting a file
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@id='root_file']")).click();
		driver.findElement(By.xpath("//input[@id='root_file']")).sendKeys(filePath);
		
		Thread.sleep(4000);
		
		//Clicking on file upload button
		driver.findElement(By.xpath(" //button[contains(text(),'Upload File')]")).click();
		//Clicking on Complete button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(), 'Complete Application')]")).click();
		Thread.sleep(5000);

		//Closing the browser 
		driver.close();
		 
	  System.out.println("----Test is passed----"); 
		 

	    }

	}
