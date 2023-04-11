package com.pages;

import com.utilities.Driver;
import com.utilities.DriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//button/span[text()='Filter']")
    private WebElement filterButton;

    public void click_filter_button(){
        filterButton.click();
    }
}
