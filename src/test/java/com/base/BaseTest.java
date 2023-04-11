package com.base;

import com.utilities.ConfigurationsReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.utilities.Driver;

public class BaseTest extends BaseClass {

    String url = ConfigurationsReader.getProperty("url");

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(url);
    }


    @AfterClass
    public void tearDown(){
        Driver.getDriver().quit();
    }

}