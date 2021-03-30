package Lab5;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC3_VerifyPrice {
	public static void main(String[] args) {
		// file path
		String ChromeDriver = new File("").getAbsolutePath() +"\\chromedriver.exe";
		// add driver
		System.setProperty("Webdriver.chrome.driver",ChromeDriver);
		WebDriver driver = new ChromeDriver();
		// add web url
		driver.get("http://automationpractice.com/index.php");
		
		//Resize current window to the set dimension
	    driver.manage().window().maximize();
	    
		// step 2
		// click login button
		driver.findElement(By.className("login")).click();
		
		// fill email
		driver.findElement(By.id("email")).sendKeys("email.com@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("passworrdddddd");
		
		// login
		driver.findElement(By.id("SubmitLogin")).click();
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// step 3
		// move mouse to women
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"))).perform();
		
		// step 4
		// click t-shirt
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
		
		// step 5, 6
		// hover product and click it
		mouse.moveToElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li"))).perform();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]")).click();
		
		// step 7
		
		// step 8, 9
		// select size M and color
		Select size = new Select(driver.findElement(By.id("group_1")));
		size.selectByIndex(1);
		
		driver.findElement(By.id("color_14")).click();
		
		// step 10
		// click add
		driver.findElement(By.name("Submit")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// step 11
		// select process
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// inc number
		String price = driver.findElement(By.id("total_product_price_1_4_467845")).getText().toString();
		driver.findElement(By.id("cart_quantity_up_1_4_0_467845")).click();
		
		// find a change
		String priceChange;
		do {
			priceChange = driver.findElement(By.id("total_product_price_1_4_467845")).getText().toString();
		} while(priceChange.equals(price));
		
		System.out.println("Old price: "+price + " and new Price: " + priceChange);

		// is that true price?
		double price1 = Double.parseDouble(price.substring(1, price.length()));
		double price2 = Double.parseDouble(priceChange.substring(1, priceChange.length()));
		
		if (price1 + price1 == price2) System.out.println("It is real price");
		else System.out.println("The price is fake");
 		
		System.out.println("Finish");
		// close
		driver.close();
	}
	
}