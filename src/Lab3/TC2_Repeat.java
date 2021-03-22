package Lab3;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_Repeat {
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
	    
//=================================================================
	    
	    // create array
//	    1 . Amazon.in Bestsellers: The most popular items on Amazon
//	    2 . Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in
//	    3 . Amazon.in Today's Deals: Great Savings. Every Day.
//	    4 . Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids
//	    5 . Amazon.in Hot New Releases: The bestselling new and future releases on Amazon
//	    6 . Amazon.in: Amazon Prime
//	    7 . Electronics Store: Buy Electronics products Online at Best Prices in India at Amazon.in
//	    
	    String[] title = {
	    		""
	    		, "Amazon.in Bestsellers: The most popular items on Amazon"
	    		, "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in"
	    		, "Amazon.in Today's Deals: Great Savings. Every Day."
	    		, "Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids"
	    		, "Amazon.in Hot New Releases: The bestselling new and future releases on Amazon"
	    		, "Amazon.in: Amazon Prime"
	    		, "Electronics Store: Buy Electronics products Online at Best Prices in India at Amazon.in"
	    	};
	    
	    for (int i = 1 ; i < title.length ; i ++) {	  
	    	System.out.println("Dang vao trang: " + title[i]);
	    	
		    // teps 5
		    // click to pay
		    WebElement pay = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a["+i+"]"));
		    pay.click();
		    
		    //teps 6
		    //Get Page title and verify it with expected value.
		    String titleXpath = driver.getTitle();
		    
		    // compare
		    if (titleXpath.contains(title[i])) {
		    	System.out.println("Giong nhau");
		    	System.out.printf("" + titleXpath + "\n");
		    }
		    else {
		    	System.out.println("Khac nhau");
		    	System.out.printf("Luc dau: " + titleXpath + "\n");
		    	System.out.printf("Luc sau: " + title[i] + "\n" );
		    }
		    
		    //teps 7
		    // navagate back
		    driver.navigate().back();
	
		    //teps 8
		    // get Title page and print
		    String titleBackHome = driver.getTitle();
		    
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
	    }
	    
//=================================================================	    
	    System.out.println("Finish");
	    //quit
	    driver.quit();
	}
}
