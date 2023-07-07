package seleniumProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateWebsite {

	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait exp_wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//pop handle
		try
		{
			driver.findElement(By.xpath("//input[@placeholder=\"Enter Mobile number\"]")).isDisplayed();
			driver.findElement(By.xpath("//span[@data-cy=\"handleSnackbarClose\"]")).click();
		}
		catch(NoSuchElementException popup2)
		{
			System.out.println("Popup 2 is not visible");
		}
		
		//from tab handle
		driver.findElement(By.xpath("//span[text()=\"From\"]")).click();
		
		WebElement from=driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
		exp_wait.until(ExpectedConditions.visibilityOf(from)).sendKeys("Mumbai");
		
		List <WebElement> optionclick=driver.findElements(By.xpath("//ul[@role=\"listbox\"][1]/li"));
		exp_wait.until(ExpectedConditions.visibilityOfAllElements(optionclick));
		
		List <WebElement> optiontext=driver.findElements(By.xpath("//ul[@role=\"listbox\"][1]/li/div[1]/div[1]/p[1]"));
		exp_wait.until(ExpectedConditions.visibilityOfAllElements(optiontext));
		
		int countfrom=exp_wait.until(ExpectedConditions.visibilityOfAllElements(optiontext)).size();
		
		for(int i=0; i<countfrom; i++)
		{
			String optionvalue=optiontext.get(i).getText();
			System.out.println(optionvalue);
			if (optionvalue.equalsIgnoreCase("Mumbai, India"))
			{
				exp_wait.until(ExpectedConditions.visibilityOf(optionclick.get(i))).click();
			}
			else
			{
				System.out.println("Desired value not found in current iteration"+i+"Hence retrying");
			}
		}
		
		//to tab handle
		driver.findElement(By.xpath("//span[text()=\"To\"]")).click();
		
		WebElement to=driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));
		exp_wait.until(ExpectedConditions.visibilityOf(to)).sendKeys("Delhi");
		
		List<WebElement> option_click=driver.findElements(By.xpath("//ul[@role=\"listbox\"][1]/li"));
		List<WebElement> option_text=driver.findElements(By.xpath("//ul[@role=\"listbox\"][1]/li/div/div/p"));
		
		int countTo=exp_wait.until(ExpectedConditions.visibilityOfAllElements(option_text)).size();
		
		for(int i=0; i<countTo; i++)
		{
			String option_value=option_text.get(i).getText();
			System.out.println(option_value);
			if(option_value.equalsIgnoreCase("New Delhi, India"))
			{
				exp_wait.until(ExpectedConditions.visibilityOf(option_click.get(i))).click();
			}
			else
			{
				System.out.println("Desired value not found in current iteration"+i+"Hence retrying");
			}
		}
		
		//date handle
		driver.findElement(By.xpath("//span[text()=\"Departure\"]/../p/span")).click();
		
		List<WebElement> dateclick=driver.findElements(By.xpath("//div[@class=\"DayPicker-Day\" and contains(@aria-label,\"Jun\") and @aria-disabled=\"false\"]"));
		List<WebElement> datetext=driver.findElements(By.xpath("//div[@class=\"DayPicker-Day\" and contains(@aria-label,\"Jun\") and @aria-disabled=\"false\"]/div[1]/p[1]"));
		
		int countdate=exp_wait.until(ExpectedConditions.visibilityOfAllElements(datetext)).size();
		
		for(int i=0; i<countdate; i++)
		{
			String option_datevalue=datetext.get(i).getText();
			System.out.println(option_datevalue);
			if(option_datevalue.equalsIgnoreCase("23"))
			{
				exp_wait.until(ExpectedConditions.visibilityOf(dateclick.get(i))).click();
			}
			else
			{
				System.out.println("Desired date not found"+i+"Hence retrying");
			}
		}
		
		//handle travellers and class
		driver.findElement(By.xpath("//span[text()=\"Travellers & Class\"]")).click();
		
		List<WebElement> adultsclick=driver.findElements(By.xpath("//div[@data-cy=\"flightTraveller\"]/div[1]/div[1]/ul[1]/li"));
		List<WebElement> adultstext=driver.findElements(By.xpath("//div[@data-cy=\"flightTraveller\"]/div[1]/div[1]/ul[1]/li"));
		
		int countadults=exp_wait.until(ExpectedConditions.visibilityOfAllElements(adultstext)).size();
		
		for(int i=0; i<countadults; i++)
		{
			String optionadultsvalue=adultstext.get(i).getText();
			System.out.println(optionadultsvalue);
			if(optionadultsvalue.equalsIgnoreCase("2"))
			{
				exp_wait.until(ExpectedConditions.visibilityOf(adultsclick.get(i))).click();
			}
			else
			{
				System.out.println("Desired value not found"+i+"Hence retrying");
			}
		}
		
		driver.findElement(By.xpath("//button[text()=\"APPLY\"]")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Search\"]")).click();
	}

}
