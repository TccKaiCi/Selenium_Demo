import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class SignInWeb {

	public static void main(String[] args) {
		// Create path file auto
		File file = new File("");
        String chromeDriver = file.getAbsolutePath() + "\\chromedriver.exe";
        
        // Add driver and web link
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.verizon.com/");
		
		// Select sign in button        
		driver.findElement(By.xpath("//button[@id='gnav20-sign-id']")).click();
	     
		// Put text in
		driver.findElement(By.id("IDToken1")).sendKeys("username");
		driver.findElement(By.id("IDToken2")).sendKeys("password");
		driver.findElement(By.id("login-submit")).click();
				
		// end
		//driver.close();
	}
}