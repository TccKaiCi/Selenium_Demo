package Lab3;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_GetMeuAndPrintTitle {
	public static void main(String[] args) {
		// Create path file auto
        String chromeDriver = new File("").getAbsolutePath() + "\\chromedriver.exe";
        
        // Add driver and web link
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		//Resize current window to the set dimension
	    driver.manage().window().maximize();
	    
	    // get Title page and print
	    String titleHome = driver.getTitle();
	    System.out.println(titleHome);
	       
	    // click to pay
	    WebElement pay = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[9]"));
	    pay.click();
	    
	    // get Title page and print
	    String titlePay = driver.getTitle();
	    System.out.println(titlePay);
	    
	    // back page
	    driver.navigate().back();

	    // get Title page and print
	    String titleBackHome = driver.getTitle();
	    System.out.println(titleBackHome);
	    
	    // compare
	    if (titleHome.contains(titleBackHome)) {
	    	System.out.println("Giong nhau");
	    	System.out.printf("" + titleHome + "\n");
	    }
	    else {
	    	System.out.println("Khac nhau");
	    	System.out.printf("Luc dau: " + titleHome + "\n");
	    	System.out.printf("Luc sau: " + titleBackHome + "\n" );
	    }
	    
	    //quit
	    driver.quit();
	}
}
