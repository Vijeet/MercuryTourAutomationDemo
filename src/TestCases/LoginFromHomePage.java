package TestCases;

import FrameWork.HomePage;
import FrameWork.SeleniumException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static FrameWork.Initializer.driver;

/**
 * Created by Vijeet on 20-02-2017.
 */
public class LoginFromHomePage {

    ExtentReports report;
    ExtentTest logger;
    HomePage hp;

    @Test
    public void Login() throws SeleniumException {
        Assert.assertEquals((driver.findElement(By.xpath(HomePage.getUsernameLocator())).getAttribute("value")),"user");
        logger.log(LogStatus.PASS,"username verified");
        Assert.assertEquals((driver.findElement(By.xpath(HomePage.getPasswordLocator())).getAttribute("value")),"pass");
        logger.log(LogStatus.PASS,"password verified");
        hp.clickLogin();
    }

    @BeforeTest
    public void init() throws SeleniumException, InterruptedException {
        report=new ExtentReports("D:\\IntelliJ Projects\\Demo\\src\\Report.html");
        logger=report.startTest("Login From Home Page");
        report.addSystemInfo("User Name","Vijeet");
        report.addSystemInfo("OS","Windows 10");
        hp = new HomePage();
        hp.fillUserName("user");
        logger.log(LogStatus.PASS,"username entered");
        hp.fillPassword("pass");
        logger.log(LogStatus.PASS,"password entered");
    }

    @AfterMethod
    public void endOfTest(ITestResult result)
    {
        if (result.isSuccess()) {
            logger.log(LogStatus.PASS, "Test passed");
        }
        else if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL,"Test Failed");
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test skipped");
        }
        report.endTest(logger);
        report.flush();

        driver.get("file:///D:/IntelliJ Projects/Demo/src/Report.html");
    }
}
