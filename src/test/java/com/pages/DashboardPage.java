package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.Driver;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button/span[text()='Search']")
    private WebElement search;

    @FindBy(xpath = "//a[text()='All listings']")
    private WebElement all_Listings;

    public void searchClick(){
        search.click();
    }

    public void click_all_listings(){
        all_Listings.click();
    }

    public String getActualTitle(){
        return Driver.getDriver().getTitle();
    }
}
