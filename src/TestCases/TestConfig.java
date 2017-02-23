package TestCases;

import FrameWork.HomePage;
import FrameWork.Register;
import FrameWork.SeleniumException;
import FrameWork.SignOn;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

import static FrameWork.Initializer.driver;

/**
 * Created by vijthoma on 2/22/2017.
 */
public class TestConfig {

    public static ExtentReports report;
    public static ExtentTest logger;
    HomePage hp;
    SignOn sp;
    Register r;
    static int i=0;
    @BeforeTest
    public void init() throws SeleniumException {
        if (report==null) {
            report = new ExtentReports("D:\\IntelliJ Projects\\Demo\\src\\Report.html");
            report.addSystemInfo("User Name", "Vijeet");
            report.addSystemInfo("OS", "Windows 7");
            report.addSystemInfo("Host name", "Vijeet's Computer");
        }
    }

    @AfterMethod
    public void endOfTest(ITestResult result) throws IOException {
        i++;
//        TakesScreenshot ts = (TakesScreenshot)driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
          String dest = "D:\\IntelliJ Projects\\Demo\\src\\Screenshots\\Screenshot"+i+".png";
//        File destination = new File(dest);
//        FileUtils.copyFile(source,destination);
        if (result.isSuccess()) {
            logger.log(LogStatus.PASS, "Test passed");
            logger.log(LogStatus.PASS, "Screenshot below :- " + logger.addScreenCapture(dest));
        }
        else if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL,"Test Failed : "+result.getThrowable().getMessage(), result.getThrowable());
            logger.log(LogStatus.FAIL, "Screenshot below :- " + logger.addScreenCapture(dest));
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test skipped");
        }
       // logger.addScreenCapture(dest);
        report.endTest(logger);
        report.flush();
    }

    @AfterSuite
    public void viewExtentReport(){
        driver.get("file:///D:/IntelliJ Projects/Demo/src/Report.html");
    }

}
