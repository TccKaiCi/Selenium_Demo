package Lab4;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home {
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
			
		// get URL
//		String url = driver.getCurrentUrl();
		
		Random rand = new Random();
		int x = rand.nextInt(100000) + 1;
		//  fill in email
		driver.findElement(By.id("email_create")).sendKeys("email" + x + ".com@com");
		driver.findElement(By.id("SubmitCreate")).click();
		

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
//		String newUrl = driver.getCurrentUrl();
		try {
			WebElement alert = driver.findElement(By.id("create_account_error"));
			String strAlert = alert.getAttribute("style");
			if (strAlert.contains("block")) 
				System.out.println("Invalid email address");
			else
				System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		System.out.println("Finish");
		// close
//		driver.close();
	}
	
}