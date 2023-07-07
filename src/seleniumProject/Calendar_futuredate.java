package seleniumProject;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calendar_futuredate {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.Driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		
		try
		{
			driver.findElement(By.xpath("//h3[text()=\"Login/Signup\"]")).isDisplayed();
			
			driver.findElement(By.xpath("//span[@class=\"logSprite icClose\"]")).click();
		}
		catch(NoSuchElementException popup1)
		{
			System.out.println("This Login/Signup pop-up is not visible");
		}
		
		try
		{
			driver.findElement(By.xpath("//div[@class=\"sc-jlwm9r-9 jxtYFR\"]")).isDisplayed();
			
			driver.findElement(By.xpath("//p[@class=\"sc-jlwm9r-1 dRQhOp\"]")).click();
		}
		catch(NoSuchElementException popup2)
		{
			System.out.println("QR Code popup is not visible");
		}
		
		driver.findElement(By.xpath("//span[text()=\"Departure\"]/../p/span")).click();
		Thread.sleep(5000);
		
		List<WebElement> dateclick=driver.findElements(By.xpath("//div[contains(@class,\"DayPicker-Day\") and @aria-disabled=\"false\" and contains(@aria-label,\"Jun\")]"));
		
		List<WebElement> datetext=driver.findElements(By.xpath("//div[contains(@class,\"DayPicker-Day\") and @aria-disabled=\"false\" and contains(@aria-label,\"Jun\")]/p"));
		
		int countdates=dateclick.size();
		
		for (int i=0; i<countdates; i++)
		{
			String datetextvalue=datetext.get(i).getText();
			System.out.println(datetextvalue);
			
			if(datetextvalue.equalsIgnoreCase("18"))
			{
				dateclick.get(i).click();
				break;
			}
			else
			{
				System.out.println("Desired date not found");
			}
		}
		
		driver.findElement(By.xpath("//span[text()=\"Done\"]")).click();
		Thread.sleep(5000);
		driver.quit();
	}

}
