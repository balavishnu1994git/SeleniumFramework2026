package TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import PageClass.CreateNewAppoinmentPage;
import utilities.BaseClass;
import utilities.ListenersImplementation;
import utilities.TestContext;


@Listeners(ListenersImplementation.class)
public class CreateNewAppoinmentTest extends BaseClass {
	
	@DataProvider(name="bookAppoinment")
	public Object [][] dpMethod()
	{
	  return new Object [][]
			{
			{"20/06/26","Visit doc1"},
	        {"21/06/26","Visit doc2"}
			};
	}
	
	@Test(priority = 1,dataProvider="bookAppoinment",  groups = {"sanity", "Regression2"})//,retryAnalyzer=utilities.RetryAnalyzer.class)
	public void CreateAppoinment(String date,String description) throws IOException, InterruptedException
	{
		LogInTest.login();
		waitForPageLoad();
		WebElement ele= driver.findElement(CreateNewAppoinmentPage.Facility());
		Select oselect = new Select(ele);
		oselect.selectByIndex(1);
		
		driver.findElement(CreateNewAppoinmentPage.Readmission()).click();
        driver.findElement(CreateNewAppoinmentPage.HealthCarePgrm()).click();
        driver.findElement(CreateNewAppoinmentPage.VisitDate()).sendKeys(date);
        
        driver.findElement(CreateNewAppoinmentPage.AnyComment()).sendKeys(description);
        driver.findElement(CreateNewAppoinmentPage.btnBookAppoinment()).click();
       
       
        boolean flag1 =waitForVisibility(CreateNewAppoinmentPage.validateAppmt()).isDisplayed();

        boolean flag2 =waitForVisibility(CreateNewAppoinmentPage.validateMSG()).isDisplayed();

        		if(flag1 && flag2)
        		{
        		    System.out.println("The Appointment created");
        		}
        		
        		TestContext.appointmentDate = date;//saving the date to use in book appoinment cross checking 

        		TestContext.appointmentDescription = description;
        		
        		driver.get("https://katalon-demo-cura.herokuapp.com/history.php#history");
        		 boolean flag3=waitForVisibility(CreateNewAppoinmentPage.appointmentDate(date)).isDisplayed();
        		 if(flag3==true)
        		 {
        			 System.out.println("Appoinment created on date :"+date);
        		 }
        			
	}

}
