package com.pages;

import com.utilities.Driver;
import com.utilities.DriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterForm {

    //Locators and actions on locators defined in this class for Filter form
    public FilterForm(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//div[text()='Filters']")
    WebElement filters_text;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement filter_from;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement filter_to;


    @FindBys({
        @FindBy(xpath = "//input[@type='checkbox']")

    })
    private List<WebElement> checkboxes;

    //Beds locator
    @FindBy(xpath = "((//div[text()='Rooms and beds']//following-sibling::div)[1]//button)[1]")
    private WebElement beds_decrease;

    @FindBy(xpath = "((//div[text()='Rooms and beds']//following-sibling::div)[1]//button)[2]")
    private WebElement beds_increase;

    @FindBy(xpath = "(//div[text()='Rooms and beds']//following-sibling::div//div//div//span)[1]")
    private WebElement beds_value;

    //Bedrooms locator
    @FindBy(xpath = "((//div[text()='Rooms and beds']//following-sibling::div)[2]//button)[1]")
    private WebElement bedrooms_decrease;

    @FindBy(xpath = "((//div[text()='Rooms and beds']//following-sibling::div)[2]//button)[2]")
    private WebElement bedrooms_increase;

    @FindBy(xpath = "(//div[text()='Rooms and beds']//following-sibling::div//div//div//span)[2]")
    private WebElement bedrooms_value;

    //bathrooms locator
    @FindBy(xpath = "((//div[text()='Rooms and beds']//following-sibling::div)[3]//button)[1]")
    private WebElement bathrooms_decrease;

    @FindBy(xpath = "((//div[text()='Rooms and beds']//following-sibling::div)[3]//button)[2]")
    private WebElement bathrooms_increase;

    @FindBy(xpath = "(//div[text()='Rooms and beds']//following-sibling::div//div//div//span)[3]")
    private WebElement bathrooms_value;



    public Boolean isEnabled(String inputName){
        boolean check = false;
        if(inputName.equalsIgnoreCase("from")){
            filter_from.isEnabled();
        }else if(inputName.equalsIgnoreCase("to")){
            filter_to.isEnabled();
        }
        return false;
    }

    public Boolean isFiltersTextDisplayed(){
        DriverWait.elementVisibility(filters_text,5);
        return filters_text.isDisplayed();
    }

    public List<Boolean> amenities_checkbox(){
        //I was not able to use Select class from Selenium which is more useful.All checkboxes designed in div block, and I used regular way to check checkboxes
        List<Boolean> check = new ArrayList<>();
        //Loop will iterate inside checkbox and check all boxes then validate if boxes selected and then put the result in the list in order to validate later on
        for(int i = 1; i <= checkboxes.size();i++){
            boolean checkSelected = false;
            String element = "(//input[@type='checkbox']/parent::label)" + "[" + i +"]";
            Driver.getDriver().findElement(By.xpath(element)).click();
            element = "(//input[@type='checkbox'])" + "[" + i +"]";
            checkSelected = Driver.getDriver().findElement(By.xpath(element)).isSelected();
            check.add(checkSelected);
        }
        return check;
    }

    public int roomAndBedsIncreaseButton(String option){
        int total = 0;
        if(option.equalsIgnoreCase("beds")){
            increase(beds_increase);
            total = Integer.parseInt(beds_value.getText());
        }else if(option.equalsIgnoreCase("bedrooms")){
            increase(bedrooms_increase);
            total = Integer.parseInt(bedrooms_value.getText());
        }else if(option.equalsIgnoreCase("bathrooms")){
            increase(bathrooms_increase);
            total = Integer.parseInt(bathrooms_value.getText());
        }
        return total;
    }

    public int roomAndBedsDecreaseButton(String option){
        int total = 10;
        if(option.equalsIgnoreCase("beds")){
            decrease(beds_decrease);
            total = Integer.parseInt(beds_value.getText());
        }else if(option.equalsIgnoreCase("bedrooms")){
            decrease(bedrooms_decrease);
            total = Integer.parseInt(bedrooms_value.getText());
        }else if(option.equalsIgnoreCase("bathrooms")){
            decrease(bathrooms_decrease);
            total = Integer.parseInt(bathrooms_value.getText());
        }
        return total;
    }

    public void increase(WebElement element){
        for(int i = 1; i <= 10; i++){
            element.click();
        }
    }

    public void decrease(WebElement element){
        int count = 0;
        for(int i = 10; i >= 0; i--){
            element.click();
        }
    }



}
