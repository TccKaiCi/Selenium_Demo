package Lab2;
import java.awt.Desktop.Action;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.Select;


public class RegisterWeb {


	public static void main(String[] args) {
		// Create path file auto
        String chromeDriver = new File("").getAbsolutePath() + "\\chromedriver.exe";
        
        // Add driver and web link
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.verizon.com/");
		
		// Select hover drop down menu        
		Actions mouse = new Actions(driver);
		WebElement link_SignIn = driver.findElement(By.id("gnav20-account-menu"));
		mouse.moveToElement(link_SignIn).perform();
		WebElement link_regs = driver.findElement(By.xpath("//*[@id=\"gnav20-sign-in\"]/ul/li[2]/a"));
		link_regs.click();
	}
}