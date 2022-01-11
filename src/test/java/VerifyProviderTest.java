import ExtentReporters.ExtentFactory;
import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class VerifyProviderTest extends BaseTest {

        static Logger logger = Logger.getLogger(VerifyProviderTest.class);


        /**
         * Test 3 - Verify Clear Filters
         */
        @Test(priority=3, description =  "TC_003 - Verify Clear Filters.")
        public void verifyClearFilters()  {

                logger.info("Test 3 - Verify Clear Filters");
                ExtentFactory.getTest().info("Test 3 - Verify Clear Filters");
                InterviewTaskPage interviewTaskPage =  new InterviewTaskPage(driver);
                interviewTaskPage.clickMoreFiltersButton();
                interviewTaskPage.selectPaymentMethods("Sepa Transfer");
                interviewTaskPage.clickClearFilterButton();
                interviewTaskPage.verifyFiltersCleared();
        }

        /**
         * Test 5 - Verify Review button.
         */
      /* @Test(priority=5, description =  "TC_005 - Verify Review button.")
        public void verifyReviewButton()  {

                logger.info("Test 5 - Verify Review button.");
                test.info("Test 5 - Verify Review button.");
                InterviewTaskPage interviewTaskPage =  new InterviewTaskPage(driver, test);
                interviewTaskPage.clickLoadMoreButton();
                interviewTaskPage.verifyProviderSiteReviews();
        }*/

        /**
         * Test 6 - Verify Provider Urls not broken
         */
        /*  @Test(priority=6, description =  "TC_006 - Verify Provider Urls not broken")
        public void verifyProvidersURLNotBroken()  {

                logger.info("Test 6 - Verify Provider Urls not broken");
                test.info("Test 6 - Verify Provider Urls not broken");
                InterviewTaskPage interviewTaskPage =  new InterviewTaskPage(driver, test);
                interviewTaskPage.clickLoadMoreButton();
                interviewTaskPage.verifyProvidersURLNotBroken();
        }*/
}
