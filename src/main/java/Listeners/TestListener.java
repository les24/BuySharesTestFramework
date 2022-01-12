package Listeners;

import ExtentReporters.ExtentFactory;
import ExtentReporters.ExtentReporter;
import com.aventstack.extentreports.*;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import utils.Common;


public class TestListener implements ITestListener {

    ExtentReports report = ExtentReporter.ExtentGenerator();

    public ExtentTest test;
    static Logger logger = Logger.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("============================ Error "+ result.getName() + " test has failed ============================");
        String screenshotPath = Common.captureScreenshot(result);
        ExtentFactory.getTest().fail("============================ Error "+ result.getName() +" test has failed ============================",
                 MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        ExtentFactory.getTest().log(Status.FAIL, result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" Test Skipped! ");
        ExtentFactory.getTest().log(Status.SKIP, result.getMethod().getDescription());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" Test Skipped but passed percentage! ");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" Test Failed with timeout!");
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentFactory.setTest(test);
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info(context.getName() +" Finished! ");
        ExtentFactory.getTest().log(Status.INFO, context.getName() + " Test Run Finished!");
        report.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" Test Success! ");
        ExtentFactory.getTest().log(Status.PASS, result.getMethod().getMethodName() + " Test passed!");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = report.createTest(result.getMethod().getMethodName());
        logger.info(result.getMethod().getMethodName() + " Test Started! On Browser : " +
                result.getTestContext().getAttribute("browserName"));

        ExtentFactory.setTest(test);
        ExtentFactory.getTest().log(Status.INFO, "Test Started!!");
    }
}
