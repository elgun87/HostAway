package com.utilities;

import org.openqa.selenium.JavascriptExecutor;

public class BrowserScroll {
    public static void scrollDown(int byPixel){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scrollBy(0,"+byPixel+")");
    }
}
