package PageClass;

import org.openqa.selenium.By;

public class LogInPage {
	
	
	public static By HandburgerMenu()
	{
		return By.xpath("//*[@id='menu-toggle']");
	}
	
	

	public static By ClickLogin()
	{
		return By.xpath("//*[text()='Login']");
	}
    
	
	public static By UserName()
	{
		return By.xpath("//*[@id='txt-username']");
	}
	
	public static By Password()
	{
		return By.xpath("//*[@id='txt-password']");
	}
	
	public static By SubmitButton()
	{
		return By.xpath("//*[@id='btn-login']");
	}
}


