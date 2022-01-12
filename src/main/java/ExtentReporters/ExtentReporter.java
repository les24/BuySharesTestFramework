package ExtentReporters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.Common;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ExtentReporter {

    public static ExtentReports extent;

    public synchronized static ExtentReports ExtentGenerator() {

        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") +
                    "\\reports\\ExtentSparkReport" + Common.getCurrentTimeStamp() + ".html");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Extent Report");
            spark.config().setEncoding("utf-8");
            spark.config().setReportName("Extent Report");

            extent.attachReporter(spark);
            try {
                extent.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            // extent.setSystemInfo("Environment", TestBase.prop.getProperty("TestEnvironment"));
            extent.setSystemInfo("User Name", System.getProperty("user.name"));

        }
        return extent;
    }
}

