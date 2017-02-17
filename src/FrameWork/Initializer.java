package FrameWork;

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

    public static WebDriver driver;

    public Initializer() throws SeleniumException {
        if (driver==null) {
            try {
                Properties prop = new Properties();
                prop.load(new FileInputStream("D:\\IntelliJ Projects\\Demo\\driver.properties"));
                String key = prop.getProperty("BrowserName");
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
            } catch (Exception e) {
                throw new SeleniumException("Error initializing driver");
            }
        }
    }

    public void enter(String path, String value) throws SeleniumException {
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
        else
            throw new SeleniumException("No matching locator found");
    }

    public void click (String path) throws SeleniumException {
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
        else
            throw new SeleniumException("No matching locator found");
    }

    public void clickOnHomeLink(){
        driver.findElement(By.xpath(HOME_LINK_LOCATOR)).click();
    }

    public void clickOnFlightsLink(){
        driver.findElement(By.xpath(FLIGHTS_LINK_LOCATOR)).click();
    }

    public void clickOnHotelsLink(){
        driver.findElement(By.xpath(HOTELS_LINK_LOCATOR)).click();
    }

    public void clickOnCarRentalsLink(){
        driver.findElement(By.xpath(CAR_RENTALS_LINK_LOCATOR)).click();
    }

    public void clickOnCruisesLink(){
        driver.findElement(By.xpath(CRUISES_LINK_LOCATOR)).click();
    }

    public void clickOnDestinationsLink(){
        driver.findElement(By.xpath(DESTINATIONS_LINK_LOCATOR)).click();
    }

    public void clickOnVacationsLink(){
        driver.findElement(By.xpath(VACATIONS_LINK_LOCATOR)).click();
    }

    public void clickOnSignOnLink(){
        driver.findElement(By.xpath(SIGNON_LINK_LOCATOR)).click();
    }

    public void clickOnRegisterLink(){
        driver.findElement(By.xpath(REGISTER_LINK_LOCATOR)).click();
    }

    public void clickOnSupportLink(){
        driver.findElement(By.xpath(SUPPORT_LINK_LOCATOR)).click();
    }

    public void clickOnContactLink(){
        driver.findElement(By.xpath(CONTACT_LINK_LOCATOR)).click();
    }

}
