package com.addressbook.tests.group;

import com.addressbook.model.GroupData;
import com.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreationTests() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test2");

        app.group().create(group);
        app.goTo().groupPage();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
