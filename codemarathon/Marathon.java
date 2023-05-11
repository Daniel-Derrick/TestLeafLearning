package codemarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

public class Marathon {
	

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//testcase1_redBus();
		
		//testcase2_Amazon();
		
		testcase3_pvr_cinemas();
		
	}
	
	public static void testcase1_redBus() {
		

		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		
		driver.findElement(By.xpath("//input[@id='src']/following-sibling::ul/li[@data-no='2']")).click();
		
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		
		driver.findElement(By.xpath("//input[@id='dest']/following-sibling::ul/li[@data-no='2']")).click();
		
		driver.findElement(By.xpath("//td[@class='current day']/following-sibling::td")).click();
		
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		
		String bus_found = driver.findElement(By.xpath("//span[text()='found']/span")).getText();
		
		System.out.println("Number of bus found for the search result is - " + bus_found);
		
		driver.findElement(By.xpath("//label[contains(text(),'SLEEPER')]/preceding-sibling::label")).click();
		
		String bus_name = driver.findElement(By.xpath("//ul[@class='bus-items']/div[2]//div/div/div/div/div")).getText();
		
		System.out.println("The name of the second resulting bus is  - " + bus_name);
		
		System.out.println("THe page title is - " + driver.getTitle());
		
		driver.close();
		
	}
	
	
	public static void testcase2_Amazon() throws InterruptedException {
		

		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags");
		
		driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
		
		String result = driver.findElement(By.xpath("//span[contains(text(),'bags for boys')]/preceding-sibling::span")).getText();
		
		System.out.println("The total number of result for the search is - " + result);
		
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul//li//div)[1]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul//li//div)[2]")).click();
		
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sort by:']/parent::span")));
		
		driver.findElement(By.xpath("//span[text()='Sort by:']/parent::span")).click();
		
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		
		Thread.sleep(3000);
		
		String bag_name = driver.findElement(By.xpath("(//div[@data-component-type='s-search-result'])[1]/div/div/div/div/div[2]/div[1]/div[1]/h5/span")).getText();
		
		//div[@data-component-type='s-search-result'])[1]/div/div/div/div/div[2]/div[1]/div[1]/h5/span
		
		String bag_discount_price = driver.findElement(By.xpath("(//div[@data-component-type='s-search-result'])[1]/div/div/div/div/div[2]/div[3]//a/span/span[2]/span[2]")).getText();
	
		System.out.println("The first resulting bag name is - " + bag_name);
		System.out.println("Discounted price is - " + bag_discount_price);
		System.out.println("Test case Pass!");
		
		driver.close();
	
	}
	
	
	public static void testcase3_pvr_cinemas() throws InterruptedException {
		

		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.pvrcinemas.com/");
		
		driver.findElement(By.xpath("//div[contains(text(),'Movie Library ')]")).click();
		
		Thread.sleep(3000);
		
		WebElement city = driver.findElement(By.name("city"));
		
		Select city_dropdown = new Select(city);
		
		city_dropdown.selectByVisibleText("Chennai");
		
		WebElement Genre = driver.findElement(By.name("genre"));
		
		Select Genre_dropdown = new Select(Genre);
		
		Genre_dropdown.selectByVisibleText("ANIMATION");
		
		WebElement Language = driver.findElement(By.name("lang"));
		
		Select Language_dropdown = new Select(Language);
		
		Language_dropdown.selectByVisibleText("ENGLISH");
		
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@class='movie-list']/div)[1]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Proceed To Book')]")).click();
		
		WebElement cinema = driver.findElement(By.name("cinemaName"));
		
		Select cinema_dropdown = new Select(cinema);
		
		cinema_dropdown.selectByVisibleText("PVR Heritage RSL ECR Chennai");
		
		WebElement preferedtime = driver.findElement(By.name("timings"));
		
		Select preferedtime_dropdown = new Select(preferedtime);
		
		preferedtime_dropdown.selectByVisibleText("09:00 AM - 12:00 PM");
		
		driver.findElement(By.xpath("//ngx-datepicker[@placeholder='select date']/div/input")).click();
		
		driver.findElement(By.xpath("//div[@class='main-calendar-days']/span[text()='18']")).click();
		
		driver.findElement(By.name("name")).sendKeys("Daniel Derrick");
		
		driver.findElement(By.name("noOfTickets")).sendKeys("2");
		
		WebElement food = driver.findElement(By.name("food"));
		
		Select food_dropdown = new Select(food);
		
		food_dropdown.selectByVisibleText("Yes");
		
		driver.findElement(By.name("email")).sendKeys("daniddp.derrick@gmail.com");
		
		driver.findElement(By.name("mobile")).sendKeys("8056290287");
		
		driver.findElement(By.name("comment")).sendKeys("Test");
		
		driver.findElement(By.xpath("//span[text()='Copy To Self']")).click();
		
		driver.findElement(By.xpath("//button[text()='SEND REQUEST']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//button[text()='CANCEL'])[2]")).click();
		
		String title = driver.getTitle();
		
		if(title.equals("Movie Library")) 
			System.out.println("Test case Pass!");
		else
			System.out.println("Test case fail!");
		
		driver.close();
	}
}
