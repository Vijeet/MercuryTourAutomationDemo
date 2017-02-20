package TestCases;

import FrameWork.HomePage;
import FrameWork.SeleniumException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static FrameWork.Initializer.driver;

/**
 * Created by Vijeet on 20-02-2017.
 */
public class LoginFromHomePage {

    HomePage hp;

    @Test
    public void Login() throws SeleniumException {
        Assert.assertEquals((driver.findElement(By.xpath(HomePage.getUsernameLocator())).getAttribute("value")),"user");
        Assert.assertEquals((driver.findElement(By.xpath(HomePage.getPasswordLocator())).getAttribute("value")),"pass");
        hp.clickLogin();
    }

    @BeforeTest
    public void init() throws SeleniumException, InterruptedException {
        hp = new HomePage();
        hp.fillUserName("user");
        hp.fillPassword("pass");
    }
}
