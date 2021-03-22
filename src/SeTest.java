import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeTest {

	public static void main(String[] args) {
		File file = new File("");
        String chromeDriver = file.getAbsolutePath() + "\\chromedriver.exe";
        
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.applitools.com/");
		driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("log-in")).click();
	}
}