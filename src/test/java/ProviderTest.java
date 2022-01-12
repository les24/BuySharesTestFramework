import ExtentReporters.ExtentFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class ProviderTest extends BaseTest {

        static Logger logger = Logger.getLogger(ProviderTest.class);

        /**
         * Test Case 9 - Verify visit provider site(Visit Now)
         */
        @Test(priority=4, description =  "TC_009 - Verify visit provider site(Visit Now)")
        public void verifyVisitProvider()  {
                logger.info("Test Case 9  - Verify visit provider site(Visit Now)");
                ExtentFactory.getTest().info("Test Case 9 - Verify visit provider site(Visit Now)");
                InterviewTaskPage interviewTaskPage =  new InterviewTaskPage(driver);
                interviewTaskPage.clickLoadMoreButton();
                interviewTaskPage.verifyProviderSiteVisits();
        }

        /**
         * Test Case 10 - Verify Review button.
         */
        @Test(priority=5, description =  "TC_010 - Verify Review button.")
        public void verifyReviewButton()  {
                logger.info("Test Case 10 - Verify Review button.");
                ExtentFactory.getTest().info("Test Case 10 - Verify Review button.");
                InterviewTaskPage interviewTaskPage =  new InterviewTaskPage(driver);
                interviewTaskPage.clickLoadMoreButton();
                interviewTaskPage.verifyProviderSiteReviews();
        }


        /**
         * Test Case 11 - Verify Provider Urls not broken
         */
        @Test(priority=6, description =  "TC_011 - Verify Provider Urls not broken")
        public void verifyProvidersURLNotBroken()  {
                logger.info("Test Case 11 - Verify Provider Urls not broken");
                ExtentFactory.getTest().info("Test Case 11 - Verify Provider Urls not broken");
                InterviewTaskPage interviewTaskPage = new InterviewTaskPage(driver);
                interviewTaskPage.clickLoadMoreButton();
                interviewTaskPage.verifyProvidersURLNotBroken();
        }
}
