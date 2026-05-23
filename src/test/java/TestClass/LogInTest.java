package TestClass;


import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import utilities.BaseClass;
import utilities.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public  class LogInTest extends BaseClass{
	
	
	@Test(priority = 0, groups = "Regression1")
    public void verifyLogin() throws IOException, InterruptedException
    {
        login();
    }

}
