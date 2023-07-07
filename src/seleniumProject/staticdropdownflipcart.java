package seleniumProject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class staticdropdownflipcart {

	public static void main(String[] args) {
		System.getProperty("webdriver.chrome.driver","D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement dropdown=driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
		Select staticdropdown=new Select(dropdown);
		
		//staticdropdown.selectByIndex(4);
		//staticdropdown.selectByValue("search-alias=beauty");
		//staticdropdown.selectByVisibleText("Appliances");
		List<WebElement> dropdownoption=driver.findElements(By.xpath("//select[@id=\"searchDropdownBox\"]/option"));
		int count=dropdownoption.size();
		for (int i=0; i<count; i++)
		{
			staticdropdown.selectByIndex(i);
		}
		driver.quit();
	}

}
