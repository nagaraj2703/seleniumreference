package seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class microsoftEdgeBrowser {

	public static void main(String[] args) {
		System.getProperty("webdriver.edge.driver", "D:\\automation\\selenium\\Supportingsoftware\\microsoftedge\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.bing.com/search?pglt=41&q=redbus&cvid=18669fbff1be47448e13c951951875c8&aqs=edge.0.0l9.2683j0j1&FORM=ANNTA1&PC=U531");

	}

}
