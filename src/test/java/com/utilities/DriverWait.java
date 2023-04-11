package com.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class DriverWait {

    private static WebDriverWait webDriverWait;

    public static void elementVisibility(WebElement element,int time){
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
