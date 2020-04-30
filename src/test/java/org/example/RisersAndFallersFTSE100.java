// Using testng and the reports, through the use of FTSE 100 market overview,
// find the largest riser and faller for the latest stock price index.
// Make sure to include screenshots into the test report.

// https://www.hl.co.uk/shares/stock-market-summary/ftse-100


package org.example;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;


public class RisersAndFallersFTSE100 {
    WebDriver driver;
    ExtentReports report;
    ExtentTest test;



    @BeforeTest
    public void startReport(){
        report = new ExtentReports(
                System.getProperty("user.dir") + "/test-output/Report.html",
                true
        );
        report
                .addSystemInfo("Host Name", "QA")
                .addSystemInfo("Tester", "Luke");
        report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-report.xml"));
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void screenShot() throws IOException, InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        test = report.startTest("Checking FTSE 100 Index");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get(" https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
        sleep(2000);
        js.executeScript("window.scrollBy(0,1000)");
        sleep(2000);
        WebElement risers = driver.findElement(By.cssSelector("#view-constituents > ul > li:nth-child(2) > a"));
        risers.click();
        sleep(2000);
        js.executeScript("window.scrollBy(0,1000)");
        File risersPicture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(risersPicture, new File(System.getProperty("user.dir") + "/test-output/risers.jpg"));
        test.log(LogStatus.PASS, "The logo was present", "<img src=risers.jpg>");
        sleep(2000);
    }

    @AfterMethod
    public void getResult(ITestResult result){
        driver.close();
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(LogStatus.FAIL, "Test has failed " + result.getName());
            test.log(LogStatus.FAIL, "Test has failed " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, "Test has passed " + result.getName());
        }
        report.endTest(test);
    }

    @AfterTest
    public void endReport(){
        report.flush();
        report.close();
    }

}



