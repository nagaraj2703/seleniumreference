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

public class automatetry {

		    public static void main(String[] args) {
		        System.setProperty("webdriver.chrome.driver", "D:\\automation\\selenium\\Supportingsoftware\\chromedriver.exe");
		        WebDriver driver = new ChromeDriver();
		        driver.get("https://www.makemytrip.com/");
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		        WebDriverWait exp_wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        // Popup handle
		        try 
		        {
		            WebElement mobileNumberInput = driver.findElement(By.xpath("//input[@placeholder=\"Enter Mobile number\"]"));
		            if (mobileNumberInput.isDisplayed()) 
		            {
		                WebElement closeButton = driver.findElement(By.xpath("//span[@data-cy=\"handleSnackbarClose\"]"));
		                closeButton.click();
		            }
		        } 
		        catch (NoSuchElementException popup2) 
		        {
		            System.out.println("Popup 2 is not visible");
		        }

		        // From tab handle
		        driver.findElement(By.xpath("//span[text()=\"From\"]")).click();

		        WebElement from = driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
		        from.sendKeys("Mumbai");

		        List<WebElement> optionClick = driver.findElements(By.xpath("//ul[@role=\"listbox\"][1]/li"));
		        exp_wait.until(ExpectedConditions.visibilityOfAllElements(optionClick));

		        List<WebElement> optionText = driver.findElements(By.xpath("//ul[@role=\"listbox\"][1]/li/div[1]/div[1]/p[1]"));
		        exp_wait.until(ExpectedConditions.visibilityOfAllElements(optionText));

		        int countFrom = optionText.size();

		        for (int i = 0; i < countFrom; i++) 
		        {
		            String optionValue = optionText.get(i).getText();
		            System.out.println(optionValue);
		            if (optionValue.equalsIgnoreCase("Mumbai, India")) 
		            {
		                optionClick.get(i).click();
		                break; // Exit the loop once the desired option is found and clicked
		            } 
		            else 
		            {
		                System.out.println("Desired value not found in current iteration " + i + " Hence retrying");
		            }
		        }

		        // To tab handle
		        driver.findElement(By.xpath("//span[text()=\"To\"]")).click();

		        WebElement to = driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));
		        to.sendKeys("Delhi");

		        List<WebElement> optionClickTo = driver.findElements(By.xpath("//ul[@role=\"listbox\"][1]/li"));
		        List<WebElement> optionTextTo = driver.findElements(By.xpath("//ul[@role=\"listbox\"][1]/li/div/div/p"));

		        int countTo = optionTextTo.size();

		        for (int i = 0; i < countTo; i++) 
		        {
		            String optionValue = optionTextTo.get(i).getText();
		            System.out.println(optionValue);
		            if (optionValue.equalsIgnoreCase("New Delhi, India")) 
		            {
		                optionClickTo.get(i).click();
		                break; // Exit the loop once the desired option is found and clicked
		            } 
		            else 
		            {
		                System.out.println("Desired value not found in current iteration " + i + " Hence retrying");
		            }
		        }

		        // Date handle
		        driver.findElement(By.xpath("//span[text()=\"Departure\"]/../p/span")).click();

		        List<WebElement> dateClick = driver.findElements(By.xpath("//div[contains(@aria-label,\"Jun\") and @aria-disabled=\"false\"]"));
		        List<WebElement> dateText = driver.findElements(By.xpath("//div[contains(@aria-label,\"Jun\") and @aria-disabled=\"false\"]/div[1]/p[1]"));

		        int countDate = dateText.size();

		        for (int i = 0; i < countDate; i++) 
		        {
		            String optionDateValue = dateText.get(i).getText();
		            System.out.println(optionDateValue);
		            if (optionDateValue.equalsIgnoreCase("28")) 
		            {
		                dateClick.get(i).click();
		                break; // Exit the loop once the desired date is found and clicked
		            } 
		            else 
		            {
		                System.out.println("Desired date not found " + i + " Hence retrying");
		            }
		        }

		        // Handle travelers and class
		        driver.findElement(By.xpath("//span[text()=\"Travellers & Class\"]")).click();

		        List<WebElement> adultsClick = driver.findElements(By.xpath("//div[@data-cy=\"flightTraveller\"]/div[1]/div[1]/ul[1]/li"));
		        List<WebElement> adultsText = driver.findElements(By.xpath("//div[@data-cy=\"flightTraveller\"]/div[1]/div[1]/ul[1]/li"));

		        int countAdults = adultsText.size();

		        for (int i = 0; i < countAdults; i++) 
		        {
		            String optionAdultsValue = adultsText.get(i).getText();
		            System.out.println(optionAdultsValue);
		            if (optionAdultsValue.equalsIgnoreCase("2")) 
		            {
		                adultsClick.get(i).click();
		                break; // Exit the loop once the desired option is found and clicked
		            } 
		            else 
		            {
		                System.out.println("Desired value not found " + i + " Hence retrying");
		            }
		        }

		        driver.findElement(By.xpath("//button[text()=\"APPLY\"]")).click();

		        driver.findElement(By.xpath("//a[text()=\"Search\"]")).click();

		        // Close the driver after completing the operations
		        driver.quit();
		    }
	}
