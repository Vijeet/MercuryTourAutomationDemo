package TestCases;

import FrameWork.Register;
import FrameWork.SeleniumException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static FrameWork.Initializer.driver;

/**
 * Created by vijthoma on 2/20/2017.
 */
public class RegisterFromRegisterPage {
    Register r;

    @Test
    public void Register() throws SeleniumException {
        Assert.assertEquals((driver.findElement(By.xpath(Register.getFirstnameLocator())).getAttribute("value")),"first");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getLastnameLocator())).getAttribute("value")),"last");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getPhoneLocator())).getAttribute("value")),"9787");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getEmailLocator())).getAttribute("value")),"sd@gmail.com");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getAddress1Locator())).getAttribute("value")),"ananth");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getAddress2Locator())).getAttribute("value")),"towerc");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getCityLocator())).getAttribute("value")),"hyd");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getStateLocator())).getAttribute("value")),"tel");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getPostalCodeLocator())).getAttribute("value")),"500");
        Select select = new Select(driver.findElement(By.name("country")));
        String expected = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected.trim(),"INDIA");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getUsernameLocator())).getAttribute("value")),"user");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getPasswordLocator())).getAttribute("value")),"pass");
        Assert.assertEquals((driver.findElement(By.xpath(Register.getConfirmPasswordLocator())).getAttribute("value")),"pass");
        //Assert.assertEquals((driver.findElement(By.xpath(Register.getSubmitButtonLocator())).getAttribute("value")),"pass");
        r.clickSubmit();
    }

    @BeforeTest
    public void init() throws SeleniumException, InterruptedException {
        r = new Register();
        r.fillFirstName("first");
        r.fillLastName("last");
        r.fillPhone("9787");
        r.fillEmail("sd@gmail.com");
        r.fillAddress1("ananth");
        r.fillAddress2("towerc");
        r.fillCity("hyd");
        r.fillState("tel");
        r.selectCountry("INDIA");
        r.fillPostalCode("500");
        r.fillUserName("user");
        r.fillPassword("pass");
        r.fillConfirmPassword("pass");
    }

}

