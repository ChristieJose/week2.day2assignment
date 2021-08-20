package week2.day2;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();//loading driver
		ChromeDriver driver= new ChromeDriver(); //create object
		//lanuch webpage
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		// 1.Enter your email address
		driver.findElement(ByXPath("//input[@id='email']")).sendKeys("janu@gmail.com");

		// 2.Append a text and press keyboard tab
		driver.findElement(By.xpath("//input[@value = 'Append ']")).sendKeys("Text \t");

		// 3.Get default text entered
		WebElement getText = driver.findElement(By.xpath("//input[@value = 'TestLeaf']"));
		String getTextValue = getText.getAttribute("value");
		System.out.println("The Default Text entered is : " + getTextValue);

		// 4.Clear the text
		WebElement clearText = driver.findElement(By.xpath("//input[@value = 'Clear me!!']"));
		clearText.clear();

		// 5.Confirm that edit field is disabled
		WebElement isEnable = driver.findElement(By.xpath("//input[@disabled = 'true']"));
		boolean isEnabledvalue = isEnable.isEnabled();

		// Verifying and Printing the result
		if (isEnabledvalue)
			System.out.println("The button is Enabled");
		else
			System.out.println("The button is Disabled");

	}

	private static By ByXPath(String string) {
		// TODO Auto-generated method stub
		return null;
	}




}

