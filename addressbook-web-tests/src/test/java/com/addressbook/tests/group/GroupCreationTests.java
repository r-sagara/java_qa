package com.addressbook.tests.group;

import com.addressbook.model.GroupData;
import com.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreationTests() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();

        app.getGroupHelper().createGroup(new GroupData("header1",null,null));
        app.getNavigationHelper().gotoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }

}
