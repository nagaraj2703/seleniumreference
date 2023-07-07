package seleniumProject;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.goibibo.com/");
		
		driver.manage().window().maximize();
		
		//handle login popup
		try
		{
		driver.findElement(By.xpath("//h3[text()=\"Login/Signup\"]")).isDisplayed();

		driver.findElement(By.xpath("//span[@class=\"logSprite icClose\"]")).click();
		}
		catch(NoSuchElementException popup1)
		{
			System.out.println("This Login/Signup pop-up is not visible");
		}
		
		//handle QR popup
		try
		{
		driver.findElement(By.xpath("//div[@class=\"sc-jlwm9r-9 jxtYFR\"]")).isDisplayed();
		
		driver.findElement(By.xpath("//p[@class=\"sc-jlwm9r-1 dRQhOp\"]")).click();
		}
		catch(NoSuchElementException popup2)
		{
			System.out.println("QR Code popup is not visible");
		}
		
		//finding departure xpath using that automating to click on departure
		driver.findElement(By.xpath("//span[text()=\"Departure\"]/../p/span")).click();
		Thread.sleep(5000);
		
		//finding current date xpath using that automating to click on current date
		driver.findElement(By.xpath("//div[contains(@class,\"DayPicker-Day--today\")]")).click();
		
		//using done xpath automating to click on done
		driver.findElement(By.xpath("//span[text()=\"Done\"]")).click();
		
		driver.quit();
	}

}
