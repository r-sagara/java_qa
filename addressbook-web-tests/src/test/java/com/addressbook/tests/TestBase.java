package com.addressbook.tests;

import com.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws Exception {
        app.init();
    }

    @AfterClass
    public void tearDown() throws Exception {
        app.stop();
    }

}
