package Lab3;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Home {
	public static void main(String[] args) {
		// file path
		String ChromeDriver = new File("").getAbsolutePath() +"\\chromedriver.exe";
		// add driver
		System.setProperty("Webdriver.chrome.driver",ChromeDriver);
		WebDriver driver = new ChromeDriver();
		// add web url
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
		// fill
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("FirstName");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Last Name");
		
		// choice element from radio button
		driver.findElement(By.id("sex-0")).click();
		driver.findElement(By.id("exp-2")).click();
		
		// select date
		driver.findElement(By.id("datepicker")).sendKeys("12/03/2021");
		
		// select check box
		driver.findElement(By.id("profession-1")).click();
		driver.findElement(By.id("tool-1")).click();
		driver.findElement(By.id("tool-2")).click();
		
		// select dropdown item
		Select continents = new Select(driver.findElement(By.id("continents")));
		continents.selectByIndex(0);
		Select commands = new Select(driver.findElement(By.id("selenium_commands")));
		commands.selectByIndex(4);
		
		// select picture
		WebElement addImage = driver.findElement(By.id("photo"));
		addImage.sendKeys(new File("").getAbsolutePath() +"\\gris.png");
		
		// select link to download
		String href = driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div/div/div[29]/div[2]/div/a")).getAttribute("href");
		driver.get(href);
		
		// select Raw in Github
		driver.findElement(By.id("raw-url")).click();
		
		//get Text
		WebElement text = driver.findElement(By.xpath("/html/body/pre"));
		
		// get file name from url
		String currentURL = driver.getCurrentUrl();
	    System.out.println(currentURL);
	    String[] s = currentURL.split("/");
	    	
	    // write file
	    try {
			writeFile(s[s.length - 1], text.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		// back to home
		driver.navigate().back();
		driver.navigate().back();
		// submit		
		driver.findElement(By.id("submit")).click();
		
		System.out.println("Finish");
		// close
		driver.close();
	}
	
	public static void writeFile(String FileName, String Text) throws IOException{
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(new File("").getAbsolutePath() + "\\src\\Lab3\\" + FileName));
        writeFile.write(Text);
        writeFile.close();
    }
}