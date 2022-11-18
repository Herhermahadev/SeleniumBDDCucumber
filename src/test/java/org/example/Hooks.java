package org.example;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.example.driver.DriverManager;

public class Hooks {

    DriverManager driverManager = new DriverManager();

    @Before
    public void setUp() throws IllegalAccessException {
        driverManager.runFromLocalBrowser();
        driverManager.goToUrl();
        driverManager.maxBrowser();
        driverManager.applyImplicitlywait();
    }

    @After
    public void teardown(){
     driverManager.closeBrowser();
    }
}

