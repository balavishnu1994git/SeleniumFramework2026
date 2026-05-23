package TestClass;

import utilities.BaseClass;
import utilities.ListenersImplementation;
import utilities.TestContext;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import PageClass.BookAppoinmentPage;
import PageClass.CreateNewAppoinmentPage;

@Listeners(ListenersImplementation.class)
public class BookAppoinmentTest extends BaseClass {
	
	 @Test(priority = 2,groups = "Regression8")
    public void verifyAppointmentDate() throws IOException, InterruptedException {
	
		LogInTest.login();
		waitForPageLoad();
		
		//from line 30 to 40 is re writen it is same as " CreateNewAppoinmentTest" 
		//but the out put or section of this test is not stored as it is a demo site so we need to re write it
		// normaly we take the appoinment details from db and validate   thats the normal fare work style
		
		WebElement ele= driver.findElement(CreateNewAppoinmentPage.Facility());
		Select oselect = new Select(ele);
		oselect.selectByIndex(1);
		
		driver.findElement(CreateNewAppoinmentPage.Readmission()).click();
        driver.findElement(CreateNewAppoinmentPage.HealthCarePgrm()).click();
        driver.findElement(CreateNewAppoinmentPage.VisitDate()).sendKeys("30/06/26");
        
        driver.findElement(CreateNewAppoinmentPage.AnyComment()).sendKeys("doc visit 3");
        driver.findElement(CreateNewAppoinmentPage.btnBookAppoinment()).click();
		
		
		
		
		driver.get("https://katalon-demo-cura.herokuapp.com/history.php#history");
	    int totalCount = driver.findElements(BookAppoinmentPage.appointmentDates()).size();
	    
	    System.out.println("count :"+totalCount);
	    if (totalCount>0)
	    {
	    	System.out.println("Appoinment Created BookAppoinmentTest ");
	    }
	    
	    String datedemo="30/06/26";
	    boolean flag3=waitForVisibility(CreateNewAppoinmentPage.appointmentDate(datedemo)).isDisplayed();
		 if(flag3==true)
		 {
			 System.out.println("Appoinment created on date :"+datedemo);
		 }
			
}
	


}
