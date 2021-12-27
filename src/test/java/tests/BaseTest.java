package tests;

import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

class BaseTest{
 WebDriver driver;

    @BeforeEach
    void setDriver() {
        driver = Driver.getDriver(Driver.drvr);
    }

    @AfterEach
    public void closeDriver(){
        Driver.quitDriver();
    }

}
