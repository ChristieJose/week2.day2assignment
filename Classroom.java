package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom {
	public static void main(String[] args) {
		// Step 1: Download and set the path

				WebDriverManager.chromedriver().setup();

				// Step 2: Launch the chromebrowser
				ChromeDriver driver = new ChromeDriver();
				// Step 3: Load the URL https://en-gb.facebook.com/
				driver.get("http://leaftaps.com/opentaps");
				// Step 4: Maximise the window
				driver.manage().window().maximize();
				// Step 5: Add implicit wait
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
				
				// Step 7: Locate the Login button and click on it
				driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
				
				//String userNameText = driver.findElement(By.xpath("//label[text()='Username']")).getText();
				//System.out.println(" label :" + userNameText);
				
				
				// Step 8: Click on the crm/sfa link 
				driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
				
				driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
				
				
				
		    	// 	driver.findElement(By.xpath(null))
				
				
						
	}

}
