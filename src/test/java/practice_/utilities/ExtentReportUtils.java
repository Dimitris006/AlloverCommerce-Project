package practice_.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.IOException;
import java.util.Random;
import static practice_.utilities.MediaUtils.takeScreenshotOfTheEntirePageAsString;

public class ExtentReportUtils {

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter extentSparkReporter; //version 5
    protected static ExtentTest extentTest;

    /*****************************************************************
                    Still STUCK 🤔??

     I've tried to explain the steps below with example usage.
     Check out US07_TC class to see example of how to us.

     /*****************************************************************
                    STEP 1. Setup file name
     ******************************************************************
     * @REQUIREMENT: use this in @BeforeSuite                         *
     *                                                                *
     * @USAGE: ExtentReportUtils.screenshotFilePathName()             *
     ******************************************************************/
    public static void screenshotFilePathName(String fileName) {

        //Will generate a 6 character hexadecimal code to make your file unique
        //This will go after the custom name you define for the screenshot
        //More readable and just looks better (I don't like long numbers 😉)

        Random rand = new Random();
        int num = rand.nextInt(0xffffff + 1);
        String hexCode = String.format("#%06x", num);

        /*****************************************************************
         * This method uses a single parameter, which is the fileName     *
         * you need to pass a single argument and this will be the name   *
         * of your file e.g. screenshotFilePathName(AlloverCommerce)      *
         * this will create the path with that name                       *
         * and to make this file more unique and prevent conflicts, a 6   *
         * character hexadecimal code is added after the name. It will    *
         * look a bit like this:                                          *
         *                                                                *
         *           AlloverCommerce_#a30822_extent_reports.html          *
         ******************************************************************/

        String customFileName = fileName + "_" + hexCode + "_";
        String path = System.getProperty("user.dir")+"/test-output/Reports/"+customFileName+"extent_reports.html";

        //Create the HTML template using extent spark reporter in the path
        extentSparkReporter = new ExtentSparkReporter(path);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    /******************************************************************
                    STEP 2. CUSTOM SYSTEM INFO
     ******************************************************************
     * @REQUIREMENT: use this in @BeforeSuite                         *
     *                                                                *
     * @USAGE: extentReportUtils.addCustomSystemInfo(                 *
     *                 "Application Name",                            *
     *                 "Allover Commerce Website"                     *
     *         );                                                     *
     * -------------------------------------------------------------- *
     * -------------------------------------------------------------- *
     * @param key   - will take the title of what you want to show    *
     * @param value - will show the value for that title              *
     * -------------------------------------------------------------- *
     *              EXAMPLE USAGE                                     *
     * -------------------------------------------------------------- *
     * > These will appear as extra information on the report         *
     * -------------------------------------------------------------- *
     *              Other things you could include                    *
     * -------------------------------------------------------------- *
     * - Test Environment (e.g. Regression)                           *
     * - Browser (e.g. Chrome)                                        *
     * - Team Name (e.g. Gryffindor)                                  *
     * - SQA (Person or team that conducted the test)                 *
     * - Feature Number (this could be a test id or issue number)     *
     ******************************************************************/
    public void addCustomSystemInfo(String key, String value) {
        extentReports.setSystemInfo(key, value);
    }

    /******************************************************************
                    STEP 3. CREATE REPORT NAME + DOC TITLE
     ******************************************************************
     * @REQUIREMENT: use this in @BeforeSuite                         *
     *                                                                *
     * @USAGE: extentReportUtils.setReportInfo(                       *
     *                 "Smoke Test Report",                           *
     *                 "Smoke Extent Reports"                         *
     *         );                                                     *
    /******************************************************************
     * This method allows you to set the report name and document     *
     * title dynamically at runtime, instead of having them hardcoded *
     * in the code. You can call this method before creating your     *
     * reports, passing in the desired report name and document title *
     * as arguments. This way, you can set different report names     *
     * and document titles for different test runs.                   *
     ******************************************************************/
    public void setReportInfo(String reportName, String documentTitle) {
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
    }

    /*****************************************************************
                    STEP 4. CREATE TEST REPORT
     ******************************************************************
     /* The createTest() method of ExtentReports is used to make new   *
     * test report entries in the HTML report output. Here's what you *
     * need to know:                                                  *
     * -------------------------------------------------------------- *
     * @REQUIREMENT: use this in @BeforeSuite                         *
     *                                                                *
     * @USAGE: ExtentReportUtils.createTestReport(                    *
     *                 "Compare Product Test (US_07)",                *
     *                 "Smoke Test"                                   *
     *         );                                                     *
     * -------------------------------------------------------------- *
     * - Purpose: Makes a new test node or entry in the               *
     *            ExtentReports HTML report                           *
     *                                                                *
     * - Usage: You call it on the extentReports instance, passing    *
     *          the test name and description                         *
     ******************************************************************/
    public static void createTestReport(String name, String description){
        extentTest = extentReports.createTest(name, description);
    }

    /******************************************************************
                    STEP 5. ADD LOGGER METHODS
     ******************************************************************
     * @REQUIREMENT: use this inside @Test cases                      *
     *                                                                *
     * @USAGES:                                                       *
     *    .info() -> indicates what the step below is doing           *
     *    .pass() -> indicates a test step that has passed            *
     *    .fail() -> indicates a test step that has failed            *
     * @Examples:                                                     *
     *    ExtentReportUtils.info("Entering login credentials");       *
     *    ExtentReportUtils.pass("Sign in button is clicked");        *
     * -------------------------------------------------------------- *
     * Logger methods create detailed logs while running tests to     *
     * assist with debugging, auditing, reporting, and collecting     *
     * evidence for automating with Selenium                          *
     ******************************************************************/

    //ExtentReportUtils.pass("message") -> Marks the log as pass, and the message shows up on the report
    public static void pass(String message){
        extentTest.log(Status.PASS,message);
    }

    //ExtentReportUtils.info("message") -> Marks the log as info, and the message shows up on the report
    public static void info(String message){
        extentTest.log(Status.INFO,message);
    }

    //ExtentReportUtils.fail("message") -> Marks the log as fail, and the message shows up on the report

    public static void fail(String message){
        extentTest.log(Status.FAIL,message);
    }

    public static void warning(String message){
        extentTest.log(Status.WARNING,message);
    }

    /******************************************************************
                    STEP 6. (OPTIONAL) ADD A SCREENSHOT TO REPORT
     ******************************************************************
     * @REQUIREMENT: use this inside @Test cases                      *
     *                                                                *
     * @USAGE:  ExtentReportUtils.passAndCaptureScreenshot(           *
     *                 "Login input successful"                       *
     *          );                                                    *
     * -------------------------------------------------------------- *
    /* this is a reusable utility method to standardise logging       *
     * passed steps with screenshots in ExtentReports.                *
     ******************************************************************/

    public static void passAndCaptureScreenshot(String message)  {
        try {
            extentTest
                    .log(Status.PASS,message)
                    .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /******************************************************************
                    SAME AS ABOVE BUT FOR FAILED TEST STEPS
     ******************************************************************
     /* this is a reusable utility method to standardise logging       *
     * failed steps with screenshots in ExtentReports.                *
     ******************************************************************/
    public static void failAndCaptureScreenshot(String message)  {
        try {
            extentTest
                    .log(Status.FAIL,message)
                    .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /******************************************************************
                    STEP 7. Generate the Report
     ******************************************************************
     * @REQUIREMENT: use this in @AfterSuite                          *
     *                                                                *
     * @USAGES: ExtentReportUtils.flush();                            *
     ******************************************************************
    /* flush() is used inside @AfterSuite because it needs to come    *
     * last. It will generate the report once it has finished         *
     * collecting all the required steps                              *
     ******************************************************************/
    public static void flush(){
        extentReports.flush();
    }
}
