package com.addressbook.tests;

import com.addressbook.model.GroupData;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreationTests() {
        app.gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}
