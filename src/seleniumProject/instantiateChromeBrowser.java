package seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class instantiateChromeBrowser {

	public static void main(String[] args) {
		// set the system property so that chrome driver is located
		System.getProperty("webdriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		
		//Create the object of browser interface
		WebDriver driver=new ChromeDriver();
		
		//launch URL
		driver.get("https://www.google.com/search?q=cricbuzz&oq=&aqs=chrome.1.35i39i362l7j69i59i450.4969511j0j7&sourceid=chrome&ie=UTF-8");

	}

}
