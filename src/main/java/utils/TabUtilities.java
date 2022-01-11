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
import java.util.Set;

public class TabUtilities {
    private WebDriver driver;
    private JavascriptExecutor js;
    private String defaultTab;
    private final static long TIMEOUT = 2000;

    static Logger logger = Logger.getLogger(TabUtilities.class);


    public TabUtilities(WebDriver driver) {
        this.driver = driver;
        initComponents();
    }

    public void waitForPageLoad(WebDriver driver, int timeWait) throws JavascriptException {
        js = ((JavascriptExecutor) driver);
        new WebDriverWait(driver, Duration.ofSeconds(timeWait)).until((ExpectedCondition<Boolean>)
                d -> js.executeScript("return document.readyState").toString().equals("complete"));
    }

    private void initComponents() {
        js = (JavascriptExecutor) driver;
    }

    private void newTab() throws InterruptedException {
        openNewTab();
    }

    public void closeTab() {
        driver.close();
    }

    public void switchToNewTab() throws InterruptedException {
        //newTab();
        Thread.sleep(TIMEOUT);
        waitForPageLoad(driver, 8000);
        Set<String> windowHandles = driver.getWindowHandles();
        defaultTab = (String) windowHandles.toArray()[0];
        driver.switchTo().window((String) windowHandles.toArray()[1]);
    }

    public void returnToDefaultTab() throws InterruptedException {
        //Tab will be closed automatically in project aeon
        //closeTab();
        driver.switchTo().window(defaultTab);
        Thread.sleep(TIMEOUT);
    }

    public void openNewTab() throws InterruptedException {
        js.executeScript("window.open()");
        Thread.sleep(TIMEOUT);
    }

    public void switchToTab(int tabIndex) throws InterruptedException {
        Thread.sleep(TIMEOUT);
        Set<String> windowHandles = driver.getWindowHandles();
        defaultTab = (String) windowHandles.toArray()[0];
        driver.switchTo().window((String) windowHandles.toArray()[tabIndex]);
    }

    /**
     * To set implicit wait timeout for 'N' Seconds on 'driver'
     * @param driver
     * @param element
     */
    public static void getElementInToView(WebDriver driver, WebElement element) {
        //logger.info("Get Element in to Page view visible.");
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
        String timestamp = TabUtilities.getCurrentTimeStamp();
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

