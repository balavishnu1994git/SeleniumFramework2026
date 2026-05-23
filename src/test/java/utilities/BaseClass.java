package utilities;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageClass.LogInPage;

import org.openqa.selenium.TimeoutException;

public class BaseClass 
{
	public static WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	
	
	
	public void LaunchBrowser() throws IOException, InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--incognito");
		
		String BrowserName=FetchDataFromProperty.getDataFromProperty().getProperty("browserName");
		String URL=FetchDataFromProperty.getDataFromProperty().getProperty("url");
		
//		System.out.println("BrowserName "+BrowserName);
//		System.out.println("URL "+URL);
//		
	
	
			if(BrowserName.equalsIgnoreCase("chrome"))
				{   driver= new ChromeDriver(options);
					driver.get(URL);
					driver.manage().window().maximize();
	            }
	
//	if(BrowserName.equalsIgnoreCase("firefox"))
//	{
//		driver= new ChromeDriver();
//		driver.get("URL");
//		driver.manage().window().maximize();
//		
//		
//	}
	
	}
	
	
	
	public static void login() throws IOException, InterruptedException
	{
	
		driver.findElement(LogInPage.HandburgerMenu()).click();//calling the static method of login page class
		driver.findElement(LogInPage.ClickLogin()).click();
		driver.findElement(LogInPage.UserName()).sendKeys(FetchDataFromExcel.getUserCredentials(1,0)); //calling the static method of fetch data from excel class
		driver.findElement(LogInPage.Password()).sendKeys(FetchDataFromExcel.getUserCredentials(1, 1));
		driver.findElement(LogInPage.SubmitButton()).click();
		
		
	}
	
	public void scrollDown() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
	}
    
	
	
	
	public void acceptAlertIfPresent() {

	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
	        alert.accept();
	        System.out.println("Alert accepted");

	    } catch (TimeoutException e) {

	        System.out.println("No alert present");
	    }
	}
	
	
	
	
	public  void safeClick(WebElement element) 
	{                                           // used for wait until the vesiblity =true->
		                                        // safeClick(element); use like this
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));

	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].scrollIntoView(true);", element);
	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", element);
	}
	

	public WebElement waitForVisibility(By locator)
	{
	    WebDriverWait wait =
	        new WebDriverWait(driver, Duration.ofSeconds(10));

	    return wait.until(
	        ExpectedConditions.visibilityOfElementLocated(locator)
	    );
	}
	
	
	public void waitForPageLoad()
	{
	    WebDriverWait wait =
	        new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(webDriver ->
	        ((JavascriptExecutor) webDriver)
	        .executeScript("return document.readyState")
	        .equals("complete")
	    );
	}
	
	
	
	
	public static String generateRandomName() {

        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    }
	
	
	

@AfterMethod(alwaysRun = true)
	public void closeBrowser() 
	{
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
	}


}

