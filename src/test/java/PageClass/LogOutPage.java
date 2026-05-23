package PageClass;

import org.openqa.selenium.By;

public class LogOutPage {
	
	public static By HandburgerMenu()
	{
		return By.xpath("//*[@id='menu-toggle']");
	}
	
	
	public static By ClickLogOut()
	{
		return By.xpath("//*[text()='Logout']");
		
	}
    
	

}
