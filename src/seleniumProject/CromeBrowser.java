package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		// set the system property so that chrome driver is located
				System.getProperty("webdriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
				
				//Create the object of browser interface
				WebDriver driver=new ChromeDriver();
				
				//launch URL
				driver.get("https://www.facebook.com/login/");
				
				driver.manage().window().maximize();
				
				driver.findElement(By.id("email")).sendKeys("xyz@gmail.com");
				driver.findElement(By.id("pass")).sendKeys("123456789");
				//Thread.sleep(3000);
				//driver.close();
				driver.quit();

	}

}
