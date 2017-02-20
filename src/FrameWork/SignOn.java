package FrameWork;

/**
 * Created by Vijeet on 14-02-2017.
 */
public class SignOn extends Initializer {

   // private static final String USERNAME_LOCATOR_BY_NAME = "@name[userName]";
   // private static final String PASSWORD_LOCATOR_BY_NAME = "@name[password]";
   // private static final String LOGIN_BUTTON_LOCATOR_BY_NAME = "@name[login]";

    private static final String USERNAME_LOCATOR = "//a[//input[@name='userName']]";
    private static final String PASSWORD_LOCATOR = "//a[//input[@name='password']]";
    private static final String LOGIN_BUTTON_LOCATOR = "//a[//input[@name='login']]";

    public static String getUsernameLocator() {
        return USERNAME_LOCATOR.substring(4,USERNAME_LOCATOR.length()-1);
    }

    public static String getPasswordLocator() {
        return PASSWORD_LOCATOR.substring(4,PASSWORD_LOCATOR.length()-1);
    }

    public static String getLoginButtonLocator() {
        return LOGIN_BUTTON_LOCATOR.substring(4,PASSWORD_LOCATOR.length()-1);
    }

    public SignOn() throws SeleniumException {
        super();
        if (!driver.getCurrentUrl().equalsIgnoreCase("http://newtours.demoaut.com/mercurysignon.php"))
            driver.get("http://newtours.demoaut.com/mercurysignon.php");
        logger.info("get url : http://newtours.demoaut.com/mercurysignon.php");
    }

    public static void main(String[] args) throws SeleniumException{
        SignOn s = new SignOn();
        s.fillUserName("user");
        s.fillPassword("pass");
        s.clickLogin();
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
