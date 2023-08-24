package practice_.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersUtil implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {
    @Override
    public void onStart(ITestContext context) { //Similar to @BeforeSuite
        System.out.println("onStart: executes ONCE before ALL test cases(@Test) : " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) { //Similar to @AfterSuite
        System.out.println("onFinish: executes ONCE after ALL test cases(@Test) : " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart: executes before EACH test cases(@Test) : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess: executes ONCE after EACH PASSING test cases(@Test) : " + result.getName());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped: executes ONCE after EACH Skipped/Ignored test cases(@Test) : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure: executes ONCE after EACH FAILED test cases(@Test) : " + result.getName());
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Retry failed test cases automatically a given number of times
    private int retryCount = 0;
    private static final int maxRetryCount = 1;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    //    IIAnnotationTransformer method is added
    //    This makes the failed test cases automatically rerun using testng xml files
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(ListenersUtil.class);
    }
}
