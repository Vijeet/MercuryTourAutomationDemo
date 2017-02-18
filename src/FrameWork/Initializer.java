package FrameWork;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Vijeet on 11-02-2017.
 */
public class Initializer  {

    private static final String HOME_LINK_LOCATOR = "//a[//a[text()='Home']]";
    private static final String FLIGHTS_LINK_LOCATOR = "//a[//a[text()='Flights']]";
    private static final String HOTELS_LINK_LOCATOR = "//a[//a[text()='Hotels']]";
    private static final String CAR_RENTALS_LINK_LOCATOR = "//a[//a[text()='Car Rentals']]";
    private static final String CRUISES_LINK_LOCATOR = "//a[//a[text()='Cruises']]";
    private static final String DESTINATIONS_LINK_LOCATOR = "//a[//a[text()='Destinations']]";
    private static final String VACATIONS_LINK_LOCATOR = "//a[//a[text()='Vacations']]";
    private static final String SIGNON_LINK_LOCATOR = "//a[//a[text()='SIGN-ON']]";
    private static final String REGISTER_LINK_LOCATOR = "//a[//a[text()='REGISTER']]";
    private static final String SUPPORT_LINK_LOCATOR = "//a[//a[text()='SUPPORT']]";
    private static final String CONTACT_LINK_LOCATOR = "//a[//a[text()='CONTACT']]";

    protected static Logger logger;

    public static WebDriver driver;

    public Initializer() throws SeleniumException {
        logger = Logger.getLogger(Initializer.class);
        DOMConfigurator.configure("log4j.xml");
        logger.info("Constructor : Initializer()");
        if (driver==null) {
            try {
                Properties prop = new Properties();
                prop.load(new FileInputStream("D:\\IntelliJ Projects\\Demo\\driver.properties"));
                String key = prop.getProperty("BrowserName");
                logger.info("Got property browserName = "+key );
                if (key.equalsIgnoreCase("FireFox")) {
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vijeet\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe");
                    driver = new FirefoxDriver();
                } else if (key.equalsIgnoreCase("Chrome")) {
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vijeet\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe");
                    driver = new ChromeDriver();
                } else if (key.equalsIgnoreCase("IE")) {
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vijeet\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe");
                    driver = new ChromeDriver();
                }
                logger.info("Driver initialized ");
            } catch (Exception e) {
                logger.info("Exception raised ");
                throw new SeleniumException("Error initializing driver");
            }
        }
    }

    public void enter(String path, String value) throws SeleniumException {
        logger.info("Function : enter()");
        if (path.startsWith("@id[")){
            String p = path.substring(4,path.length()-1);
            driver.findElement(By.id(p)).sendKeys(value);
        }
        else if (path.startsWith("@name[")){
            String p = path.substring(6,path.length()-1);
            driver.findElement(By.name(p)).sendKeys(value);
        }
        else if (path.startsWith("//a[")){
            String p = path.substring(4,path.length()-1);
            driver.findElement(By.xpath(p)).sendKeys(value);
        }
        else {
            logger.info("Exception raised ");
            throw new SeleniumException("No matching locator found");
        }
    }

    public void click (String path) throws SeleniumException {
        logger.info("Function : click()");
        if (path.startsWith("@id[")){
            String p = path.substring(4,path.length()-1);
            driver.findElement(By.id(p)).click();
        }
        else if (path.startsWith("@name[")){
            String p = path.substring(6,path.length()-1);
            driver.findElement(By.name(p)).click();
        }
        else if (path.startsWith("//a[")){
            String p = path.substring(4,path.length()-1);
            driver.findElement(By.xpath(p)).click();
        }
        else {
            logger.info("Exception raised ");
            throw new SeleniumException("No matching locator found");
        }
    }

    public void clickOnHomeLink(){
        logger.info("Function : clickOnHomeLink()");
        driver.findElement(By.xpath(HOME_LINK_LOCATOR)).click();
    }

    public void clickOnFlightsLink(){
        logger.info("Function : clickOnFlightsLink()");
        driver.findElement(By.xpath(FLIGHTS_LINK_LOCATOR)).click();
    }

    public void clickOnHotelsLink(){
        logger.info("Function : clickOnHotelsLink()");
        driver.findElement(By.xpath(HOTELS_LINK_LOCATOR)).click();
    }

    public void clickOnCarRentalsLink(){
        logger.info("Function : clickOnCarRentalsLink()");
        driver.findElement(By.xpath(CAR_RENTALS_LINK_LOCATOR)).click();
    }

    public void clickOnCruisesLink(){
        logger.info("Function : clickOnCruisesLink()");
        driver.findElement(By.xpath(CRUISES_LINK_LOCATOR)).click();
    }

    public void clickOnDestinationsLink(){
        logger.info("Function : clickOnDestinationsLink()");
        driver.findElement(By.xpath(DESTINATIONS_LINK_LOCATOR)).click();
    }

    public void clickOnVacationsLink(){
        logger.info("Function : clickOnVacationsLink()");
        driver.findElement(By.xpath(VACATIONS_LINK_LOCATOR)).click();
    }

    public void clickOnSignOnLink(){
        logger.info("Function : clickOnSignOnLink()");
        driver.findElement(By.xpath(SIGNON_LINK_LOCATOR)).click();
    }

    public void clickOnRegisterLink(){
        logger.info("Function : clickOnRegisterLink()");
        driver.findElement(By.xpath(REGISTER_LINK_LOCATOR)).click();
    }

    public void clickOnSupportLink(){
        logger.info("Function : clickOnSupportLink()");
        driver.findElement(By.xpath(SUPPORT_LINK_LOCATOR)).click();
    }

    public void clickOnContactLink(){
        logger.info("Function : clickOnContactLink()");
        driver.findElement(By.xpath(CONTACT_LINK_LOCATOR)).click();
    }

}
