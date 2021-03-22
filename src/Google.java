import java.awt.Desktop.Action;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.Select;

public class Google {
	public static void main(String[] args) {
		// Create path file auto
		File file = new File("");
        String chromeDriver = file.getAbsolutePath() + "\\chromedriver.exe";
        
        // Add driver and web link
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/SignUp");
		
		// Select hover drop down menu        
		driver.findElement(By.id("lastName")).sendKeys("LName");
		driver.findElement(By.id("firstName")).sendKeys("FName");
		driver.findElement(By.id("username")).sendKeys("UserName FL");
		driver.findElement(By.name("Passwd")).sendKeys("pass123");
		driver.findElement(By.name("ConfirmPasswd")).sendKeys("pass123");
		// end
		//driver.close();
	}
}
