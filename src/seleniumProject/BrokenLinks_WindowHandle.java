package seleniumProject;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class BrokenLinks_WindowHandle {

	public static void main(String[] args) throws IOException {
		 System.setProperty("webdriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
	     driver.get("https://www.toolsqa.com/");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     WebDriverWait exp_wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     
	     Actions act=new Actions(driver);
	     JavascriptExecutor jsp=(JavascriptExecutor) driver;
	     
	     //scroll to bottom of screen
	     WebElement Scrolltarget=driver.findElement(By.xpath("//div[contains(text(),\"All rights reserved\")]"));
	     jsp.executeScript("arguments[0].scrollIntoView();", Scrolltarget);
	     
	     //fetch the hyperlinks
	     List<WebElement> hyperlinks=exp_wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[text()=\"Recent Tutorials\"]/../ul/li/a"))));
	     
	     int count=hyperlinks.size();
	     //open all hyperlinks into new window
	     for (int i=1; i<count; i++)
	     {
	    	 act.moveToElement(hyperlinks.get(i)).keyDown(Keys.CONTROL).click().build().perform();
	     }
	     //verify if hyperlinks are open correctly
	     Set<String> windows=driver.getWindowHandles();
	     Iterator<String>windowsIterator=windows.iterator();
	     windowsIterator.next();
	     
	     while(windowsIterator.hasNext())
	     {
	    	 driver.switchTo().window(windowsIterator.next());
	    	 String windowTitle=driver.getTitle();
	    	 windowTitle=windowTitle.replaceAll("[^a-zA-Z0-9]", " ");
	    	 System.out.println(windowTitle);
	    	 
	    	 File ScreenshotSource=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	 File ScreenshotFile=new File("C:\\Users\\Dell\\Desktop\\Brokenlink_Screenshots\\"+windowTitle+".png");
	    	 Files.copy(ScreenshotSource, ScreenshotFile);
	     }
	     driver.quit();
	}

}
