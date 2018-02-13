package com.addressbook.tests.group;

import com.addressbook.model.GroupData;
import com.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("name1", "header1", "footer1"));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
    }
}

