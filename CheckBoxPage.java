package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxPage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();// Importing the driver files
		ChromeDriver driver = new ChromeDriver();

		// Launching the webpage
		
		driver.get("http://www.leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		// 1.Select the languages that you know?
		// Selecting J
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[1]")).click();
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[2]")).click();

		// 2.Confirm Selenium is checked
		WebElement checked = driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[6]"));
		if (checked.isSelected())
			System.out.println("Selenium is checked");
		else
			System.out.println("Selenium is not checked");

		// 3.DeSelect only checked
		WebElement deselect = driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[8]"));
		deselect.click();

		// 4.Select all below checkboxes
		
		/*driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[9]")).click();
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[10]")).click();
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[11]")).click();
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[12]")).click();
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[13]")).click();*/
		
		
        int size = driver.findElementsByXPath("//label[text()='Select all below checkboxes ']/following::input").size();
        System.out.println(size);
        
        
        for (int i = 1    ; i <= size; i++) {
            
            driver.findElementByXPath("(//label[text()='Select all below checkboxes ']/following::input)["+i+"]").click();

	}

}}
