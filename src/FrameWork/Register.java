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
    private static final String PASSWORD_LOCATOR ="//a[//input[@name='password']]";
    private static final String CONFIRM_PASSWORD_LOCATOR ="//a[//input[@name='confirmPassword']]";
    private static final String SUBMIT_BUTTON_LOCATOR ="//a[//input[@name='register']]";

    public Register() throws SeleniumException {
        super();
        if (!driver.getCurrentUrl().equalsIgnoreCase("http://newtours.demoaut.com/mercuryregister.php"))
            driver.get("http://newtours.demoaut.com/mercuryregister.php");
        logger.info("get url : http://newtours.demoaut.com/mercuryregister.php");
    }

    public void fillUserName(String user) throws SeleniumException {
        this.enter(USERNAME_LOCATOR,user);
        logger.info("Function : fillUserName");
    }

    public void fillFirstName(String user) throws SeleniumException {
        logger.info("Function : fillFirstName");
        this.enter(FIRSTNAME_LOCATOR,user);
    }

    public void fillLastName(String user) throws SeleniumException {
        logger.info("Function : fillLastName");
        this.enter(LASTNAME_LOCATOR,user);
    }

    public void fillPhone(String user) throws SeleniumException {
        logger.info("Function : fillPhone");
        this.enter(PHONE_LOCATOR,user);
    }

    public void fillEmail(String user) throws SeleniumException {
        logger.info("Function : fillEmail");
        this.enter(EMAIL_LOCATOR,user);
    }

    public void fillAddress1(String user) throws SeleniumException {
        logger.info("Function : fillAddress1");
        this.enter(ADDRESS_1_LOCATOR,user);
    }

    public void fillAddress2(String user) throws SeleniumException {
        logger.info("Function : fillAddress2");
        this.enter(ADDRESS_2_LOCATOR,user);
    }

    public void fillCity(String user) throws SeleniumException {
        logger.info("Function : fillCity");
        this.enter(CITY_LOCATOR,user);
    }

    public void fillState(String user) throws SeleniumException {
        logger.info("Function : fillState");
        this.enter(STATE_LOCATOR,user);
    }

    public void fillPostalCode(String user) throws SeleniumException {
        logger.info("Function : fillPostalCode");
        this.enter(POSTAL_CODE_LOCATOR,user);
    }

    public void fillPassword(String user) throws SeleniumException {
        logger.info("Function : fillPassword");
        this.enter(PASSWORD_LOCATOR,user);
    }

    public void fillConfirmPassword(String user) throws SeleniumException {
        logger.info("Function : fillConfirmPassword");
        this.enter(CONFIRM_PASSWORD_LOCATOR,user);
    }

    public void clickSubmit() throws SeleniumException {
        logger.info("Function : clickSubmit");
        this.click(SUBMIT_BUTTON_LOCATOR);
    }

    public void selectCountry(int index) throws SeleniumException {
        logger.info("Function : selectCountry( By Index)");
        Select select;
        try {
            select = new Select(driver.findElement(By.name("country")));
            //select = new Select(driver.findElement(By.xpath(COUNTRY_LOCATOR)));
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
        logger.info("Function : selectCountry(By name)");
        Select select;
        try {
            select = new Select(driver.findElement(By.name("country")));
            //select = new Select(driver.findElement(By.xpath(COUNTRY_LOCATOR)));
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

    public static String getFirstnameLocator() {
        return FIRSTNAME_LOCATOR.substring(4,FIRSTNAME_LOCATOR.length()-1);
    }

    public static String getLastnameLocator() {
        return LASTNAME_LOCATOR.substring(4,LASTNAME_LOCATOR.length()-1);
    }

    public static String getPhoneLocator() {
        return PHONE_LOCATOR.substring(4,PHONE_LOCATOR.length()-1);
    }

    public static String getEmailLocator() {
        return EMAIL_LOCATOR.substring(4,EMAIL_LOCATOR.length()-1);
    }

    public static String getAddress1Locator() {
        return ADDRESS_1_LOCATOR.substring(4,ADDRESS_1_LOCATOR.length()-1);
    }

    public static String getAddress2Locator() {
        return ADDRESS_2_LOCATOR.substring(4,ADDRESS_2_LOCATOR.length()-1);
    }

    public static String getCityLocator() {
        return CITY_LOCATOR.substring(4,CITY_LOCATOR.length()-1);
    }

    public static String getStateLocator() {
        return STATE_LOCATOR.substring(4,STATE_LOCATOR.length()-1);
    }

    public static String getPostalCodeLocator() {
        return POSTAL_CODE_LOCATOR.substring(4,POSTAL_CODE_LOCATOR.length()-1);
    }

    public static String getCountryLocator() {
        return COUNTRY_LOCATOR.substring(4,COUNTRY_LOCATOR.length()-1);
    }

    public static String getUsernameLocator() {
        return USERNAME_LOCATOR.substring(4,USERNAME_LOCATOR.length()-1);
    }

    public static String getPasswordLocator() {
        return PASSWORD_LOCATOR.substring(4,PASSWORD_LOCATOR.length()-1);
    }

    public static String getConfirmPasswordLocator() {
        return CONFIRM_PASSWORD_LOCATOR.substring(4,CONFIRM_PASSWORD_LOCATOR.length()-1);
    }

    public static String getSubmitButtonLocator() {
        return SUBMIT_BUTTON_LOCATOR.substring(4,SUBMIT_BUTTON_LOCATOR.length()-1);
    }

}
