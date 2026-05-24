package PageClass;

import org.openqa.selenium.By;

public class CreateNewAppoinmentPage {

	
	public static By Facility()
	{
		return By.xpath("//select[@id='combo_facility']") ;
	}
	

	public static By Readmission()
	{
		return By.xpath("//input[@id='chk_hospotal_readmission']") ;
		//return By.xpath("//input[@id='chk_hospotal_readmissionhujk']") ;  this code is for error while running
	}
	
	
	public static By HealthCarePgrm()
	{
		return By.xpath("//input[@name='programs' and @value='Medicaid']") ;
	}
	
	
	public static By VisitDate()
	{
		return By.xpath("//input[@id='txt_visit_date']") ;
		
		
	}
	
	public static By AnyComment()
	{
		return By.xpath("//textarea[@id='txt_comment']") ;
	}
	
	public static By btnBookAppoinment()
	{
		return By.xpath("//button[@id='btn-book-appointment']") ;
	}
	
	public static By validateAppmt()
	{
		return By.xpath("//*[text()='Appointment Confirmation']");
	}
	
	public static By validateMSG()
	{
		return By.xpath("//*[contains(text(),'Please ')]");
	}
	
	public static By appointmentDate(String expectedDate)
    {
        return By.xpath(
            "//div[@class='panel-heading' and text()='"+ expectedDate +"']"
                       );
   }
	
}
