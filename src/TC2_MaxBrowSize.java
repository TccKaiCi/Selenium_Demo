import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_MaxBrowSize {
	public static void main(String[] args) {
		// Create path file auto
        String chromeDriver = new File("").getAbsolutePath() + "\\chromedriver.exe";
        
        // Add driver and web link
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		WebDriver driver = new ChromeDriver();
		driver.get("https://godaddy.com/");

		//Resize current window to the set dimension
	    driver.manage().window().maximize();
	       
	}
}
