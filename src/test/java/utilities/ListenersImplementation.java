package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersImplementation extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	    ITestListener.super.onTestStart(result);
	    System.out.println("Test case Started: " + result.getName());
	    Reporter.log("Opening browser for test Execution");

	    Object[] params = result.getParameters();

	    // Show date in test name if DataProvider
	    if (params != null && params.length > 0) {
	        String date = params[0].toString(); // "20/06/26"
	        test = extent.createTest(result.getName() + " | Date: " + date);
	    } else {
	        test = extent.createTest(result.getName());
	    }

	    test.info("Test Started");
	}

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("******** PASSED TEST ----> " + result.getName());
        Reporter.log("******** Test Case Successful ----> " + result.getName());

        // ── ExtentReports: log pass ──────────────────────────────
        test.pass("✅ Test Passed: " + result.getName());
        // ────────────────────────────────────────────────────────
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("******** FAILED TEST ----> " + result.getName());
        System.out.println("******** FAILURE REASON ----> " + result.getThrowable());
        Reporter.log("******** Test Case Failed -----> Taking Screenshot");

        // ── ExtentReports: log failure reason ───────────────────
        test.fail("❌ Test Failed: " + result.getName());
        test.fail("Reason: " + result.getThrowable());
        // ────────────────────────────────────────────────────────

        // Taking screenshot
        TakesScreenshot srcshot = (TakesScreenshot) driver;
        File srcFile = srcshot.getScreenshotAs(OutputType.FILE);

        // Generate timestamp
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        // Create destination file path
        String screenshotPath = ConstantsData.ConstsntData.FAILED_SCREEN_SHOT_PATH
                + result.getName()
                + "_"
                + timestamp
                + ".png";

        File destFile = new File(screenshotPath);

        try {
            destFile.getParentFile().mkdirs();
            FileUtils.copyFile(srcFile, destFile);

            // ── ExtentReports: attach screenshot to report ───────
            test.addScreenCaptureFromPath(destFile.getAbsolutePath(),
                    "Failure Screenshot");
            // ────────────────────────────────────────────────────
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Screenshot captured at: " + destFile.getAbsolutePath());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("******** SKIPPED TEST ----> " + result.getName());

        // ── ExtentReports: log skip ──────────────────────────────
        test.skip("⚠️ Test Skipped: " + result.getName());
        // ────────────────────────────────────────────────────────
    }
}