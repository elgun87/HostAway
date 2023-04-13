package com.runner;

import com.base.BaseTest;
import com.pages.FilterForm;
import com.utilities.BrowserScroll;
import com.utilities.ConfigurationsReader;
import com.utilities.Driver;
import com.utilities.DriverWait;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class HostAwayTest extends BaseTest {


    @Test(priority = 1, description = "Validate Price Entry Fields")
    @Severity(SeverityLevel.MINOR)
    @Epic("EPIC001")
    @Feature("Feature 1: Validate Price Entry Fields")
    @Story("Story: Validate Price Entry Fields")
    @Step("Validate Price Entry Fields")
    public void validatePriceEntryFields() {
        //Validate title
        String actualTitle = ConfigurationsReader.getProperty("actualTitle");
        String expectedTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        dashboardPage.searchClick();
        searchPage.click_filter_button();
        softAssert.assertTrue(filterForm.isFiltersTextDisplayed());
        softAssert.assertFalse(filterForm.isEnabled("from"));
        softAssert.assertFalse(filterForm.isEnabled("to"));

    }

    @Test(priority = 3, description = "Validate all checkboxes")
    @Severity(SeverityLevel.MINOR)
    @Epic("EPIC002")
    @Feature("Feature 2: Validate all checkboxes")
    @Story("Story: Validate all checkboxes")
    @Step("Validate all checkboxes")
    public void verifyAmenitiesFields() {
        List<Boolean> amenities = filterForm.amenities_checkbox();
        softAssert.assertTrue(amenities.contains(true), " All checkboxes checked");
        amenities = filterForm.amenities_checkbox();
        softAssert.assertTrue(amenities.contains(false), " All checkboxes unchecked");
    }

    @Test(priority = 2, description = "Validate beds buttons")
    @Severity(SeverityLevel.MINOR)
    @Epic("EPIC003")
    @Feature("Feature 3: Validate beds buttons")
    @Story("Story: Validate beds buttons")
    @Step("Validate beds buttons")
    public void verifyBeds() {
        //Verify increase button
        int expectedMaxVal = Integer.parseInt(ConfigurationsReader.getProperty("maxVal"));
        int actualMaxVal = filterForm.roomAndBedsIncreaseButton("beds");
        softAssert.assertEquals(expectedMaxVal, actualMaxVal);
        //Verify decrease button
        int expectedMinVal = Integer.parseInt(ConfigurationsReader.getProperty("maxVal"));
        int actualMinVal = filterForm.roomAndBedsDecreaseButton("beds");
        softAssert.assertEquals(expectedMaxVal, actualMaxVal);
    }

    @Test(priority = 4, description = "Validate bedrooms buttons")
    @Severity(SeverityLevel.MINOR)
    @Epic("EPIC004")
    @Feature("Feature 4: Validate bedrooms buttons")
    @Story("Story: Validate bedrooms buttons")
    @Step("Validate bedrooms buttons")
    public void verifyBedrooms() {
        //Verify increase button
        int expectedMaxVal = Integer.parseInt(ConfigurationsReader.getProperty("maxVal"));
        int actualMaxVal = filterForm.roomAndBedsIncreaseButton("bedrooms");
        softAssert.assertEquals(expectedMaxVal, actualMaxVal);
        //Verify decrease button
        int expectedMinVal = Integer.parseInt(ConfigurationsReader.getProperty("maxVal"));
        int actualMinVal = filterForm.roomAndBedsDecreaseButton("bedrooms");
        softAssert.assertEquals(expectedMaxVal, actualMaxVal);
    }

    @Test(priority = 5, description = "Validate bathrooms buttons")
    @Severity(SeverityLevel.MINOR)
    @Epic("EPIC005")
    @Feature("Feature 5: Validate bathrooms buttons")
    @Story("Story: Validate bathrooms buttons")
    @Step("Validate bedrooms buttons")
    public void verifyBathrooms() {
        //Verify increase button
        int expectedMaxVal = Integer.parseInt(ConfigurationsReader.getProperty("maxVal"));
        int actualMaxVal = filterForm.roomAndBedsIncreaseButton("bathrooms");
        softAssert.assertEquals(expectedMaxVal, actualMaxVal);
        //Verify decrease button
        int expectedMinVal = Integer.parseInt(ConfigurationsReader.getProperty("maxVal"));
        int actualMinVal = filterForm.roomAndBedsDecreaseButton("bathrooms");
        softAssert.assertEquals(expectedMaxVal, actualMaxVal);
    }

    @Test(priority = 6, description = "Validate clear all button")
    @Severity(SeverityLevel.MINOR)
    @Epic("EPIC006")
    @Feature("Feature 6: Validate clear all button")
    @Story("Story: Validate clear all button")
    @Step("Validate clear all button")
    public void verifyClearAllButton() {
        //Verify clear all button
        filterForm.roomAndBedsIncreaseButton("beds");
        filterForm.roomAndBedsIncreaseButton("bedrooms");
        filterForm.roomAndBedsIncreaseButton("bathrooms");
        filterForm.amenities_checkbox();
        filterForm.filter_click_clear_button();
        //Verify if all checkboxes unchecked
        softAssert.assertTrue(new FilterForm().verify_checkboxes_unchecked().contains(false));
        filterForm.filter_close();

    }


    @Test(priority = 7, description = "Validate all listings")
    @Severity(SeverityLevel.MINOR)
    @Epic("EPIC006")
    @Feature("Feature 6: Validate all listings")
    @Story("Story: Validate all listings")
    @Step("Validate all listings")
    public void verifyAllListings() throws InterruptedException {
        dashboardPage.click_all_listings();
        String actualTitle = dashboardPage.getActualTitle();
        String expectedTitle = ConfigurationsReader.getProperty("allListingTitle");
        softAssert.assertEquals(actualTitle,expectedTitle);
        DriverWait.elementVisibility(all_listings.mexico);
        while (true){
            try {
                if(all_listings.kamilTestingListing.isDisplayed()){
                    int expectedTotalList = all_listings.get_all_listing();
                    int actualTotalList = Integer.parseInt(ConfigurationsReader.getProperty("totalList"));
                    softAssert.assertEquals(expectedTotalList,actualTotalList);
                    break;
                }
            }catch (Exception e){
                BrowserScroll.scrollDown(1500);
            }
        }
    }

}
