package com.base;

import com.utilities.ConfigurationsReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.utilities.Driver;
import org.testng.asserts.SoftAssert;

public class BaseTest extends BaseClass {

    String url = ConfigurationsReader.getProperty("url");
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(url);
        softAssert = new SoftAssert();
    }


    @AfterClass
    public void tearDown(){
        Driver.getDriver().quit();
        softAssert.assertAll();
    }

}