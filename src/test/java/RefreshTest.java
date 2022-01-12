

import ExtentReporters.ExtentFactory;
import org.apache.log4j.Logger;
import org.aspectj.apache.bcel.classfile.ExceptionTable;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;


public class RefreshTest extends BaseTest {

    static Logger logger = Logger.getLogger(RefreshTest.class);

    /**
     * Test Case 3 - Verify Refresh functionality with amount and currency.
     */

    @Test(priority=1, description =  "TC_003 - Verify Refresh functionality with amount and currency.")
    public void verifyRefreshButtonFunction() {
        logger.info("Test Case 3 - Verify Refresh functionality with amount and currency.");
        ExtentFactory.getTest().info("Test Case 3 - Verify Refresh functionality with amount and currency.");

        InterviewTaskPage interviewTaskPage = new InterviewTaskPage(driver);
        interviewTaskPage.selectCryptoCurrency("Ethereum");
        interviewTaskPage.setAmount(2500);
        interviewTaskPage.clickRefreshButton();
        interviewTaskPage.verifyProviderAmountAndCurrency(2500,"ETH");
    }


}
