package seleniumProject;

import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicandAutosuggestiveDropdown {

	public static void main(String[] args) {
		System.getProperty("WebDriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Create the object of Explicit Wait and define the maximum timeout
		WebDriverWait exp_wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement SearchBox=driver.findElement(By.xpath("//textarea[@title=\"Search\"]"));
		exp_wait.until(ExpectedConditions.visibilityOf(SearchBox)).sendKeys("Automation");
	
		List<WebElement> clickoption=driver.findElements(By.xpath("//li[@data-view-type=\"1\"]"));
		List<WebElement> textoption=driver.findElements(By.xpath("//li[@data-view-type=\"1\"]/div/div[2]/div[1]/div[1]/span"));
		
		int count=textoption.size();
		//int count=exp_wait.until(ExpectedConditions.visibilityOfAllElements(clickoption)).size();
		
		for (int i=0; i<count; i++)
		{
			String optionvalue=textoption.get(i).getText();
			System.out.println(optionvalue);
			
			if (optionvalue.equalsIgnoreCase("Automation"))
			{
				clickoption.get(i).click();
			}
			else
			{
				System.out.println("Desired value not found in current iteration");
			}
		}
		driver.quit();
	}

}
