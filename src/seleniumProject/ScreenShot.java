package seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		//
		System.setProperty("WebDriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//launch url
		driver.get("https://www.amazon.in/");
		//maximize the browser
		driver.manage().window().maximize();
		//implicit wait to find page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//get the title name of page
		String pagetitle=driver.getTitle();
		//removing the dots from the title
		pagetitle=pagetitle.replaceAll(".", "");
		//taking screen shots and temporarily saving in screenshotsource
		File ScreenShotSource=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//saving screen shot in the file and giving name as page title
		File Screenshotfile=new File("C:\\Users\\Dell\\Desktop\\selenium\\seleniumscreenshot\\"+pagetitle+".png");
		//copying screen shot in file
		Files.copy(ScreenShotSource, Screenshotfile);
		
		driver.quit();
	}

}
