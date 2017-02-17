package FrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Register extends Initializer {

    private static final String FIRSTNAME_LOCATOR ="//a[//input[@name='firstName']]";
    private static final String LASTNAME_LOCATOR ="//a[//input[@name='lastName']]";
    private static final String PHONE_LOCATOR ="//a[//input[@name='phone']]";
    private static final String EMAIL_LOCATOR ="//a[//input[@name='userName']]";
    private static final String ADDRESS_1_LOCATOR ="//a[//input[@name='address1']]";
    private static final String ADDRESS_2_LOCATOR ="//a[//input[@name='address2']]";
    private static final String CITY_LOCATOR ="//a[//input[@name='city']]";
    private static final String STATE_LOCATOR ="//a[//input[@name='state']]";
    private static final String POSTAL_CODE_LOCATOR ="//a[//input[@name='postalCode']]";
    private static final String COUNTRY_LOCATOR ="//a[//select[@name='country']]";
    private static final String USERNAME_LOCATOR ="//a[//input[@name='email']]";
    private static final String PASSWORD_LOCATOR ="/a[//input[@name='password']]";
    private static final String CONFIRM_PASSWORD_LOCATOR ="//a[//input[@name='confirmPassword']]";
    private static final String SUBMIT_BUTTON_LOCATOR ="//a[//input[@name='register']]";

    public void fillUserName(String user) throws SeleniumException {
        this.enter(USERNAME_LOCATOR,user);
    }

    public void fillFirstName(String user) throws SeleniumException {
        this.enter(FIRSTNAME_LOCATOR,user);
    }

    public void fillLastName(String user) throws SeleniumException {
        this.enter(LASTNAME_LOCATOR,user);
    }

    public void fillPhone(String user) throws SeleniumException {
        this.enter(PHONE_LOCATOR,user);
    }

    public void fillEmail(String user) throws SeleniumException {
        this.enter(EMAIL_LOCATOR,user);
    }

    public void fillAddress1(String user) throws SeleniumException {
        this.enter(ADDRESS_1_LOCATOR,user);
    }

    public void fillAddress2(String user) throws SeleniumException {
        this.enter(ADDRESS_2_LOCATOR,user);
    }

    public void fillCity(String user) throws SeleniumException {
        this.enter(CITY_LOCATOR,user);
    }

    public void fillState(String user) throws SeleniumException {
        this.enter(STATE_LOCATOR,user);
    }

    public void fillPostalCode(String user) throws SeleniumException {
        this.enter(POSTAL_CODE_LOCATOR,user);
    }

    public void fillPassword(String user) throws SeleniumException {
        this.enter(PASSWORD_LOCATOR,user);
    }

    public void fillConfirmPassword(String user) throws SeleniumException {
        this.enter(CONFIRM_PASSWORD_LOCATOR,user);
    }

    public void clickSubmit() throws SeleniumException {
        this.click(SUBMIT_BUTTON_LOCATOR);
    }

    public void selectCountry(int index) throws SeleniumException {
        Select select;
        try {
            select = new Select(driver.findElement(By.xpath(COUNTRY_LOCATOR)));
        }
        catch (Exception e){
            throw new SeleniumException("Locator not found");
        }
        try {
            select.selectByIndex(index);
        }
        catch (Exception e){
            throw new SeleniumException("No such element");
        }
    }

    public void selectCountry(String value) throws SeleniumException {
        Select select;
        try {
            select = new Select(driver.findElement(By.xpath(COUNTRY_LOCATOR)));
        }
        catch (Exception e){
            throw new SeleniumException("Locator not found");
        }
        try {
            select.selectByVisibleText(value);
        }
        catch (Exception e){
            throw new SeleniumException("No such element");
        }
    }

    public Register() throws SeleniumException {
        super();
        if (!driver.getCurrentUrl().equalsIgnoreCase("http://newtours.demoaut.com/mercuryregister.php"))
            driver.get("http://newtours.demoaut.com/mercuryregister.php");
    }

}
