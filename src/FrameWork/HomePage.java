package FrameWork;

/**
 * Created by Vijeet on 14-02-2017.
 */
public class HomePage extends Initializer {

    // private static final String USERNAME_LOCATOR_BY_NAME = "@name[userName]";
    // private static final String PASSWORD_LOCATOR_BY_NAME = "@name[password]";
    // private static final String LOGIN_BUTTON_LOCATOR_BY_NAME = "@name[login]";

    private static final String USERNAME_LOCATOR = "//a[//input[@name='userName']]";
    private static final String PASSWORD_LOCATOR = "//a[//input[@name='password']]";
    private static final String LOGIN_BUTTON_LOCATOR = "//a[//input[@name='login']]";

    public HomePage() throws SeleniumException {
        super();
        if (driver.getCurrentUrl().equalsIgnoreCase("http://newtours.demoaut.com/index.php"))
            driver.get("http://newtours.demoaut.com/index.php");
    }

    public void fillUserName(String user) throws SeleniumException {
        logger.info("Function : fillUserName()");
        this.enter(USERNAME_LOCATOR,user);
    }

    public void fillPassword(String pass) throws SeleniumException {
        logger.info("Function : fillPassword()");
        this.enter(PASSWORD_LOCATOR,pass);
    }

    public void clickLogin() throws SeleniumException {
        logger.info("Function : clickLogin()");
        this.click(LOGIN_BUTTON_LOCATOR);
    }

}
