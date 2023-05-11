package seleniumchallange;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumChallangeWeek2 {

	static ChromeDriver driver = new ChromeDriver();
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

						
		
		createFBAccount();
		
		delete_lead();
		
		create_account();
		
		DuplicateLead();
		
		editLead();
		
	}
	
	public static void createFBAccount() {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Daniel Derrick");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Prince");
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("daniddp.derrick@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("daniddp.derrick@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Dani8056@");
		
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select day_dropdown = new Select(day);
		day_dropdown.selectByVisibleText("16");
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select month_dropdown = new Select(month);
		month_dropdown.selectByVisibleText("Nov");
		
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select year_dropdown = new Select(year);
		year_dropdown.selectByVisibleText("1990");
				
		driver.findElement(By.xpath("//label[text()='Female']/following::input")).click();
		
		driver.quit();
		
	}
	
	public static void delete_lead() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();		
		
		driver.get("http://leaftaps.com/opentaps");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoSalesManager");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		String leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).getText();
		
		System.out.println(leadID);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")));
		
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).click();
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String Error_Message = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
		
		if(Error_Message.equals("No records to display")) {
			System.out.println("Test case pass!");
		}
		else {
			System.out.println("Test case failed!");
		}
		
		
		
		driver.close();
		
		
	}
	
	public static void create_account() {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoSalesManager");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Create Contact')]")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("Daniel");
		
		driver.findElement(By.id("lastNameField")).sendKeys("Prince");
		
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Daniel");
		
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Prince");
		
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
		
		driver.findElement(By.id("createContactForm_description")).sendKeys("Information technology");
		
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("daniddp.derrick@gmail.com");
		
		WebElement country = driver.findElement(By.xpath("//select[@id='createContactForm_generalCountryGeoId']"));
		
		Select country_dropdown = new Select(country);
		
		country_dropdown.selectByVisibleText("United States");
		
		WebElement state_code = driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']"));
		
		Select state_code_dropdown = new Select(state_code);
		
		state_code_dropdown.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("updated!!");
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		String title = driver.getTitle();
		
		if(title.equals("View Contact | opentaps CRM")) {
			System.out.println("Test case Pass!! The title is : " + title);
			
		}else {
			System.out.println("Test case Failed!! The title is : " + title);
		}
		
		driver.close();
		
	}

	public static void DuplicateLead () throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoSalesManager");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		String leadname1 = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[3]")).getText();
		
		System.out.println(leadname1);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@class='x-grid3-row-table']//a)[3]")));
		
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[3]")).click();
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		String duplicatelead_title = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText();
		
		if(duplicatelead_title.equals("Duplicate Lead")) {
		
			driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
			
			String leadname2 =  driver.findElement(By.id("viewLead_firstName_sp")).getText();
			
			if(leadname1.equals(leadname2)) {
				
				System.out.println("Test case Pass! duplicate lead matches with the lead Name");
				
			}
			else {
				System.out.println("Test case fail! duplicate lead is not matching with the lead Name");
			}
		}else {
			
			System.out.println("Test case fail! the title is not matching with the duplicate lead");
		}
		
		driver.close();
		
	}

	public static void editLead () throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoSalesManager");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Hari");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		String leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).getText();
		
		System.out.println(leadID);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")));
		
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).click();
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		
		String company_name = "ITTD";
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(company_name);
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		String CompanyName_ID = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		
		int length = CompanyName_ID.length();
		
		CompanyName_ID = CompanyName_ID.substring(0 , length-8);
		
		System.out.println(CompanyName_ID);
		
		if(CompanyName_ID.equals(company_name)) {
			
			System.out.println("Test case Pass! Company name is updated succeffully!");
			
		}else{
			System.out.println("Test case fail! Company name is not updated succeffully!");
		}
		
		driver.close();
		
	}
}
