package com.utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class AllureListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment
    public byte [] saveFailureScreenShot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


    @Attachment(value = "{0}" , type = "{text/plain}")
    public static String saveTextLog(String message){
        return message;
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("I am onStart method " + context.getName());
        context.setAttribute("WebDriver", Driver.getDriver());
    }


    @Override
    public void onFinish(ITestContext context) {
        System.out.println("I am finished method " + context.getName());
        context.setAttribute("WebDriver", Driver.getDriver());
    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(result));
    }


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(result) + " failed");
        Object testClass = result.getInstance();
        WebDriver driver = Driver.getDriver();
        // Allure ScreenShot and SaveTestLog
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(result));
            saveFailureScreenShot(driver);
        }
        saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("I am in onTestSkipped method " + getTestMethodName(result) + " skipped");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("I am in onTestStart method " + getTestMethodName(result) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("I am in onTestSuccess method " + getTestMethodName(result) + " succeed");
    }
}
