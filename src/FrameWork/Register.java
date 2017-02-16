package FrameWork;

public class Register extends Initializer {

    private static final String FIRSTNAME_LOCATOR ="//input[@name='firstName']";
    private static final String LASTNAME_LOCATOR ="//input[@name='lastName']";
    private static final String PHONE_LOCATOR ="//input[@name='phone']";
    private static final String EMAIL_LOCATOR ="//input[@name='userName']";
    private static final String ADDRESS_1_LOCATOR ="//input[@name='address1']";
    private static final String ADDRESS_2_LOCATOR ="//input[@name='address2']";
    private static final String CITY_LOCATOR ="//input[@name='city']";
    private static final String STATE_LOCATOR ="//input[@name='state']";
    private static final String POSTAL_CODE_LOCATOR ="//input[@name='postalCode']";
    private static final String COUNTRY_LOCATOR ="//select[@name='country']";
    private static final String USERNAME_LOCATOR ="//input[@name='email']";
    private static final String PASSWORD_LOCATOR ="//input[@name='password']";
    private static final String CONFIRM_PASSWORD_LOCATOR ="//input[@name='confirmPassword']";
    private static final String SUBMIT_BUTTON_LOCATOR ="//input[@name='register']";

    public Register() throws SeleniumException {
        super();
        if (!driver.getCurrentUrl().equalsIgnoreCase("http://newtours.demoaut.com/mercuryregister.php"))
            driver.get("http://newtours.demoaut.com/mercuryregister.php");
    }

}
