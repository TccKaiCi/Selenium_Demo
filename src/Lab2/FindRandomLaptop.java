package Lab2;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FindRandomLaptop {
	public static void main(String[] args) {
		// Create path file auto
		File file = new File("");
        String chromeDriver = file.getAbsolutePath() + "\\chromedriver.exe";
        
        // Add driver and web link
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		// close sign in - up
		WebElement buttonClose = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
		buttonClose.click();
		
		
		//send key search
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("Lenovo");
		
		// find
		WebElement buttonElement = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button"));
		buttonElement.click();
		
		// end
		//driver.close();
	}
}
