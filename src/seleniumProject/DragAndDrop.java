package seleniumProject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class DragAndDrop {

	public static void main(String[] args)  {
		System.setProperty("WebDriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Actions act=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//switch to a frame
		WebElement frame=driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
		driver.switchTo().frame(frame);
		
		WebElement dragelement= driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement dropelement=driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		
		act.dragAndDrop(dragelement, dropelement).build().perform();
		
		//switch to parent frame
		driver.switchTo().parentFrame();
		
		//scroll
		WebElement ScrollTarget=driver.findElement(By.xpath("//a[text()=\"Widget Factory\"]"));
		js.executeScript("arguments[0].scrollIntoView();", ScrollTarget);
		ScrollTarget.click();
		
		driver.quit();
	}

}
