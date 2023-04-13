package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class All_Listings {
    public All_Listings(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='All']")
    public WebElement all_Listings_all;

    @FindBys({
            @FindBy(xpath = "//div[@class='sc-gSYDnn wmfak']")
    })
    private List<WebElement> total_list;

    @FindBy(xpath = "//h3[starts-with(text(),'Mexico')]")
    public WebElement mexico;

    @FindBy(xpath = "//h3[starts-with(text(),'KamilTest')]")
    public WebElement kamilTestingListing;

    public int get_all_listing(){
        return total_list.size();
    }

}
