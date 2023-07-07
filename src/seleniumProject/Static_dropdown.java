package seleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Static_dropdown {

	public static void main(String[] args) {
		//
		System.getProperty("webdriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement dropdown=driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
		Select Staticdropdown=new Select(dropdown);
		//Staticdropdown.selectByIndex(1);
		//Staticdropdown.selectByValue("search-alias=fashion");
		//Staticdropdown.selectByVisibleText("Amazon Pharmacy");
		//List<WebElement> dropdownoption=driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]/option"));
		List<WebElement> dropdownoption=driver.findElements(By.xpath("//select[@id=\"searchDropdownBox\"]/option"));
		int count=dropdownoption.size();
		for (int i=0; i<count; i++)
		{
			Staticdropdown.selectByIndex(i);
		}
		driver.quit();
	}

}
