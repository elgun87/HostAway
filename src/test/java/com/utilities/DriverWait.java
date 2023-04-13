package com.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class DriverWait {

    static WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));


    public static void elementVisibility(WebElement element)
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
