package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.v136.page.model.Screenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersImplementation extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("Test case Started");
		Reporter.log("Opening browser for text Exexution");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

	    // calling parent implementation
	    ITestListener.super.onTestSuccess(result);

	    // Print success test name in console
	    System.out.println("******** PASSED TEST ----> "
	            + result.getName());

	    // Reporter log
	    Reporter.log("******** Test Case Successful ----> "
	            + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

	    // calling parent implementation
	    ITestListener.super.onTestFailure(result);

	    // Print failed test name
	    System.out.println("******** FAILED TEST ----> "
	            + result.getName());

	    // Print actual exception reason
	    System.out.println("******** FAILURE REASON ----> "
	            + result.getThrowable());

	    Reporter.log("******** Test Case Failed -----> Taking Screenshot");

	    // Taking screenshot
	    TakesScreenshot srcshot = (TakesScreenshot) driver;

	    File srcFile = srcshot.getScreenshotAs(OutputType.FILE);

	    // Generate timestamp
	    String timestamp = LocalDateTime.now()
	            .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

	    // Create destination file path
	    File destFile = new File(
	            ConstantsData.ConstsntData.FAILED_SCREEN_SHOT_PATH
	            + result.getName()
	            + "_"
	            + timestamp
	            + ".png"
	    );

	    try {

	        // create folder if not exists
	        destFile.getParentFile().mkdirs();

	        // copy screenshot to destination
	        FileUtils.copyFile(srcFile, destFile);

	    } catch (IOException e) {

	        e.printStackTrace();
	    }

	    // print screenshot location
	    System.out.println("Screenshot captured at: "
	            + destFile.getAbsolutePath());
	}

}
