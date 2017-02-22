package TestCases;

import FrameWork.HomePage;
import FrameWork.Register;
import FrameWork.SeleniumException;
import FrameWork.SignOn;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static FrameWork.Initializer.driver;

/**
 * Created by vijthoma on 2/21/2017.
 */
public class AllTestCases2 extends TestConfig{

    static int i =0;

    @Test
    public void registerFromRegisterPage() throws SeleniumException, IOException {
        i++;
        r = new Register();
        logger=report.startTest("Register");
        r.fillFirstName("first");
        logger.log(LogStatus.PASS,"firstname entered");
        r.fillLastName("last");
        logger.log(LogStatus.PASS,"lastname entered");
        r.fillPhone("9787");
        logger.log(LogStatus.PASS,"phone number entered");
        r.fillEmail("sd@gmail.com");
        logger.log(LogStatus.PASS,"email entered");
        r.fillAddress1("ananth");
        logger.log(LogStatus.PASS,"address 1 entered");
        r.fillAddress2("towerc");
        logger.log(LogStatus.PASS,"address 2 entered");
        r.fillCity("hyd");
        logger.log(LogStatus.PASS,"city entered");
        r.fillState("tel");
        logger.log(LogStatus.PASS,"state entered");
        r.fillPostalCode("500");
        logger.log(LogStatus.PASS,"postal code entered");
        r.selectCountry("INDIA");
        logger.log(LogStatus.PASS,"country entered");
        r.fillUserName("user");
        logger.log(LogStatus.PASS,"username entered");
        r.fillPassword("pass");
        logger.log(LogStatus.PASS,"password entered");
        r.fillConfirmPassword("pass");
        logger.log(LogStatus.PASS,"confirm password entered");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getFirstnameLocator())).getAttribute("value")),"first");
        logger.log(LogStatus.PASS,"firstname verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getLastnameLocator())).getAttribute("value")),"last");
        logger.log(LogStatus.PASS,"lastname verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getPhoneLocator())).getAttribute("value")),"9787");
        logger.log(LogStatus.PASS,"phone number verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getEmailLocator())).getAttribute("value")),"sd@gmail.com");
        logger.log(LogStatus.PASS,"email verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getAddress1Locator())).getAttribute("value")),"ananth");
        logger.log(LogStatus.PASS,"addresss 1 verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getAddress2Locator())).getAttribute("value")),"towerc");
        logger.log(LogStatus.PASS,"address 2 verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getCityLocator())).getAttribute("value")),"hyd");
        logger.log(LogStatus.PASS,"city verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getStateLocator())).getAttribute("value")),"tel");
        logger.log(LogStatus.PASS,"state verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getPostalCodeLocator())).getAttribute("value")),"500");
        logger.log(LogStatus.PASS,"postal code verified");
        Select select = new Select(driver.findElement(By.name("country")));
        String expected = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected.trim(),"INDIA");
        logger.log(LogStatus.PASS,"country verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getUsernameLocator())).getAttribute("value")),"user");
        logger.log(LogStatus.PASS,"username verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getPasswordLocator())).getAttribute("value")),"pass");
        logger.log(LogStatus.PASS,"password verified");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getConfirmPasswordLocator())).getAttribute("value")),"pass");
        logger.log(LogStatus.PASS,"confirm password verified");
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "D:\\IntelliJ Projects\\Demo\\src\\Screenshots\\Screenshot"+i+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source,destination);
        logger.addScreenCapture(dest);
        r.clickSubmit();
    }

    @Test
    public void loginFromSignOn() throws SeleniumException, IOException {
        i++;
        sp = new SignOn();
        logger=report.startTest("Login From Sign On Page");
        sp.fillUserName("user");
        logger.log(LogStatus.PASS,"username entered");
        sp.fillPassword("pass");
        logger.log(LogStatus.PASS,"password entered");
        Assert.assertEquals((driver.findElement(By.xpath(SignOn.getUsernameLocator())).getAttribute("value")),"user");
        logger.log(LogStatus.PASS,"username verified");
        Assert.assertEquals((driver.findElement(By.xpath(SignOn.getPasswordLocator())).getAttribute("value")),"pass");
        logger.log(LogStatus.PASS,"password verified");
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "D:\\IntelliJ Projects\\Demo\\src\\Screenshots\\Screenshot"+i+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source,destination);
        logger.addScreenCapture(dest);
        sp.clickLogin();
    }

    @Test
    public void loginFromHomePage() throws SeleniumException, IOException {
        i++;
        //report=new ExtentReports("D:\\IntelliJ  Projects\\MercuryToursAutomationDemo\\src\\Report.html");
        //logger=report.startTest("Login From Home Page");
        logger=report.startTest("Login From Home Page");
        hp = new HomePage();
        hp.fillUserName("user");
        logger.log(LogStatus.PASS,"username entered");
        hp.fillPassword("pass");
        logger.log(LogStatus.PASS,"password entered");
        Assert.assertEquals((driver.findElement(By.xpath(HomePage.getUsernameLocator())).getAttribute("value")),"user");
        logger.log(LogStatus.PASS,"username verified");
        Assert.assertEquals((driver.findElement(By.xpath(HomePage.getPasswordLocator())).getAttribute("value")),"pass");
        logger.log(LogStatus.PASS,"password verified");
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "D:\\IntelliJ Projects\\Demo\\src\\Screenshots\\Screenshot"+i+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source,destination);
        logger.addScreenCapture(dest);
        hp.clickLogin();
    }

}


