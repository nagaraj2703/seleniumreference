package seleniumProject;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		//set the system property so that chrome driver is located
		System.setProperty("WebDriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		
		//create the object of browser interface
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		//launching google home page
		driver.manage().window().maximize();
		
		//input search text
		driver.findElement(By.xpath("//textarea[@title=\"Search\"]")).sendKeys("Automation");
		//finding search text and send the text to find content by using search bar xpath
		
		Thread.sleep(6000);
		//wait for 6 seconds to appear suggestions
		
		//using 2 xpath 1)click-it is ot giving text 2)text- it is not click able
		List<WebElement> clickoption=driver.findElements(By.xpath("//li[@data-view-type=\"1\"]"));
		List<WebElement> textoption=driver.findElements(By.xpath("//li[@data-view-type=\"1\"]/div/div[2]/div[1]/div[1]/span"));
		//the webelemets will save in the list
		
		//the listed webelements passing through iteration and verifying whether entered key word is there are no 
		//if the key is there then it open the page if not it will show the sysout statement
		int count=textoption.size();
		
		for(int i=0; i<count; i++)
		{
			String optionvalue=textoption.get(i).getText();
			System.out.println(optionvalue);
			
			if(optionvalue.equalsIgnoreCase("Automation"))
			{
				clickoption.get(i).click();
			}
			else
			{
				System.out.println("desired value not found in current iteration");
			}
		}
		driver.quit();
	}

}
