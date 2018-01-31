package com.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDelete() {
        app.gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }
}
