package Lab4;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_GetAllAOptions {
	public static void main(String[] args) {
		// file path
		String ChromeDriver = new File("").getAbsolutePath() +"\\chromedriver.exe";
		// add driver
		System.setProperty("Webdriver.chrome.driver",ChromeDriver);
		WebDriver driver = new ChromeDriver();
		// add web url
		driver.get("https://www.google.com/");
		
		// send key
		driver.findElement(By.name("q")).sendKeys("Minecraft");
		// get class name - ul
		WebElement list = driver.findElement(By.className("erkvQe"));
		
		// waiting time
		// to make sure that can be runtime error
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// get list item <li>
		List<WebElement> rows = list.findElements(By.tagName("li"));
		
		// print list option
		for(WebElement item : rows) {
			System.out.println(item.getText());
		}
		
		System.out.println("Finish");
		// close
		driver.close();
	}
	
}