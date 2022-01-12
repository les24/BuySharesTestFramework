import ExtentReporters.ExtentFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.InterviewTaskPage;
import utils.BaseTest;

public class FiltersTest extends BaseTest {

    static Logger logger = Logger.getLogger(FiltersTest.class);

    /**
     * Test 2 - Verify Payment Method Filter - Sepa
     */
    @Test(priority=2, description =  "TC_002 - Verify Payment Method Filter - Sepa")
    public void verifyPaymentMethodFilter()  {
        logger.info("Test 2 - Verify Payment Method Filter");
        ExtentFactory.getTest().info("Test 2 - Verify Payment Method Filter");

        InterviewTaskPage interviewTaskPage =  new InterviewTaskPage(driver);
        interviewTaskPage.clickMoreFiltersButton();
        interviewTaskPage.selectPaymentMethods("Sepa Transfer");
        interviewTaskPage.clickLoadMoreButton();
        interviewTaskPage.verifyProviderPaymentMethod("Sepa Transfer");
    }

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



}
