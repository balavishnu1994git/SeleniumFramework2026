package TestClass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageClass.LogOutPage;
import utilities.BaseClass;
import utilities.ListenersImplementation;


@Listeners(ListenersImplementation.class)
public class LogOutTest  extends BaseClass  {

	
	 @Test(priority = 3,groups = "Regression5")//,timeOut=10000       stope execution after 10000 seconds
	    public void verifyLogOut() throws IOException, InterruptedException {

	        login();

	        waitForPageLoad();

	        WebElement menu =
	                waitForVisibility(LogOutPage.HandburgerMenu());

	        safeClick(menu);

	        WebElement logout =
	                waitForVisibility(LogOutPage.ClickLogOut());

	        System.out.println("Log out clicked");
	        safeClick(logout);
	    }
	
}
