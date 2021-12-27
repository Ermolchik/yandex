package utils;

import driver.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.nio.charset.StandardCharsets;

public class AllureHelpers {

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "AllureTextReport", type = "text/plain", fileExtension = ".txt")
    public static String attachText(final String text) {
        return text;
    }

    /**
     * Прикрепление строки в формате csv.
     *
     * @param csv the csv
     * @return the string
     */
    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "AllureCSVReport", type = "text/csv", fileExtension = ".csv")
    public static String attachCSV(final String csv) {
        return csv;
    }

    /**
     * Получение кода страницы в byte [ ].
     *
     * @return the byte [ ]
     */
    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Html source", type = "text/html", fileExtension = ".html")
    public static byte[] getPageSource() {
        return getPageSourceBytes();
    }

    /**
     * Получение скриншота в byte [ ].
     *
     * @return the byte [ ]
     */
    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot() {
        return getScreenshotBytes();
    }

    /**
     * Получение скриншота byte [ ].
     *
     * @param name the name
     * @return the byte [ ]
     */
    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "{name}", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot(final String name) {
        return getScreenshotBytes();
    }

    /**
     * Получение скриншота byte [ ].
     *
     * @param elem the elem
     * @return the byte [ ]
     */
    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Element screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot(final WebElement elem) {
        return getScreenshotBytes(elem);
    }

    /**
     * Получение байтов кода страницы byte[ ].
     *
     * @return the byte [ ]
     */
    public static byte[] getPageSourceBytes() {
        return Driver.getDriver(Driver.drvr).getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * Получение байтов скриншота byte[ ].
     *
     * @return the byte [ ]
     */
    public static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) Driver.getDriver(Driver.drvr)).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Получение байтов скриншота byte[ ].
     *
     * @param elem the elem
     * @return the byte [ ]
     */
    public static byte[] getScreenshotBytes(final WebElement elem) {
        return elem.getScreenshotAs(OutputType.BYTES);
    }
}

