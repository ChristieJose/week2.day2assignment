package week2.day2;
/*http://leaftaps.com/opentaps/control/main

Delete Lead:
1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Phone
9	Enter phone number
10	Click find leads button
11	Capture lead ID of First Resulting lead
12	Click First Resulting lead
13	Click Delete
14	Click Find leads
15	Enter captured lead ID
16	Click find leads button
17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
18	Close the browser (Do not log out)
*/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Input Username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click login
		driver.findElement(By.className("decorativeSubmit")).click();

		// CLick CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click Leads tab
		driver.findElement(By.linkText("Leads")).click();

		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click on Phone
		driver.findElement(By.linkText("Phone")).click();

		//Input phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("7306511293");

		// Click Find Leads
		WebElement findLeads = driver.findElement(By.xpath("//button[text() = 'Find Leads']"));
		findLeads.click();

		Thread.sleep(3000);

		// Capture Lead id of first result and click it
		WebElement search = driver
				.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a"));
		String leadId = search.getText();
		System.out.println("The leadId is :" + leadId);
		search.click();

		// Delete the Leadid
		driver.findElement(By.className("subMenuButtonDangerous")).click();

		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Search for captured id
		driver.findElement(By.name("id")).sendKeys(leadId);

		// Click Find Lead
		driver.findElement(By.xpath("//button[text() ='Find Leads']")).click();

		// Verification of delete
		boolean displayed = driver.findElement(By.xpath("//div[text() = 'No records to display']")).isDisplayed();
		if (displayed)
			System.out.println("TEst pass!! Delete lead successful");
		else
			System.out.println("TEst fail");

	}

}
