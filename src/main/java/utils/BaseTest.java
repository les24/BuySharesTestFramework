package utils;

import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.log4j.PropertyConfigurator;
import pages.InterviewTaskPage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static Properties prop;
    public WebDriver driver;

    static Logger logger = Logger.getLogger(BaseTest.class);
    protected InterviewTaskPage interviewTaskPage;
    public ExtentTest test;
    String path = System.getProperty("user.dir");

    private final static String USER_DIR = System.getProperty("user.dir");

    @BeforeSuite(alwaysRun = true, description = "Setting up Suite")
    public void setupSuite(){
        logger.info("Reading Config properties in Test Setup.");
        readConfigs();
    }

    @BeforeTest(alwaysRun = true, description = "Setting up Test")
    public void setupTest(){
        PropertyConfigurator.configure(path + "\\src\\main\\resources\\log4j.properties");
    }

    @BeforeMethod
    public void setupMethod(ITestResult result, ITestContext context) {

        logger.info("Initializing Driver and other properties.");
        logger.info("Current Project dir path: " + path);

        if(prop.getProperty("BrowserName").equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", USER_DIR +"\\driver\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            options.addArguments("--profile-directory=Default");
            options.addArguments("--incognito");
            options.addArguments("--disable-plugins-discovery");
            options.addArguments("-user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36");
            options.addArguments();

            driver = new ChromeDriver(options);
        }
        else{
            logger.error("Unsupported Browser");
            Assert.fail("Unsupported Browser");
        }

        driver.get(prop.getProperty("WebURL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        context.setAttribute("WebDriver", driver); //Set attribute for using in Listener
        context.setAttribute("ExtentTest", test);

        driver.manage().window().maximize();

        logger.info("Completed Initializing Driver and other properties.");
    }

    public void readConfigs(){
        try {
            prop = new Properties();
            logger.info("Reading Configurations property file.");
            FileInputStream fi = new FileInputStream(USER_DIR +"\\src\\main\\resources\\config.properties");
            prop.load(fi);
            logger.info("Configurations Property file loaded successfully.");
        } catch (FileNotFoundException e) {
            logger.info("Configurations Property file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.info("Configurations Property file loading failed.");
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true, description =  "Cleaning up after Test Method")
    public void cleanupMethod(){
        logger.info("Cleaning up.");
        if(driver!=null) {
            driver.quit();
        }
        logger.info("Clean up Completed.");
    }
}
