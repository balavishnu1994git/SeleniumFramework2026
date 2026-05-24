package TestClass;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageClass.LogInPage;
import PageClass.LogOutPage;
import utilities.BaseClass;
import utilities.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public  class LogInTest extends BaseClass{
	
	
	@Test(priority = 0, groups = "Regression1")
    public void verifyLogin() throws IOException, InterruptedException
    {
        login();
        
        
        boolean isLogoutVisible =
                waitForVisibility(LogInPage.ClickLogOutcheck()).isDisplayed();

        if(isLogoutVisible== true)
        {
        	System.out.println("log in sucess");
        }
        
    }

}
