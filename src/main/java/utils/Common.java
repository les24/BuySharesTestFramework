package utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Common {
    private WebDriver driver;
    private JavascriptExecutor js;
    private final static long TIMEOUT = 2000;

    static Logger logger = Logger.getLogger(Common.class);


    public Common(WebDriver driver) {
        this.driver = driver;
        initComponents();
    }

    /**
     * To set implicit wait timeout for 'N' Seconds on 'driver'
     * @param driver
     * @param N
     */
    public static void setImplicitTimeout(WebDriver driver, int N) {
        logger.info("Setting Implicit timeout of " + N + " Seconds.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * To set page load timeout for 'N' Seconds on 'driver'
     * @param driver
     * @param N
     */
    public static void setPageLoadTimeout(WebDriver driver, int N) {
        logger.info("Setting Implicit timeout of " + N + " Seconds.");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }


    public void waitForPageLoad(WebDriver driver, int timeWait) throws JavascriptException {
        js = ((JavascriptExecutor) driver);
        new WebDriverWait(driver, Duration.ofSeconds(timeWait)).until((ExpectedCondition<Boolean>)
                d -> js.executeScript("return document.readyState").toString().equals("complete"));
    }

    private void initComponents() {
        js = (JavascriptExecutor) driver;
    }


    /**
     * To set implicit wait timeout for 'N' Seconds on 'driver'
     * @param driver
     * @param element
     */
    public static void getElementInToView(WebDriver driver, WebElement element) {
        logger.info("Get Element into Page view visible.");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,-300)");
    }
    /**
     * To get current Timestamp
     */
    public static String getCurrentTimeStamp() {
        logger.info("Get current timestamp.");
        return new SimpleDateFormat("_yyyy_MM_dd__hh_mm_ss").format(new Date());
    }

    /**
     * To capture Screnshot
     */
    public static String captureScreenshot(ITestResult result) {

        logger.info("Capture screenshot.");
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver)context.getAttribute("WebDriver");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timestamp = Common.getCurrentTimeStamp();
        String path = System.getProperty("user.dir") + "\\screenshots\\"+ result.getName() + timestamp+".png";

        try {
            FileUtils.copyFile(scrFile, new File(path));
            logger.info("Screenshot saved at : " +path);
        } catch (IOException e) {
            logger.error("Screenshot capture failed!.");
            e.printStackTrace();
        }
        return "..\\screenshots\\"+ result.getName() + timestamp+".png";
    }
}

