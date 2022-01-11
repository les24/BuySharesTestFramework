package ExtentReporters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import ExtentReporters.*;

public class ExtentFactory {

    private static ExtentReports extent = ExtentReporter.ExtentGenerator();
    public static ThreadLocal<ExtentTest> extentTestThreadSafe = new ThreadLocal<ExtentTest>();

    public static synchronized ExtentTest getTest() {
        return extentTestThreadSafe.get();
    }

    public static void setTest(ExtentTest extentTest){
        extentTestThreadSafe.set(extentTest);
    }
}