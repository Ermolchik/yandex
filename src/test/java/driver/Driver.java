package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static tests.Const.*;

public class Driver {
    public static String drvr = "chrome";
    public static WebDriver driver = null;

    public static WebDriver getDriver(String drvr) {
        switch (drvr){
            case "chrome":
                chromeInit();
                break;
            case "safari":
                safariInit();
                break;
            case "firefox":
                ffInit();
                break;
            default:
                System.out.println("Нет такого драйвера");
        }
        return driver;
    }

    private static void chromeInit(){
        System.setProperty(NAME_DRIVER_CHROME, DIRECTORY_DRIVER_CHROME);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    private static void safariInit(){
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    private static void ffInit(){
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    public static void quitDriver(){
        driver.quit();
        driver=null;
    }
}
