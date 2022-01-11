

import ExtentReporters.ExtentFactory;
import org.apache.log4j.Logger;
import org.aspectj.apache.bcel.classfile.ExceptionTable;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;


public class RefreshTest extends BaseTest {

    static Logger logger = Logger.getLogger(RefreshTest.class);

    /**
     * Test 1 - Verify Refresh functionality with amount and currency.
     */

   /* @Test(priority=1, description =  "TC_001 - Verify Refresh functionality with amount and currency.")
    public void verifyRefreshButtonFunction() {

        logger.info("Test 1 - Verify Refresh functionality with amount and currency.");
        ExtentFactory.getTest().info("Test 1 - Verify Refresh functionality with amount and currency.");

        InterviewTaskPage interviewTaskPage = new InterviewTaskPage(driver);
        interviewTaskPage.selectCryptoCurrency("Ethereum");
        interviewTaskPage.setAmount(2500);
        interviewTaskPage.clickRefreshButton();
        interviewTaskPage.verifyProviderAmountAndCurrency(2500,"ETH");
    }*/

    /**
     * Test 4 - Verify visit provider site(Visit Now)
     */
  /*  @Test(priority=4, description =  "TC_004 - Verify visit provider site(Visit Now)")
    public void verifyVisitProvider()  {

        logger.info("Test 4 - Verify visit provider site(Visit Now)");
        ExtentFactory.getTest().info("Test 4 - Verify visit provider site(Visit Now)");
        InterviewTaskPage interviewTaskPage =  new InterviewTaskPage(driver);
        interviewTaskPage.clickLoadMoreButton();
        interviewTaskPage.verifyProviderSiteVisits();
    } */

    /**
     * Test 6 - Verify Provider Urls not broken
     */
    @Test(priority=6, description =  "TC_006 - Verify Provider Urls not broken")
    public void verifyProvidersURLNotBroken()  {

        logger.info("Test 6 - Verify Provider Urls not broken");
        ExtentFactory.getTest().info("Test 6 - Verify Provider Urls not broken");
        InterviewTaskPage interviewTaskPage = new InterviewTaskPage(driver);
        interviewTaskPage.clickLoadMoreButton();
        interviewTaskPage.verifyProvidersURLNotBroken();
    }
}
