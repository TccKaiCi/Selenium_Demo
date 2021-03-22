
package Lab4;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC2_Register {
	public static void main(String[] args) {
		// file path
		String ChromeDriver = new File("").getAbsolutePath() +"\\chromedriver.exe";
		// add driver
		System.setProperty("Webdriver.chrome.driver",ChromeDriver);
		WebDriver driver = new ChromeDriver();
		// add web url
		driver.get("http://automationpractice.com/index.php");
		
		// click on sign in
		driver.findElement(By.className("login")).click();
		
		Random rand = new Random();
		int x = rand.nextInt(100000) + 1;
		//  fill in email
		driver.findElement(By.id("email_create")).sendKeys("email" + x + ".com@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// check box
		driver.findElement(By.id("id_gender1")).click();
		
		driver.findElement(By.id("customer_firstname")).sendKeys("FirstNameeeeee");
		driver.findElement(By.id("customer_lastname")).sendKeys("LastNameeeeee");
		driver.findElement(By.id("passwd")).sendKeys("passworrdddddd");
		
		// combobox select
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByIndex(3);
		
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByIndex(3);
		
		Select years = new Select(driver.findElement(By.id("years")));
		years.selectByIndex(3);
		
		//fill
		driver.findElement(By.id("firstname")).sendKeys("FirsttNamee");
		driver.findElement(By.id("lastname")).sendKeys("LasttNameee");
		driver.findElement(By.id("company")).sendKeys("Companyyyyy");
		driver.findElement(By.id("address1")).sendKeys("Addresssssss, P.O C, name K");
		driver.findElement(By.id("address2")).sendKeys("Addresssssss, ASDSAD,AAAAA");
		driver.findElement(By.id("city")).sendKeys("Cityyyyyyy");
		driver.findElement(By.id("postcode")).sendKeys("33042");
		
		// combobox
		Select states = new Select(driver.findElement(By.id("id_state")));
		states.selectByIndex(3);
		
		Select countrys = new Select(driver.findElement(By.id("id_country")));
		countrys.selectByIndex(1);
		
		driver.findElement(By.id("other")).sendKeys("Otherrr?");
		driver.findElement(By.id("phone")).sendKeys("012345678");
		driver.findElement(By.id("phone_mobile")).sendKeys("0123456789");
		driver.findElement(By.id("alias")).sendKeys("NearrHereeeeeeeeeee?");
		
		
		driver.findElement(By.id("submitAccount")).click();
		
		// validate user
		String url = driver.getCurrentUrl();
		
		if (url.contains("my-account"))
			System.out.println("Create account success");
		else 
			System.out.println("Fail create account");
			
		System.out.println("Finish");
		// close
		driver.close();
	}
	
}