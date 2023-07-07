package seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class instantiateFireforBrowser {

	public static void main(String[] args) {
		//Set the system property as that firefox driver is located
		System.setProperty("webdriver.gecko.driver", "D:\\automation\\selenium\\Supportingsoftware\\firefox\\geckodriver-v0.33.0-win32\\geckodriver.exe");
		
		//Create the object of browser interface
		WebDriver driver=new FirefoxDriver();
		
		//launch URL
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

	}

}
