package TestCases;

import FrameWork.SeleniumException;
import FrameWork.SignOn;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static FrameWork.Initializer.driver;


/**
 * Created by Vijeet on 19-02-2017.
 */
public class LoginFromSignOn {

    SignOn sp;

    @Test
    public void Login() throws SeleniumException {
        Assert.assertEquals((driver.findElement(By.xpath(SignOn.getUsernameLocator())).getAttribute("value")),"user");
        Assert.assertEquals((driver.findElement(By.xpath(SignOn.getPasswordLocator())).getAttribute("value")),"pass");
        sp.clickLogin();
    }

    @BeforeTest
    public void init() throws SeleniumException, InterruptedException {
        sp = new SignOn();
        sp.fillUserName("user");
        sp.fillPassword("pass");
    }

}
