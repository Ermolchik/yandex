package utils;

import driver.Driver;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.maven.surefire.api.report.ReportEntry;
import org.apache.maven.surefire.api.report.RunListener;
import org.apache.maven.surefire.api.report.RunMode;
import org.apache.maven.surefire.api.report.TestSetReportEntry;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import static java.lang.String.format;

public class TestAllureListener implements RunListener {



   @Override
    public void testFailed(ReportEntry reportEntry) {
       screenshot();
       System.out.println("---------------------------");
       System.out.println("Тест завалился!");
       System.out.println("---------------------------");

    }

    @Attachment(value = "Screenshot", type = "image/png")
    public void screenshot() {
        File screenshot= ((TakesScreenshot)Driver.getDriver(Driver.drvr)).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File(format(".//target/allure-results/screenshot/%s.png", LocalDate.now())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Stacktrace", type = "text/plain")
    public static String saveLogs(String message) {
        return message;
    }

    @Override
    public void testSetStarting(TestSetReportEntry testSetReportEntry) {

    }

    @Override
    public void testSetCompleted(TestSetReportEntry testSetReportEntry) {
        System.out.println("---------------------------");
        System.out.println("Тест выполнен!");
        System.out.println("---------------------------");
    }

    @Override
    public void testStarting(ReportEntry reportEntry) {
        System.out.println("---------------------------");
        System.out.println("Тест начался!");
        System.out.println("---------------------------");
    }

    @Override
    public void testSucceeded(ReportEntry reportEntry) {

    }

    @Override
    public void testAssumptionFailure(ReportEntry reportEntry) {

    }

    @Override
    public void testError(ReportEntry reportEntry) {

    }

    @Override
    public void testSkipped(ReportEntry reportEntry) {

    }

    @Override
    public void testExecutionSkippedByUser() {

    }

    @Override
    public RunMode markAs(RunMode runMode) {
        return null;
    }
}
